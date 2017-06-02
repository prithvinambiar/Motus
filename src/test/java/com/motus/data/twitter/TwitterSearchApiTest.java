package com.motus.data.twitter;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import twitter4j.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class TwitterSearchApiTest {

    @Test
    public void should_get_tweets_for_given_search_string_using_search_api() throws TwitterException {

        Twitter twitter = mock(Twitter.class);
        QueryResult queryResult = mock(QueryResult.class);
        when(twitter.search(any(Query.class))).thenReturn(queryResult);

        TwitterApi twitterApi = new TwitterSearchApi(twitter);
        twitterApi.GetData("linux");

        ArgumentCaptor<Query> queryArgumentCaptor = ArgumentCaptor.forClass(Query.class);

        verify(twitter).search(queryArgumentCaptor.capture());
        assertEquals("linux", queryArgumentCaptor.getValue().getQuery());
    }
}
