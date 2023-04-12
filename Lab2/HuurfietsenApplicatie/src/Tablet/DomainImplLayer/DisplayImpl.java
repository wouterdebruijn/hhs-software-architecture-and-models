package Tablet.DomainImplLayer;

import Tablet.DomainLayer.Display;

public class DisplayImpl implements Display {
    private DisplayServer S;

    public DisplayImpl(DisplayServer s) {
        S = s;
    }

    public void display(String header, String info) {
        S.show(header, info);
    }
}
