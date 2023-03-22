package DomainImplLayer;

import DomainLayer.Snelheid;
import InfrastructureLayer.Observer.Subject;

public class SnelheidImpl implements Snelheid, Subject {
    private int Waarde;

    public SnelheidImpl() {
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
