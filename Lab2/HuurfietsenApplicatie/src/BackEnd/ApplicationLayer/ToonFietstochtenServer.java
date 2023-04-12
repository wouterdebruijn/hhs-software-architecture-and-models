package BackEnd.ApplicationLayer;

import BackEnd.DomainLayer.Locatie;
import BackEnd.DomainLayer.Fietstocht;

import java.time.LocalDate;

public interface ToonFietstochtenServer {
        public int tid();

        public LocalDate datum();

        public void toon(Fietstocht f);

        public void toon(Locatie l);

        public void toon(String s);
}
