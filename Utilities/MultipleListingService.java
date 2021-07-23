package Utilities;

import Console.Main;
import Model.Land;

import java.lang.reflect.Array;
import java.util.*;

public class MultipleListingService {
    private static Map<UUID, Land> storage = new HashMap<UUID, Land>();

    public static void addNewProperty(Land property) {
        storage.put(property.getUuid(), property);
    }

    public static Land searchById(UUID uuid) {
        return storage.getOrDefault(uuid, null);
    }

    public static ArrayList<Land> searchBySize(double size) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key : storage.keySet())
            if (storage.get(key).getSizeInSquareMeters() >= size) result.add(storage.get(key));
        if (result.size() == 0) return null;
        return result;
    }

    public static ArrayList<Land> searchByCountry(String country) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key: storage.keySet()) {
            if (storage.get(key).getAddressObj().getCountryName().equals(country))
                result.add(storage.get(key));
        } if (result.size() == 0) return null;
        return result;
    }

    public static ArrayList<Land> searchByProvinceOrState(String provinceOrState) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key: storage.keySet()) {
            if (storage.get(key).getAddressObj().getStateOrProvinceName().equals(provinceOrState))
                result.add(storage.get(key));
        } if (result.size() == 0) return null;
        return result;
    }

    public static ArrayList<Land> searchByCity(String city) {
        ArrayList<Land> result = new ArrayList<Land>();
        for (UUID key: storage.keySet()) {
            if (storage.get(key).getAddressObj().getCityName().equals(city))
                result.add(storage.get(key));
        } if (result.size() == 0) return null;
        return result;
    }
}
