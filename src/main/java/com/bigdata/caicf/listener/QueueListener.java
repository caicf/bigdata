package com.bigdata.caicf.listener;

import com.alibaba.fastjson.JSONObject;
import com.bigdata.caicf.service.PageService;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;

import java.io.UnsupportedEncodingException;

/**
 * Created by hasee on 2016/5/14.
 */
public class QueueListener implements MessageListener {

    private String url=null;

    public void onMessage(Message message) {
        try {
            //获得生产者发来的信息
            String msg=new String(message.getBody(),"utf-8");
            JSONObject jsonObject = JSONObject.parseObject(msg);
            //得到要解析的url
            url = jsonObject.getString("url");

            System.out.println(url);
            System.out.println("=========启动线程");
            System.out.println("=========="+Thread.currentThread().getName());
            System.out.println("=========="+Thread.currentThread().getId());
            System.out.println("=========="+Thread.currentThread().getState());
            System.out.println("=========="+Thread.currentThread().getPriority());
//            new Thread(new ResolvePageData(url)).start();
//            new PageService(url).resolvePageText();
            Thread thread=new Thread(new PageService(url));
            thread.start();
            thread.join();

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

}
