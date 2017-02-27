package com.motus.data.twitter;

import twitter4j.Twitter;

import java.util.List;

class TwitterSearchApi implements TwitterApi{

    private final Twitter twitter;

    public TwitterSearchApi(Twitter twitter) {

        this.twitter = twitter;
    }

    @Override
    public List<String> GetTweets(String searchString) {
        return null;
    }
}