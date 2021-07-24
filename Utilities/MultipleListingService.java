package Utilities;

import Console.Main;
import Model.Land;

import java.lang.reflect.Array;
import java.util.*;

public class MultipleListingService {
    private static Map<UUID, Land> storage = new HashMap<UUID, Land>();

    /**
     * method for adding a new property to storage
     *
     * @param property object of Land class to be added to the storage of instantiated properties
     */
    public static void addNewProperty(Land property) {
        storage.put(property.getUuid(), property);
    }

    /**
     * method for finding a property in storage with specific uuid
     *
     * @param uuid search reference for finding a specific property
     * @return the Land object of the property that matches search reference
     */
    public static Land searchById(UUID uuid) {
        return storage.getOrDefault(uuid, null); // return null if no property found
    }

    /**
     * method for getting a list of properties within a certain square meter size range
     *
     * @param min minimum size to look for as a double
     * @param max maximum size to look for as a double
     * @return An array of
     */
    public static ArrayList<Land> searchBySize(double min, double max) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key : storage.keySet()) {
            if (storage.get(key).getSizeInSquareMeters() >= min && storage.get(key).getSizeInSquareMeters() <= max)
                result.add(storage.get(key));
        } if (result.size() == 0) return null; // return null if no properties found
        return result;
    }

    /**
     * method for getting a list of properties that are in a certain country
     *
     * @param country country String for search reference
     * @return the land object of the property that matches search reference
     */
    public static ArrayList<Land> searchByCountry(String country) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key: storage.keySet()) {
            if (storage.get(key).getAddressObj().getCountryName().equals(country))
                result.add(storage.get(key));
        } if (result.size() == 0) return null; // return null if no properties found
        return result;
    }

    /**
     * method for getting a list of properties that are in a certain province or state
     *
     * @param provinceOrState province or state String for search reference
     * @return the land object of the property that matches search reference
     */
    public static ArrayList<Land> searchByProvinceOrState(String provinceOrState) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key: storage.keySet()) {
            if (storage.get(key).getAddressObj().getStateOrProvinceName().equals(provinceOrState))
                result.add(storage.get(key));
        } if (result.size() == 0) return null; // return null if no properties found
        return result;
    }

    /**
     * method for getting a list of properties that are in a certain city
     *
     * @param city city String for search reference
     * @return the land object of the property that matches search reference
     */
    public static ArrayList<Land> searchByCity(String city) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key: storage.keySet()) {
            if (storage.get(key).getAddressObj().getCityName().equals(city))
                result.add(storage.get(key));
        } if (result.size() == 0) return null; // return null if no properties found
        return result;
    }
}
