package app.scatterlogic.exer_spies;

import android.location.Location;

import java.util.ArrayList;


public interface LocationReader {
    ArrayList<Location> gpsLocations();
    Location locationNow();
    boolean hasChanged();
    float speedNow();
    double longNow();
    double latNow();
    double altitudeNow();
}
