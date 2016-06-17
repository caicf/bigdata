package com.bigdata.caicf.service;

import com.bigdata.caicf.model.PageData;
import com.bigdata.caicf.model.PageInfo;

/**
 * Created by caicf on 2016/6/17.
 */
public interface DataDurableService {
    void durableDate(PageInfo pageInfo, PageData pageData);
}
