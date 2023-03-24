package me.tcgg.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import me.tcgg.mapper.HealthDataMapper;
import me.tcgg.pojo.HealthData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class MqttMessageHandler {

    @Autowired
    SimpleDateFormat simpleDateFormat;

    @Resource
    HealthDataMapper healthDataMapper;

    @Autowired
    ObjectMapper objectMapper;

    @ServiceActivator(inputChannel = "mqttInboundChannel")
    public void handle(Message<String> message) {
        String payload = message.getPayload();
        if (payload.contains("{")
                && payload.contains("}")
                && payload.contains("SP02")
                && payload.contains("Heart_Rate")
                && payload.contains("id")
                && payload.contains("Is_finger_ontop")) {
            log.info(message.toString());
            Long timestamp = message.getHeaders().getTimestamp();
            assert timestamp != null;
            String formatDate = simpleDateFormat.format(new Date(timestamp));
            String[] date = formatDate.split(" ");
            try {
                JsonNode jsonNode = objectMapper.readTree(payload);
                HealthData healPojo = new HealthData(null,
                        jsonNode.get("id").toString().replace("\"", ""),
                        jsonNode.get("SP02").asDouble(),
                        jsonNode.get("Heart_Rate").asInt(),
                        jsonNode.get("Is_finger_ontop").asBoolean(),
                        date[0], date[1]);
                log.info(healPojo.toString());
                healthDataMapper.insertHealthDate(healPojo);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                log.warn("转换JsonNode失败！");
            }
        } else {
            log.info("非HealthData数据，直接标准输出 -> " + message);
        }

    }


    // @ServiceActivator(inputChannel = "mqttInboundChannel")
    // public MessageHandler handleMessage() {
    //     return message -> {
    //         System.out.println("MessageHandler:" + message.getPayload());
    //     };
    // }

}

