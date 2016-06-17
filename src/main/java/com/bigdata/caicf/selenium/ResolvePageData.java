package com.bigdata.caicf.selenium;

/**
 * Created by caicf on 2016/6/16.
 */
public class ResolvePageData extends Thread {

    private String msg;

    public ResolvePageData(String msg) {
        this.msg = msg;
    }

    public void run() {
        System.out.println("================>>>>> run");

//            new PageService(msg).resolvePageText();

    }
}
