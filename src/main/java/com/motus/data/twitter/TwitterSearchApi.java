package com.motus.data.twitter;

import twitter4j.*;

import java.util.ArrayList;
import java.util.List;

class TwitterSearchApi implements TwitterApi{

    private final Twitter twitter;

    TwitterSearchApi(Twitter twitter) {

        this.twitter = twitter;
    }

    @Override
    public List<String> GetTweets(String searchString) {
        Query query = new Query();
        query.setQuery(searchString);
        query.resultType(Query.ResultType.recent);
        try {
            QueryResult search = twitter.search(query);
            List<Status> statuses = search.getTweets();
            List<String> tweets = new ArrayList<>();
            for (Status status : statuses) {
                tweets.add(status.getText());
            }
            return tweets;
        } catch (TwitterException e) {
            e.printStackTrace();
            return null;
        }
    }
}