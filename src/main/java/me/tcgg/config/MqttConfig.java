package me.tcgg.config;


import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "me.tcgg.mqtt")
@Data
@Slf4j
@EnableIntegration
public class MqttConfig {
    private String host;

    private Integer port;
    private String username;
    private String password;
    private String inClientId;
    private String outClientId;
    private String topic;
    private Integer timeout;
    private Integer keepalive;
    private String cleanSession;


    @Bean
    public MqttPahoClientFactory mqttPahoClientFactory(){
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
        options.setServerURIs(new String[] {host + ":" + port });
        options.setUserName(username);
        options.setPassword(password.toCharArray());
        options.setKeepAliveInterval(keepalive);
        factory.setConnectionOptions(options);
        return factory;
    }

    @Bean
    public MessageChannel mqttOutboundChannel(){
        return new DirectChannel();
    }
    @Bean
    public MessageChannel mqttInboundChannel(){
        return new DirectChannel();
    }
    @Bean
    public MessageChannel errorChannel(){
        return new DirectChannel();
    }

    @Bean
    public MqttPahoMessageDrivenChannelAdapter adapter(MqttPahoClientFactory factory){
        return new MqttPahoMessageDrivenChannelAdapter(inClientId,factory,topic);
    }

    @Bean
    public MessageProducer inbound(MqttPahoMessageDrivenChannelAdapter adapter,
                                       MessageChannel mqttInboundChannel,
                                       MessageChannel errorChannel){
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        //入站投递给入站管道
        adapter.setOutputChannel(mqttInboundChannel);
        adapter.setErrorChannel(errorChannel);
        adapter.setQos(0);
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttOutboundChannel")
    public MessageHandler outbound(MqttPahoClientFactory factory){
        MqttPahoMessageHandler handler =
                new MqttPahoMessageHandler(outClientId,factory);
        handler.setAsync(true);
        handler.setConverter(new DefaultPahoMessageConverter());
        handler.setDefaultTopic(topic);
        return handler;
    }


    @Bean
    public IntegrationFlow mqttInFlow(MqttPahoMessageDrivenChannelAdapter inbound,MessageChannel mqttInboundChannel) {
        return IntegrationFlows.from(inbound)
                .channel(mqttInboundChannel)
                .get();
    }

    // @Scheduled(fixedRateString = "${me.tcgg.mqtt.timeout}000")
    // public void sendHeartbeat() throws MqttException {
    //     MqttPahoClientFactory clientFactory = new DefaultMqttPahoClientFactory();
    //     MqttConnectOptions options = new MqttConnectOptions();
    //     options.setServerURIs(new String[] { host + ":" + port });
    //     options.setUserName(username);
    //     options.setPassword(password.toCharArray());
    //     options.setKeepAliveInterval(keepalive);
    //     MqttAsyncClient client = new MqttAsyncClient(host + ":" + port , inClientId, new MemoryPersistence());
    //     client.connect(options).waitForCompletion(5000);
    //     client.publish("$SYS/broker/heartbeat/"+inClientId, new MqttMessage("Heartbeat".getBytes()));
    //     client.disconnect().waitForCompletion(5000);
    //     log.info("outId：" + outClientId + "   InId: " + inClientId + "  HeartBeat!");
    // }


}

