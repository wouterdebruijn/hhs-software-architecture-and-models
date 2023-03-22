package DomainImplLayer;

import DomainLayer.Auto;
import DomainLayer.Snelheid;
import DomainLayer.SnelheidServer;

public class AutoImpl implements Auto {
    private Snelheid HuidigeSnelheid;
    private int GewensteSnelheid;
    private SnelheidServer SnelheidServer;

    public AutoImpl(SnelheidServer ss) {
        HuidigeSnelheid = new SnelheidImpl();
        GewensteSnelheid = 0;
        SnelheidServer = ss;
    }

    public SnelheidImpl snelheid() {
        return (SnelheidImpl)HuidigeSnelheid;
    }

    public void setGewensteSnelheid() {
        GewensteSnelheid = SnelheidServer.vraagSnelheid();
        naarSnelheid();
    }

    public void naarSnelheid() {
        while (HuidigeSnelheid.waarde() < GewensteSnelheid)
            HuidigeSnelheid.verhoog();
        while (HuidigeSnelheid.waarde() > GewensteSnelheid)
            HuidigeSnelheid.verlaag();
    }
}
