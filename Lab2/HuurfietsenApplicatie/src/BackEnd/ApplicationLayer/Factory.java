package BackEnd.ApplicationLayer;

import java.util.List;

import BackEnd.DomainLayer.Attractie;
import BackEnd.DomainLayer.Fietstocht;
import BackEnd.DomainLayer.Locatie;

public interface Factory {
    public void createAttractie(Attractie attractie);
    public void createFietstocht(Fietstocht fietstocht);
    public void createLocatie(Locatie locatie);
    public List<Attractie> allAttracties();
    public List<Fietstocht> allFietstochten();
    public List<Locatie> allLocaties();
}
