package com.rsg.hw7beta;

public class Cam {

    private String url;
    private String location;
    private String type;
    private double latitude;
    private double longitude;

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }


    public Cam (String description, String url, String type, double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.type = type;
        this.location = description;
        setUrl(url);
    }

    private void setUrl(String url) {

        String SDOTBaseUrl = "http://www.seattle.gov/trafficcams/images/";
        String WSDOTBaseUrl = "http://images.wsdot.wa.gov/nw/";

        if (type.equals("sdot")) {
            this.url = SDOTBaseUrl + url;
        } else if (type.equals("wsdot")) {
            this.url = WSDOTBaseUrl + url;
        }

    }

    public String getUrl() {
        return this.url;
    }

    public String getLocation() {
        return this.location;
    }
}
