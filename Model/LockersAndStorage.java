package Model;

import Utilities.Address;

import java.util.UUID;

public class LockersAndStorage extends Land {
    // attributes pertaining to lockers and storage properties
    private int floorCount;
    private boolean isHeated, isNewConstruction;
    private double rentalCost;

    public LockersAndStorage (UUID uuid) { this.setUuid(uuid);}


    public void setFloorCount(int floorCount) {
        this.floorCount = floorCount;
    }

    public int getFloorCount() {
        return floorCount;
    }

    public boolean isHeated() {
        return isHeated;
    }

    public void setHeated(boolean heated) {
        isHeated = heated;
    }

    public double getRentalCost() {
        return rentalCost;
    }

    public void setRentalCost(double rentalCost) {
        this.rentalCost = rentalCost;
    }

    public boolean isNewConstruction() {
        return isNewConstruction;
    }

    public void setNewConstruction(boolean newConstruction) {
        isNewConstruction = newConstruction;
    }

    @Override
    public String toString() {
        return "LockersAndStorage{" +
                super.toString() +
                ", floorCount=" + floorCount +
                ", isHeated=" + isHeated +
                ", rentalCost=" + rentalCost +
                '}';
    }




    public static class Builder {
        // required attribtues for instantiation
        private UUID uuid;
        private Address address;
        private double sizeInSquareMeters, rentalCost;
        private boolean isNewConstruction, isHeated;
        private int floorCount;

        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        /**
         * copy made so reference is not shared by this method which sets the address
         *
         * @param address Address object for setting the address
         * @return the Builder class itself for chaining and easier instantiation
         */
        public Builder locatedAt(Address address) {
            this.address = new Address(address);
            return this;
        }

        public Builder costing(double rentalCost) {
            this.rentalCost = rentalCost;
            return this;
        }

        public Builder withSizeInSquareMeters(double sizeInSquareMeters) {
            this.sizeInSquareMeters = sizeInSquareMeters;
            return this;
        }

        public Builder setIsHeated(boolean isHeated) {
            this.isHeated = isHeated;
            return this;
        }

        public Builder floorsCountedAt(int floorCount) {
            this.floorCount = floorCount;
            return this;
        }

        public LockersAndStorage build() {
            LockersAndStorage lockersAndStorage = new LockersAndStorage(uuid);
            lockersAndStorage.setAddress(address);
            lockersAndStorage.setSizeInSquareMeters(sizeInSquareMeters);
            lockersAndStorage.setHeated(isHeated);
            lockersAndStorage.setFloorCount(floorCount);
            lockersAndStorage.setNewConstruction(isNewConstruction);
            lockersAndStorage.setRentalCost(rentalCost);
            return lockersAndStorage;
        }
    }


}
