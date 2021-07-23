package Model;

import Utilities.Address;

import java.util.UUID;

public class ParkingSpace {
    private String parkingType; 
    private int numParkingSpaces;
    private Address address;

    public ParkingSpace(UUID uuid) {
        this.setUuid(uuid);
    }
    
    public void setNumParkingSpaces(int numParkingSpaces) {
        this.numParkingSpaces = numParkingSpaces;
    }

    public int getNumParkingSpaces() {
        return numParkingSpaces;
    }
    
    
    @Override
    public String getParkingType() {
        return parkingType;
    }

    @Override
    public void setParkingType(String parkingType) {
        this.parkingType = parkingType;
    }
    

    @Override
    public void updateMlsEntry() {
        super.updateMlsEntry();
        String toAdd = "";
        toAdd += ", Property Type: Parking Space";
        toAdd += ", Number of avilable parking spaces: " + this.numParkingSpaces;
        toAdd += ", Parking Type: " + this.parkingType;
        this.addToMlsEntry(toAdd + " }");
    }

    public static class Builder {
        private UUID uuid;
        private Address address;
        int numParkingSpaces;
        String parkingType;
        double price;
        boolean isNewConstruction;

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

        public Builder numParkingSpacesAt(int numParkingSpaces) {
            this.numParkingSpaces = numParkingSpaces;
            return this;
        }

        public Builder setAsNewConstruct(boolean isNewConstruction) {
            this.isNewConstruction = isNewConstruction;
            return this;
        }

        public Builder withParkingType(String parkingType) {
            this.parkingType = parkingType;
            return this;
        }
        
        public ParkingSpace build() {
            parkingSpace parkingSpace = new ParkingSpace(this.uuid);
            parkingSpace.setAddress(this.address);
            parkingSpace.setPrice(this.price);
            parkingSpace.setParkingType(this.parkingType);
            parkingSpace.setNumParkingSpaces(this.numParkingSpaces);
            return parkingSpace;
        }
    }
}
