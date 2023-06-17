package model;

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

}
