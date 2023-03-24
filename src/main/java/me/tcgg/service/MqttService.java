package me.tcgg.service;

public interface MqttService {

    void addTopic(String topic);

    void removeTopic(String topic);
}
