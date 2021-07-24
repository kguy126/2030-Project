package Model;

import Utilities.Address;

import java.util.UUID;

public class LockersAndStorage {
    // attributes unique to a multiplex property
    private int floorNumber;
    
    /**
     * constructor to set the uuid of the property
     *
     * @param uuid identification for the property
     */
    public LockersAndStorage(UUID uuid) {
        this.setUuid(uuid);
    }
   
    /**
     * method for setting the floor number/level the storage is located at
     *
     * @param floorNumber integer representing the floor number
     */
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
        
    /**
     * method for getting the floor number/level the storage is located at
     *
     * @return integer representing the floor number
     */        
    public int getFloorNumber() {
        return floorNumber;
    }
    

     /**
     * method to continue representing instantiated property's attributes as a String
     *
     * @return string representation of attributes
     */
    @Override
    public String toString() {
        return "LockersAndStorage{" +
                super.toString() +
                ", floorNumber=" + floorNumber +
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
        int size, floorNumber;
        double price;
        boolean isNewConstruction;
        boolean isHeated;
        
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
         * method for setting the size of the property in square meters
         *
         * @param size double representing size of property
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder withSizeInSquareMeters(double size) {
            this.sizeInSquareMeters = size;
            return this;
           
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
         * method for setting whether or not the property is heated
         *
         * @param isHeated boolean variable representing if this property is heated
         * @return the Builder class itself for chaining and easier instantiation
         */
         public Builder setAsHeated(boolean isHeated) {
            this.isHeated = isHeated;
            return this;
        }

        /**
         * method for setting the floorNumber
         *
         * @param floorNumber integer representing the floor (level) which the locker/storage is located
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder locatedOnFloorNum(int floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }
        
        /**
         * build method to be called after setting all attributes
         * will create new ParkingSpace object and set its attributes
         * attributes are set based on that which are set in the Builder class
         * the object with set attributes is then returned
         *
         * @return an object of ParkingSpace class
         */
        public LockersAndStorage build() {
            lockersAndStorage lockersAndStorage = new LockersAndStorage(this.uuid);
            lockersAndStorage.setAddress(this.address);
            lockersAndStorage.setPrice(this.price);
            lockersAndStorage.ssetSizeInSquareMeters(this.sizeInSquareMeters);
            lockersAndStorage.setFloorNumber(this.floorNumber);
            return lockersAndStorage;
        }
    }
}
