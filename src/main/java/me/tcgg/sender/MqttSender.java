package me.tcgg.sender;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.mqtt.support.MqttHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
@MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
public interface MqttSender {
    void sendToMqtt(String text);

    void sendWithTopic(@Header(MqttHeaders.TOPIC) String topic, String text);

    void sendWithTopicAndQos(@Header(MqttHeaders.TOPIC) String topic, @Header(MqttHeaders.QOS) Integer Qos, String text);
}