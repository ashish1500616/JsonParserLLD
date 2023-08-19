package tokenizer;

import model.KeyValuePair;

import java.util.List;

public class NaiveTokenizer implements Tokenizer {

    @Override
    public List<KeyValuePair> tokenize(String text) {
        return null;
    }
}


/*
 *  What are the benefit of segregating Tokenizer and Parser ?
 *  -> Separation of concern. Ie single responsibility principle.
 *  -> Decoupling of these operation ensures better testing of the modules.
 *  -> Lets say instead of seperating the tokenizer logic we would have kept it in the parser itself.
 *  -> In that case if the unit test failed. We would not comprehend where is the fault either in Parser or Tokenization.
 *
 * */