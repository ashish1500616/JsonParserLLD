package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSON {
    private final Map<String, JSON> keyToValue;

    public JSON(Map<String, JSON> keyToValue) {
        this.keyToValue = keyToValue;
    }

    public Map<String, JSON> getKeyToValue() {
        return keyToValue;
    }

    public JSON getJSON(String key) {
        return this.keyToValue.get(key);
    }

    public List<String> getAllKeys() {
        return new ArrayList<>(keyToValue.keySet());
        /*
        or
            List<String> keys = new ArrayList<>();
            for (Map.Entry<String, JSON> jsonEntry : keyToValue.entrySet()) {
             keys.add(jsonEntry.getKey());
            }
            return keys;
        */
    }
}

/*
 * Tip:
 *   1. Never expose the data structures directly to the client if you have option to hide it.
 *      Encapsulate whatever you can.
 *      Downside of exposing the members to the clients is that,they will have to know how to handle
 *      and operate on the members which can be downside.
 *
 *   2. Follow seperation of concern when dealing with data classes.
 *      Therefore no heavy algorithmic logic should go inside the data class.
 *      if we bring the nity grity details in the data class tomorrow if we want to change
 *      anything it will not follow two important principle
 *           - Single responsibility principle.
 *           - Open closed principle.
 *      Better approach to extract these operations to abstract classes.
 * */
