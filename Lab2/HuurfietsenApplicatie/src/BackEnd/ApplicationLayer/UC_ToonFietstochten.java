package BackEnd.ApplicationLayer;

import BackEnd.DomainLayer.Locatie;
import BackEnd.DomainLayer.Fietstocht;

public class UC_ToonFietstochten {

    private ToonFietstochtenServer S;
    private Factory F;

    public UC_ToonFietstochten(ToonFietstochtenServer s, Factory f) {
        S = s;
        F = f;
    }

    public void toon() {
        int tid = S.tid();
        for (Fietstocht f : F.allFietstochten()) {
            if (f.tid() == tid) {
                S.toon(f);
            }
            S.toon("\n");
            for (Locatie l : F.allLocaties()) {
                String s1 = l.tijd().toString();
                String s2 = l.tijdStip().toString();
                if (l.tid() == tid && f.tijd().toString().equals(l.tijd().toString())) {
                    S.toon(l);
                }
            }
        }
    }
}
