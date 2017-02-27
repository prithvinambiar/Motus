package com.motus.data.twitter;

import java.util.List;

public interface TwitterApi {
    List<String> GetTweets(String searchString);
}
