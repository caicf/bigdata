package com.bigdata.caicf.rabbitmq;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.MessageProperties;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

/**
 * Created by hasee on 2016/5/14.
 *
 */
public class RunPulisherTwo {

    private static final String QUEUE_NAME = "test_queue_caicf";

    public static void main(String[] args) throws IOException, TimeoutException {
        ConnectionFactory connectionFactory  = new ConnectionFactory();
        connectionFactory.setHost("localhost");
        connectionFactory.setUsername("guest");
        connectionFactory.setPassword("guest");
        connectionFactory.setVirtualHost("/");
        Connection connection = connectionFactory.newConnection();
        Channel channel = connection.createChannel();
        /**
         *  durable:是否持久化
         *  exclusive: 仅创建者可以使用的私有队列，断开后自动删除
         *  auto_delete: 当所有消费客户端连接断开后，是否自动删除队列
         */
        channel.queueDeclare(QUEUE_NAME,true,false,false,null);
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("deviceId","800000001");
        params.put("type",5);
        String message = parseMapToJSONStr(params);
        System.out.println("【X】 request params '"+message+"'");
        channel.basicPublish("amqpExchange","routing_key_caicf", MessageProperties.PERSISTENT_TEXT_PLAIN,message.getBytes("utf-8"));
        channel.close();
        connection.close();
    }

    private static String parseMapToJSONStr(Map<String,Object> map){
        StringBuilder sb = new StringBuilder("{");
        for(Map.Entry<String,Object> entry : map.entrySet()){
            sb.append("\"").append(entry.getKey()).append("\"")
            .append(":")
            .append("\"").append(entry.getValue()).append("\"")
            .append(",");
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append("}");
        return sb.toString();
    }
}
