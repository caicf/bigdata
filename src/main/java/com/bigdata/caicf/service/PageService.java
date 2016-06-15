package com.bigdata.caicf.service;

import com.bigdata.caicf.dao.PageDataMapper;

/**
 * Created by caicf on 2016/6/15.
 */
public class PageService {
    private PageDataMapper pageDataMapper;

    public PageDataMapper getPageDataMapper() {
        return pageDataMapper;
    }

    public void setPageDataMapper(PageDataMapper pageDataMapper) {
        this.pageDataMapper = pageDataMapper;
    }
}
