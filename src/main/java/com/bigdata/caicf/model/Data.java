package com.bigdata.caicf.model;

import java.util.Date;

/**
 * Created by caicf on 2016/6/14.
 */
public class Data {
    private int id;
    private String value;
    private Date date;
    private int objId;

    public Data() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getObjId() {
        return objId;
    }

    public void setObjId(int objId) {
        this.objId = objId;
    }
}
