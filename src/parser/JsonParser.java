package parser;

import model.JSON;

public interface JsonParser {

    JSON parse(String jsonText);

    String toString(JSON json);
}
