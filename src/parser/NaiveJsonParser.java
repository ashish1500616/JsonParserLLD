package parser;

import model.JSON;
import model.KeyValuePair;
import tokenizer.Tokenizer;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static utils.StringConstants.*;

public class NaiveJsonParser implements JsonParser {

    private Tokenizer tokenizer;

    public NaiveJsonParser(Tokenizer tokenizer) {
        this.tokenizer = tokenizer;
    }

    @Override
    public JSON parse(String jsonText) {
        if (jsonText == null) {
            throw new RuntimeException("Invalid JsonText");
        }
        // Terminal case.
        Map<String, JSON> keyToValueMap = new HashMap<>();
        if (!jsonText.contains(STARTING_PARAN_STRING)) {
            jsonText.trim().replaceAll(DOUBLE_QUOTES_STRING, EMPTY_STRING);
            keyToValueMap.put(jsonText, null);
            return new JSON(keyToValueMap);
        }
        List<KeyValuePair> keyValuePairs = this.tokenizer.tokenize(jsonText);
        for (KeyValuePair keyValuePair : keyValuePairs) {
            keyToValueMap.put(keyValuePair.getKey(), this.parse(keyValuePair.getValue()));
        }
        return new JSON(keyToValueMap);
    }

    @Override
    public String toString(JSON json) {
        String jsonText = STARTING_PARAN_STRING;
        List<String> keys = json.getAllKeys();
        for (String key : keys) {
            jsonText += DOUBLE_QUOTES_CHAR + key + DOUBLE_QUOTES_CHAR;
            jsonText += COLON;
            jsonText += toString(json.getJSON(key));
            jsonText += COMMA_CHAR;
        }
        if (jsonText.endsWith(COMMA_STRING)) {
            jsonText = jsonText.substring(0, jsonText.length() - 1);
        }
        jsonText += CLOSING_PARAN_STRING;
        return jsonText;
    }
}
