package org.example;

public class Offer {
    private int offerID;
    private String offerName;
    private double rateInterest;

    public int getOfferID() {
        return offerID;
    }

    public void setOfferID(int offerID) {
        this.offerID = offerID;
    }

    public String getOfferName() {
        return offerName;
    }

    public void setOfferName(String offerName) {
        this.offerName = offerName;
    }

    public double getRateInterest() {
        return rateInterest;
    }

    public void setRateInterest(double rateInterest) {
        this.rateInterest = rateInterest;
    }

    public Offer(int offerID, double rateInterest, String offerName) {
        this.offerID = offerID;
        this.rateInterest = rateInterest;
        this.offerName = offerName;
    }
    public Offer() {}

    @Override
    public String toString() {
        return "Offer{" +
                "offerID=" + offerID +
                ", offerName='" + offerName + '\'' +
                ", rateInterest=" + rateInterest +
                '}';
    }
}

