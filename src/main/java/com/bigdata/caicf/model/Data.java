package com.bigdata.caicf.model;

import java.util.Date;

public class Data {
    private Integer id;

    private String url;

    private Date date;

    private Integer objId;

    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getObjId() {
        return objId;
    }

    public void setObjId(Integer objId) {
        this.objId = objId;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value == null ? null : value.trim();
    }
}