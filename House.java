package Model;

import Utilities.Address;

public abstract class House extends Land implements Residential {
    // attributes which pertain to a residential house
    private int bathroomCount, bedroomCount, floorCount, parkingSpaceCount;
    private boolean isNewConstruction;
    private double price;

    /**
     * method for getting the number of bathrooms of the house
     *
     * @return an integer representing the number of bathrooms
     */
    @Override
    public int getBathroomCount() {
        return bathroomCount;
    }

    /**
     * method for setting the number of bathrooms of the house
     *
     * @param bathroomCount an integer representing the number of bathrooms
     */
    @Override
    public void setBathroomCount(int bathroomCount) {
        this.bathroomCount = bathroomCount;
    }

    /**
     * method for getting the number of bedrooms of the house
     *
     * @return the number of bedrooms as an integer
     */
    @Override
    public int getBedroomCount() {
        return bedroomCount;
    }

    /**
     * method for settting the number of bedrooms of the house
     *
     * @param bedroomCount an integer representing the number of bedrooms
     */
    @Override
    public void setBedroomCount(int bedroomCount) {
        this.bedroomCount = bedroomCount;
    }

    /**
     * method for getting the number of floors of the house
     *
     * @return the number of floors of the house represented by an integer
     */
    @Override
    public int getFloorCount() {
        return floorCount;
    }

    /**
     * method for setting the number of floors of the house
     *
     * @param floorCount an integer representing the number of floors
     */
    @Override
    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    /**
     * method for getting the number of parking spaces of the house
     *
     * @return an integer representing the number of parking spaces
     */
    @Override
    public int getParkingSpacesCount() {
        return parkingSpaceCount;
    }

    /**
     * method for setting the number of parking spaces of the house
     *
     * @param parkingSpacesCount an integer representing the number of parking spaces
     */
    @Override
    public void setParkingSpacesCount(int parkingSpacesCount) {
        this.parkingSpaceCount = parkingSpacesCount;
    }

    /**
     * method for setting the price of the house
     *
     * @param price a double representing the price
     */
    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * method for getting the price of the house
     *
     * @return an integer representing the price
     */
    @Override
    public double getPrice() {
        return price;
    }

    /**
     * method for getting whether or not this property is new
     *
     * @return boolean representing if this house is a new construction
     */
    public boolean isNewConstruction() {
        return isNewConstruction;
    }

    /**
     * method for setting whether or not this property is new
     *
     * @param newConstruction boolean representing if this house is a new construction
     */
    public void setNewConstruction(boolean newConstruction) {
        isNewConstruction = newConstruction;
    }

    /**
     * method for updating the mlsEntry String in the Land super class with this subclass' attributes
     * This class is intended to be extended and the mlsEntry will be further implemented as well
     * This class begins the mlsEntry for its subclasses
     */
    @Override
    protected void updateMlsEntry() {
        super.updateMlsEntry(); // begins string with the Land class' updateMlsEntry implementation
        String toAdd = "";
        toAdd += "Property Type: Residential House";
        toAdd += this.isNewConstruction() ? ", Is new construction" : ", Is not new construction";
        toAdd += ", Price: $" + this.getPrice();
        toAdd += ", Bedrooms: " + this.getBedroomCount();
        toAdd += ", Bathrooms: " + this.getBathroomCount();
        toAdd += ", Floors: " + this.getFloorCount();
        toAdd += ", Parking Spaces: " + this.getParkingSpacesCount();
        this.addToMlsEntry(toAdd);
    }


}