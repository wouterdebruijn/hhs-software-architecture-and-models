package Cloud.Main;

import BackEnd.ApplicationLayer.UC_ToonFietstochten;
import BackEnd.ApplicationLayer.Factory;
import BackEnd.ApplicationLayer.UC_GeefInfoAttracties;
import BackEnd.ApplicationLayer.UC_RegistreerAttracties;

import BackEnd.InterfaceLayer.ToonFietstochtenServerImpl;
import BackEnd.InterfaceLayer.DaoFactory;
import BackEnd.InterfaceLayer.GeefInfoAttractiesServerImpl;
import BackEnd.InterfaceLayer.RegistreerAttractiesServerImpl;

import Cloud.InfrastructureLayer.Mqtt.MqttPaho.MqttClient;
import Cloud.InfrastructureLayer.Mqtt.MqttCommon.MqttCallback;
import Cloud.InfrastructureLayer.Mqtt.MqttCommon.MqttClientServer;

import Tablet.DomainLayer.Display;
import Tablet.DomainImplLayer.DisplayImpl;

import Tablet.ApplicationLayer.UC_DisplayAttracties;

import Tablet.InterfaceLayer.DisplayServerImpl;
import Tablet.InterfaceLayer.DisplayAttractiesServerImpl;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import static java.lang.Thread.MIN_PRIORITY;

class ChildThread extends Thread {
    private int Tid;

    public ChildThread(int tid) {
        Tid = tid;
    }

    public void run() {
        DisplayServerImpl DSI = new DisplayServerImpl();
        MqttClientServer ClientTablet = new MqttClient();
        DisplayAttractiesServerImpl ADS = new DisplayAttractiesServerImpl(Tid, DSI, ClientTablet);

        Display D = new DisplayImpl(DSI);
        UC_DisplayAttracties UCAD = new UC_DisplayAttracties(Tid, ADS, D);

        UCAD.stelInRadius(60);
        UCAD.stelInHoreca(true);

        UCAD.ga();
        ADS.cleanup();
    }
}

public class Main {

    public static void log() {
        Logger.getGlobal().setLevel(Level.OFF);
        Logger.getGlobal().addHandler(new Handler() {
            public void publish(LogRecord record) {
                System.out.println(record.getMessage());
            }

            public void flush() {
            }

            public void close() throws SecurityException {
            }
        });
        MqttClient alles = new MqttClient();
        alles.subscribe("#", new MqttCallback() {
            public void messageArrived(String topic, String message) {
                Logger.getGlobal().log(Level.FINEST, "Alles ontvangt [" + topic + "] = " + message);
            }
        });
    }

    public static void main(String[] args) throws InterruptedException {

        log();

        MqttClientServer ClientBackEnd = new MqttClient();
        Factory F = new DaoFactory();

        GeefInfoAttractiesServerImpl AIUCS = new GeefInfoAttractiesServerImpl(ClientBackEnd);
        UC_GeefInfoAttracties AUC = new UC_GeefInfoAttracties(AIUCS, F);
        AIUCS.setAiuc(AUC);

        RegistreerAttractiesServerImpl S = new RegistreerAttractiesServerImpl();
        UC_RegistreerAttracties UCR = new UC_RegistreerAttracties(S, F);
        // UCR.registreerAttractie();

        ToonFietstochtenServerImpl TFS = new ToonFietstochtenServerImpl();
        UC_ToonFietstochten UCTFT = new UC_ToonFietstochten(TFS, F);
        // UCTFT.toon();

        for (int fiets = 0; fiets < 5; fiets++) {
            ChildThread T = new ChildThread(fiets);
            T.setPriority(MIN_PRIORITY);
            T.start();
            Thread.sleep(1000);
        }
    }

}
