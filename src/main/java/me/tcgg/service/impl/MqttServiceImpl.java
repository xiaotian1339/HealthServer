package me.tcgg.service.impl;

import me.tcgg.service.MqttService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class MqttServiceImpl implements MqttService {

    @Autowired
    private MqttPahoMessageDrivenChannelAdapter adapter;

    @Override
    public void addTopic(String topic) {
        String[] topics = adapter.getTopic();
        if(!Arrays.asList(topics).contains(topic)){
            adapter.addTopic(topic,0);
        }

    }

    @Override
    public void removeTopic(String topic) {
        adapter.removeTopic(topic);

    }
}
