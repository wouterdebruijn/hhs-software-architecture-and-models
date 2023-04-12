package Tablet.ApplicationLayer;

public interface DisplayAttractiesServer {
    public void start(int tid);

    public boolean next();

    public void stop();

    public void getInfo(int tid, int x, int y, int radius, boolean horeca);

    public String infoString();
}
