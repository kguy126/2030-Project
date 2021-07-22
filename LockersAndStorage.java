package Model;

import Utilities.Address;

import java.util.UUID;

public class LockersAndStorage {
    private int size, floorNumber;
    private Address address;

    public LockersAndStorage(UUID uuid) {
        this.setUuid(uuid);
    }
    
    public void setSize(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }
    
    
    @Override
    public int getFloorNumber() {
        return floorNumber;
    }

    @Override
    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    

    @Override
    public void updateMlsEntry() {
        super.updateMlsEntry();
        String toAdd = "";
        toAdd += ", Property Type: Lockers and Storage";
        toAdd += ", Size (square footage): " + this.size;
        toAdd += ", Located at floor level: " + this.floorNumber;
        this.addToMlsEntry(toAdd + " }");
    }

    public static class Builder {
        private UUID uuid;
        private Address address;
        int size, floorNumber;
        double price;
        boolean isNewConstruction;
        boolean isHeated;

        public Builder(UUID uuid) {
            this.uuid = uuid;
        }

        public Builder locatedAt(Address address) {
            this.address = address;
            return this;
        }

        public Builder pricedAt(double price) {
            this.price = price;
            return this;
        }

        public Builder sizeAt(int size) {
            this.size = size;
            return this;
        }

        public Builder setAsNewConstruct(boolean isNewConstruction) {
            this.isNewConstruction = isNewConstruction;
            return this;
        }
        
         public Builder setAsHeated(boolean isHeated) {
            this.isHeated = isHeated;
            return this;
        }

        public Builder locatedOnFloorNum(int floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }
        
        public LockersAndStorage build() {
            parkingSpace parkingSpace = new ParkingSpace(this.uuid);
            parkingSpace.setAddress(this.address);
            parkingSpace.setPrice(this.price);
            parkingSpace.setSize(this.size);
            parkingSpace.setFloorNumber(this.floorNumber);
            return lockersAndStorage;
        }
    }
}