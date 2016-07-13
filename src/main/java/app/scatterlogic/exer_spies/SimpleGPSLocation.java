package app.scatterlogic.exer_spies;

import android.content.Context;
import android.location.Location;
import java.util.ArrayList;

public class SimpleGPSLocation implements LocationReader{
    private SimpleLocation location;
    private Location lastReportedPosition;
    private ArrayList<Location> GPSLocations;
    private double failedTries;
    public SimpleGPSLocation(Context c){
        location = new SimpleLocation(c,true);

        if (!location.hasLocationEnabled()) {
            // ask the user to enable location access
            SimpleLocation.openSettings(c);
        }
        lastReportedPosition = new Location("");
    }


    @Override
    public ArrayList<Location> gpsLocations() {
        return GPSLocations;
    }

    @Override
    public Location locationNow() {
        lastReportedPosition = location.getCachedPosition();
        return lastReportedPosition;
    }

    @Override
    public boolean hasChanged() {
        Location tempLoc = location.getCachedPosition();
        return !tempLoc.equals(lastReportedPosition);
    }

    @Override
    public float speedNow() {
        return lastReportedPosition.getSpeed();
    }

    @Override
    public double longNow() {
        if ((lastReportedPosition.getLatitude()==0)&&(lastReportedPosition.getLongitude()==0)){
            failedTries = failedTries + 1;
            return failedTries;
        }else return lastReportedPosition.getLongitude();
    }

    @Override
    public double latNow() {
        return lastReportedPosition.getLatitude();
    }

    @Override
    public double altitudeNow() {
        return lastReportedPosition.getAltitude();
    }
    public void beginUpdates(){
        location.beginUpdates();
    }
    public void endUpdates(){
        location.endUpdates();
    }
}
