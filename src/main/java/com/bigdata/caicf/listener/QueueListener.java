package com.bigdata.caicf.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

/**
 * Created by hasee on 2016/5/14.
 */
public class QueueListener implements MessageListener {

    public void onMessage(Message message) {
//        try {
//            String msg= new String(message.getBody(),"utf-8");
//            System.out.println("[QueueListener] recive message '"+msg+"'");
//            JSONObject jsonObject = JSONObject.parseObject(msg);
//            String deviceId = jsonObject.getString("deviceId");
//            Integer type = jsonObject.getInteger("type");
//            SkUser dbSkUser = skUserService.queryBydeviceNum(deviceId);
//            System.out.println("[QueueListener] user info 'phone:"+dbSkUser.getPhone()+"'");
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
        System.out.println("=========>>>>>>>>>>>"+message);
    }
}
