package Model;

import Utilities.Address;

import java.util.UUID;

public abstract class Land {
    // common attributes that are shared with all forms of Land
    private UUID uuid;
    private String mlsEntry;
    private Address address; // reference to address should not be shared
    private double sizeInSquareMeters;

    // Note: of the following methods, the ones declared final are not intended to be overridden

    /**
     * method for getting the size of the land
     *
     * @return size of land in square meters as a double
     */
    public final double getSizeInSquareMeters() {
        return sizeInSquareMeters;
    }

    /**
     * method for setting the size of the land
     *
     * @param sizeInSquareMeters size of the land in square meters
     */
    public final void setSizeInSquareMeters(double sizeInSquareMeters) {
        this.sizeInSquareMeters = sizeInSquareMeters;
    }

    /**
     * Method for getting the land
     *
     * @return a String representing the address at which the land is located
     */
    public final String getAddress() {
        return address.getAddress();
    }

    /**
     * for using the actual address object to access its methods
     * intended for use only by the subclasses hence why it is protected
     * returns a copy to avoid privacy leak
     *
     * @return Address object
     */
    protected final Address getAddressObj() {
        return new Address(address);
    }

    /**
     * method for setting the address of the land
     * the land has its OWN address (i.e., reference should not be shared)
     * hence, the method implements a copy using the copy constructor of Address class
     *
     * @param address object of Address class
     */
    public final void setAddress(Address address) {
        this.address = new Address(address);
    }

    /**
     * Get the uuid of the property/land
     *
     * @return the UUID of the property/land
     */
    public final UUID getUuid() {
        return uuid;
    }

    /**
     * Set the uuid of the property/land
     *
     * @param uuid the uuid of the property/land
     */
    public final void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    // Note: mutators for the mlsEntry String are protected
    // only the subclasses should be able to modify the mlsEntry based on their attributes

    /**
     * method for instantiating the mlsEntry string and inputting the first few attributes
     * these attributes will be shared amongst all properties
     * this allows for a client to search mls.txt using these properties if they wish
     * this method is intended to be overridden by the subsequent subclasses to add their own attributes
     */
    protected void updateMlsEntry() {
        this.mlsEntry = "{ UUID: " + this.uuid + ", ";
        this.mlsEntry += "Size: " + this.sizeInSquareMeters + " meters squared, ";
        this.mlsEntry += "Address: " + this.address.getAddress() + ", ";
    }

    /**
     * method which adds a string onto the mlsEntry String
     * this method is to be inherited and utilized by the child classes to add their own attributes
     *
     * @param addition String to add to the mlsEntry String
     */
    protected final void addToMlsEntry(String addition) {
        this.mlsEntry += addition;
    }

    /**
     * method for getting the mlsEntry for a particular object
     *
     * @return the mlsEntry String
     */
    public final String getMlsEntry() {
        return mlsEntry;
    }
}
