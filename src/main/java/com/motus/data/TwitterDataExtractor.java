package com.motus.data;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.event.Event;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.auth.OAuth1;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

class TwitterDataExtractor implements DataExtractor {
    public List<String> GetData() {
        StatusesFilterEndpoint hosebirdEndpoint = new StatusesFilterEndpoint();
        List<String> terms = Lists.newArrayList("prithvi");
        hosebirdEndpoint.trackTerms(terms);

        BlockingQueue<Event> eventQueue = new LinkedBlockingQueue<>(1000);
        BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>(100000);

        ClientBuilder builder = new ClientBuilder()
                .name("Hosebird-Client-01")                              // optional: mainly for the logs
                .hosts(new HttpHosts(Constants.STREAM_HOST))
                .authentication(new OAuth1("qUWXYzdvEM5omsrbdjM2342xx", "5vDZsvMiQd9BO8I6glUV2GqjA6QeE0tYJNXhLRW6mv1E2N5Iy5", "380237324-P2iSbWTxywPV0Fjz8ag1JSHvvw1AGJnNgQFVyXzQ", "UzcpfTJLufzCzI1f6xKaq2eMSaDJg8orppuxJwW7GSbth"))
                .endpoint(hosebirdEndpoint)
                .processor(new StringDelimitedProcessor(msgQueue))
                .eventMessageQueue(eventQueue);                          // optional: use this if you want to process client events

        Client hosebirdClient = builder.build();
// Attempts to establish a connection.
        hosebirdClient.connect();


        while (!hosebirdClient.isDone()) {
            String msg = null;
            try {
                msg = msgQueue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(msg);
        }
        return null;
    }
}
