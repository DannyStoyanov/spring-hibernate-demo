package com.example.springhibernatedemo.rabbitmq;

import com.example.springhibernatedemo.server.ServerDataPair;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;

@Component
public class MessageListener {

    private static HashMap<ServerDataPair, Date> serversStatus;

    public MessageListener() {
        this.serversStatus = new HashMap<ServerDataPair, Date>();
    }
}
