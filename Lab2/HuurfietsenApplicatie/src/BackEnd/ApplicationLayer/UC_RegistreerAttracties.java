package BackEnd.ApplicationLayer;

import BackEnd.DomainLayer.Attractie;
import BackEnd.DomainImplLayer.AttractieImpl;

import java.util.ArrayList;
import java.util.List;

public class UC_RegistreerAttracties {

    RegistreerAttractiesServer S;
    Factory Factory;

    static List<Attractie> AlleTransacties = new ArrayList<>();

    public static List<Attractie> all() {
        return AlleTransacties;
    }

    public UC_RegistreerAttracties(RegistreerAttractiesServer s, Factory f) {
        S = s;
        Factory = f;
    }

    public void registreerAttractie() {
        do {
            String naam = S.getNaam();
            int x = S.getX();
            int y = S.getX();
            String horeca = S.getHoreca();
            String info = S.getInfo();

            boolean horecaBool;
            if (horeca.equals("J"))
                horecaBool = true;
            else
                horecaBool = false;

            Attractie A = new AttractieImpl(naam, x, y, horecaBool, info);
            Factory.createAttractie(A);
            all().add(A);
        } while (S.next());
    }

}
