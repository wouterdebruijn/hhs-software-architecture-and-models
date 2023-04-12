package BackEnd.InterfaceLayer;

import java.util.List;

import BackEnd.ApplicationLayer.Factory;

import BackEnd.DomainLayer.Attractie;
import BackEnd.DomainLayer.Fietstocht;
import BackEnd.DomainLayer.Locatie;

import BackEnd.DAOLayer.AttractieDao;
import BackEnd.DAOLayer.FietstochtDao;
import BackEnd.DAOLayer.LocatieDao;

public class DaoFactory implements Factory {

    private final AttractieDao attractieDao = new AttractieDao();
    private final FietstochtDao fietstochtDao = new FietstochtDao();
    private final LocatieDao locatieDao = new LocatieDao();

    public void createAttractie(Attractie attractie) {
        attractieDao.insert(attractie);
    }

    public void createFietstocht(Fietstocht fietstocht) {
        fietstochtDao.insert(fietstocht);
    }

    public void createLocatie(Locatie locatie) {
        locatieDao.insert(locatie);
    }

    public List<Attractie> allAttracties() {
        return attractieDao.all();
    }

    public List<Fietstocht> allFietstochten() {
        return fietstochtDao.all();
    }

    public List<Locatie> allLocaties() {
        return locatieDao.all();
    }
}
