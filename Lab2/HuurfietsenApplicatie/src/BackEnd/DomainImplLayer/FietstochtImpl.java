package BackEnd.DomainImplLayer;

import BackEnd.DomainLayer.Locatie;
import BackEnd.DomainLayer.Fietstocht;

import java.util.ArrayList;
import java.util.List;
import java.time.LocalDateTime;

public class FietstochtImpl implements Fietstocht {

    private int Tid;
    private LocalDateTime Tijd;

    private static List<Locatie> LocatieLijst = new ArrayList<>();

    public FietstochtImpl(LocalDateTime t, int tid) {
        Tid = tid;
        Tijd = t;
    }

    public int tid() {
        return Tid;
    }

    public LocalDateTime tijd() {
        return Tijd;
    }

    public void voegLocatieToe(LocalDateTime t, int x, int y) {
        Locatie L = new LocatieImpl(Tid, Tijd, t, x, y);
        LocatieLijst.add(L);
    }

    public static List<Locatie> locaties() {
        return LocatieLijst;
    }
}
