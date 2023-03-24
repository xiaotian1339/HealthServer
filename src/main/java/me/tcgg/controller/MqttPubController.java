package me.tcgg.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import me.tcgg.config.MqttConfig;
import me.tcgg.enums.StatusCodeEnum;
import me.tcgg.pojo.HealthData;
import me.tcgg.sender.MqttSender;
import me.tcgg.service.HealthDataService;
import me.tcgg.service.MqttService;
import me.tcgg.status.ResponseStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1",produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class MqttPubController {

    @Autowired
    private MqttConfig mqttConfig;

    @Autowired
    private MqttSender mqttSender;

    @Autowired
    private MqttService mqttService;

    @Autowired
    private MqttPahoMessageDrivenChannelAdapter adapter;

    @Autowired
    private HealthDataService healthDataService;


    @PostMapping("/topics")
    public String topics(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        String[] topics = adapter.getTopic();
        for (int i = 0;i < topics.length;i++){
            stringBuilder.append("\"").append(i).append("\"").append(" : \"").append(topics[i]).append("\" ,");
        }
        stringBuilder.replace(stringBuilder.length() - 1,stringBuilder.length(),"");
        stringBuilder.append("}");
        return stringBuilder.toString();

    }



    @PostMapping("/mqttConfigDetail")
    public Object hello(@RequestParam("secret")String secret) throws JsonProcessingException {
        if (!"xiaotian5945".equals(secret)){
            return new ResponseStatus(StatusCodeEnum.STATUS_FAIL);
        }
        return new ObjectMapper().writerWithDefaultPrettyPrinter().writeValueAsString(mqttConfig);
    }

    @PostMapping("/sendMqtt")
    public ResponseStatus sendMqtt(String sendData) {
        mqttSender.sendToMqtt(sendData);
        return new ResponseStatus(StatusCodeEnum.STATUS_OK);
    }


    @PostMapping("/sendMqttTopic")
    public ResponseStatus sendMqtt(String sendData, String topic) {
        mqttSender.sendWithTopic(topic, sendData);
        return new ResponseStatus(StatusCodeEnum.STATUS_OK);
    }


    @PostMapping("/sendWithTopicAndQos")
    public ResponseStatus sendMqtt(String sendData, String topic,Integer Qos) {
        mqttSender.sendWithTopicAndQos(topic,Qos,sendData);
        return new ResponseStatus(StatusCodeEnum.STATUS_OK);
    }

    @PostMapping("/addTopic")
    public ResponseStatus addTopic(String topic){
        log.info("addTopic:" + topic);
        mqttService.addTopic(topic);
        return new ResponseStatus(StatusCodeEnum.STATUS_OK);
    }

    @PostMapping("/removeTopic")
    public ResponseStatus removeTopic(String topic){
        log.info("removeTopic:" + topic);
        mqttService.removeTopic(topic);
        return new ResponseStatus(StatusCodeEnum.STATUS_OK);
    }


    @PostMapping("/info")
    public PageInfo<HealthData> getHealthData(@RequestParam("userId") String userId, @RequestParam("page") String page) {
        PageInfo<HealthData> healthDataPageInfo;
        try {
            healthDataPageInfo = healthDataService.selectByUid(userId, Integer.parseInt(page));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return healthDataPageInfo;
    }

    @PostMapping("/info/date")
    public PageInfo<HealthData> getHealthData(@RequestParam("userId") String userId,
                                              @RequestParam("page") String page,
                                              @RequestParam("date") String date) {
        PageInfo<HealthData> healthDataPageInfo;
        try {
            healthDataPageInfo = healthDataService.selectByUidAndDate(userId,date, Integer.parseInt(page));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        return healthDataPageInfo;
    }

    @PostMapping("/getUserDate")
    public List<HashMap<String, Object>> getUserDate(@RequestParam("userId") String userId){
        return healthDataService.getUserDate(userId);
    }




}
