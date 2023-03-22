package DomainLayer;

public class Auto {
    private Snelheid HuidigeSnelheid;
    private int GewensteSnelheid;
    private SnelheidServer SnelheidServer;

    public Auto(SnelheidServer ss) {
        HuidigeSnelheid = new Snelheid();
        GewensteSnelheid = 0;
        SnelheidServer = ss;
    }

    public Snelheid snelheid() {
        return HuidigeSnelheid;
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
