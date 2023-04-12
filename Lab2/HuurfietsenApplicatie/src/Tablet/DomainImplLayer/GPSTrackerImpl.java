package Tablet.DomainImplLayer;

import Tablet.DomainLayer.GPSTracker;

public class GPSTrackerImpl implements GPSTracker {
    public int getX() {
        return (int) (Math.random() * 100 + 1);
    }

    public int getY() {
        return (int) (Math.random() * 100 + 1);
    }
}
