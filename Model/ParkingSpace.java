package Model;

import Utilities.Address;

import java.util.UUID;

public class ParkingSpace {
    // attributes unique to a parking space property
    private String parkingType; 
    private int numParkingSpaces;

    /**
     * constructor which will set the uuid
     * method will also set the floorCount as 3 as it is a triple decker
     *
     * @param uuid identification for the property
     */
    public ParkingSpace(UUID uuid) {
        this.setUuid(uuid);
    }
    
    /**
     * method for setting how many parking space are avilaible for sale on the listing 
     * the method must take a numParkingSpaces of more than 1
     * violating this condition will cause an error
     *
     * @param numParkingSpaces integer representing number of parking spots 
     */
    public void setNumParkingSpaces(int numParkingSpaces) {
        if (numParkingSpaces <= 1) throw new IllegalArgumentException("The lisitng must include atleast one parking space.");
        this.numParkingSpaces = numParkingSpaces;
    }

    /**
     * method for getting the number of parking spaces
     *
     * @return integer representing number of parking spaces for sale
     */
    public int getNumParkingSpaces() {
        return numParkingSpaces;
    }
    
    /**
     * method for getting the type of parking space (i.e., underground, garage, etc.)
     *
     * @return string representing the type of parking
     */
    @Override
    public String getParkingType() {
        return parkingType;
    }
    
     /**
     * method for getting the type of parking space (i.e., underground, garage, etc.)
     *
     * @param parkingType string representing the type of parking
     */
    @Override
    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }
    
     /**
     * method to continue representing instantiated property's attributes as a String
     *
     * @return string representation of attributes
     */
    @Override
    public String toString() {
        return "ParkingSpace{" +
                super.toString() +
                ", parkingType=" + parkingType +
                ", numParkingSpaces=" + numParkingSpaces +
                '}';
    }

    /**
     * this class is meant to be instantiated (as its not an abstract)
     * a builder design patterns with all the required attributes is therefore implemented
     * this allows for more simple instantiation for the client
     */
    public static class Builder {
        // required attributes for instantiation
        private UUID uuid;
        private Address address;
        int numParkingSpaces;
        String parkingType;
        double price;
        boolean isNewConstruction;

        /**
         * constructor of Builder class to start with implementing the uuid
         *
         * @param uuid identification for the property
         */
        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * copy made so refrence is not shared by this method which sets the address
         *
         * @param address Address object for setting the address
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder locatedAt(Address address) {
            this.address = address;
            return this;
        }
        
        /**
         * method for setting price
         *
         * @param price double representing price of property
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder pricedAt(double price) {
            this.price = price;
            return this;
        }
         
        /**
         * method for setting the numParkingSpaces
         *
         * @param numParkingSpaces integer for storing the number of parking spaces
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder numParkingSpacesAt(int numParkingSpaces) {
            this.numParkingSpaces = numParkingSpaces;
            return this;
        }
        
        /**
         * method for setting whether or not the property is new
         *
         * @param isNewConstruction boolean variable representing if this property is newly constructed
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder setAsNewConstruct(boolean isNewConstruction) {
            this.isNewConstruction = isNewConstruction;
            return this;
        }

        /**
         * method for setting the max type of parking space, i.e. underground, garage, etc. 
         *
         * @param parkingType string 
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder withParkingType(String parkingType) {
            this.parkingType = parkingType;
            return this;
        }
        
        /**
         * method for setting the size of the property in square meters
         *
         * @param size double representing size of property
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder withSizeInSquareMeters(double size) {
            this.sizeInSquareMeters = size;
            return this;
            
         /**
         * build method to be called after setting all attributes
         * will create new ParkingSpace object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of ParkingSpace class
         */
        
        public ParkingSpace build() {
            parkingSpace parkingSpace = new ParkingSpace(this.uuid);
            parkingSpace.setAddress(this.address);
            parkingSpace.setPrice(this.price);
            parkingSpace.setParkingType(this.parkingType);
            parkingSpace.setSizeInSquareMeters(this.sizeInSquareMeters);
            parkingSpace.setNumParkingSpaces(this.numParkingSpaces);
            return parkingSpace;
        }
    }
}
