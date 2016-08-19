package com.tsp.ga;

/**
 * Created by sarja on 8/19/2016.
 */
public class City {

    private static final double EARTH_EQUATORIAL_RADIUS = 6378.1370D;
    private static final double CONVERT_DEGREE_TO_RADIANS = Math.PI/180D;
    private static final double CONVERT_KM_TO_MILES = 0.621371;

    private double longitude;
    private double latitude;
    private String name;

    public City(double longitude, double latitude, String name) {
        this.longitude = longitude * CONVERT_DEGREE_TO_RADIANS;
        this.latitude = latitude * CONVERT_DEGREE_TO_RADIANS;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public double getLongitude() {
        return this.longitude;
    }

    public double getLatitude() {
        return this.latitude;
    }

    @Override
    public String toString() {
        return getName();
    }

    public double measureDistance(City city){

        double deltaLongitude = city.getLongitude()-this.getLongitude();
        double deltaLatitude = city.getLatitude()-this.getLatitude();
        double a = Math.pow(Math.sin(deltaLatitude/2D), 2D) + Math.cos(this.getLatitude()) * Math.cos(city.getLatitude()) * Math.pow(Math.sin(deltaLongitude/2D),2D);

        return CONVERT_KM_TO_MILES * EARTH_EQUATORIAL_RADIUS * 2D * Math.atan2(Math.sqrt(a),Math.sqrt(1D - a));
    }

}
