package com.motus.data.twitter;

import org.junit.Test;
import twitter4j.*;

import java.util.List;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.isA;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class TwitterSearchApiTest {
    @Test
    public void should_get_tweets_for_given_search_string_using_search_api() throws TwitterException {
        Query query = new Query();
        query.setQuery("prithvi");
        query.resultType(Query.ResultType.recent);
        Twitter twitter = new TwitterFactory().getInstance();
        QueryResult search = twitter.search(query);

        Twitter mock = mock(Twitter.class);

        TwitterApi twitterApi = new TwitterSearchApi(mock);
        List<String> tweets = twitterApi.GetTweets("linux");

        verify(mock).search(isA(Query.class));

    }
}
