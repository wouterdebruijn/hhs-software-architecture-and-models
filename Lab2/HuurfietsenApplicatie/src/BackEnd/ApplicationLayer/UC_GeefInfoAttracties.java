package BackEnd.ApplicationLayer;

import BackEnd.DomainLayer.Attractie;
import BackEnd.DomainLayer.Fietstocht;
import BackEnd.DomainImplLayer.FietstochtImpl;

import java.time.LocalDateTime;

public class UC_GeefInfoAttracties {

    GeefInfoAttractiesServer Server;
    Fietstocht Tocht;
    Factory Factory;

    public UC_GeefInfoAttracties(GeefInfoAttractiesServer s, Factory f) {
        Server = s;
        Factory = f;
        laadAttracties();
    }

    public void laadAttracties() {
        UC_RegistreerAttracties.all().clear();
        for (Attractie a : Factory.allAttracties()) {
            UC_RegistreerAttracties.all().add(a);
        }
    }

    public void start(int tid) {
        Tocht = new FietstochtImpl(LocalDateTime.now(), tid);
        Factory.createFietstocht(Tocht);
    }

    public String getInfo(int tid, String tabletMessage) {

        String[] bericht = tabletMessage.split(",");
        int x = Integer.parseInt(bericht[0]);
        int y = Integer.parseInt(bericht[1]);
        int Radius = Integer.parseInt(bericht[2]);
        int Horeca = Integer.parseInt(bericht[3]);

        Tocht.voegLocatieToe(LocalDateTime.now(), x, y);

        String infoString = "";
        for (Attractie a : UC_RegistreerAttracties.all()) {
            if ((x - a.x()) * (x - a.x()) + (y - a.y()) * (y - a.y()) < Radius * Radius &&
                    (!a.isHoreca() || (a.isHoreca() && Horeca == 1)))
                infoString += a.naam() + ": " + a.info() + "\n";
        }
        if (infoString == "")
            infoString = "Helaas geen attractie in de omgeving.\n";

        Server.setId(tid);
        Server.getInfo(infoString); // Dit is een beetje raar: in de callback meteen publish....
        return infoString;
    }

    public void stop(int tid) {
        // Factory.createLocatie(null);
        /*
         * for (Locatie l : FietstochtImpl.locaties()) {
         * ldao.insert(l);
         * }
         */

    }
}
