package DomainLayer;

import InfrastructureLayer.Observer.Subject;

public class Snelheid implements Subject {
    private int Waarde;

    public Snelheid() {
        Waarde = 0;
        this.notifyObservers();
    }

    public int waarde() {
        return Waarde;
    }

    public void verhoog() {
        Waarde++;
        this.notifyObservers();
    } // Simulatie

    public void verlaag() {
        Waarde--;
        this.notifyObservers();
    } // Simulatie
}
