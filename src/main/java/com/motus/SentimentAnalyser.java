package com.motus;

import edu.stanford.nlp.simple.Sentence;
import edu.stanford.nlp.simple.SentimentClass;

class SentimentAnalyser
{
    SentimentClass analyse(String text){
        Sentence sentence = new Sentence(text);
        return sentence.sentiment();
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }
}