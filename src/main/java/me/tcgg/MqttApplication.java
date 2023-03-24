package me.tcgg;

import me.tcgg.config.MqttConfig;
import me.tcgg.handler.MqttMessageHandler;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.Resource;

@SpringBootApplication
@EnableScheduling
@EnableConfigurationProperties
@MapperScan("me.tcgg.mapper")
public class MqttApplication implements CommandLineRunner {
    @Autowired
    private MqttMessageHandler mqttMessageHandler;

    public static void main(String[] args) {
        SpringApplication.run(MqttApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("MQTT client is running...");
    }
}
