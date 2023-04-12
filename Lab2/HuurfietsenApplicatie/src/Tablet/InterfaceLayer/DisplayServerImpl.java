package Tablet.InterfaceLayer;

import Tablet.DomainImplLayer.DisplayServer;

public class DisplayServerImpl implements DisplayServer {

    public void show(String header, String info) {
        System.out.println("Fiets " + header + ": ----------------------------\n" + info);
    }
}
