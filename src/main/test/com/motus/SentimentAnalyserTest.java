package com.motus;

import edu.stanford.nlp.simple.SentimentClass;
import org.junit.Assert;
import org.junit.Test;

public class SentimentAnalyserTest {
    @Test
    public void should_find_sentiment_for_given_sentence() throws Exception {
        SentimentAnalyser sentimentAnalyser = new SentimentAnalyser();
        SentimentClass sentimentClass = sentimentAnalyser.analyse("I am from india");
        Assert.assertTrue(sentimentClass != null);
    }

}