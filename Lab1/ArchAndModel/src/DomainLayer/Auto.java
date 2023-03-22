package DomainLayer;

import java.util.Scanner;

public class Auto {
    private Snelheid HuidigeSnelheid;
    private int GewensteSnelheid;

    public Auto() {
        HuidigeSnelheid = new Snelheid();
        GewensteSnelheid = 0;
    }

    public Snelheid snelheid() {
        return HuidigeSnelheid;
    }

    public void setGewensteSnelheid() {
        System.out.println("Voer de gewenste snelheid in: ");
        Scanner S = new Scanner(System.in);
        GewensteSnelheid = S.nextInt();
        naarSnelheid();
    }

    public void naarSnelheid() {
        while (HuidigeSnelheid.waarde() < GewensteSnelheid)
            HuidigeSnelheid.verhoog();
        while (HuidigeSnelheid.waarde() > GewensteSnelheid)
            HuidigeSnelheid.verlaag();
    }
}
