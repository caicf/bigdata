package com.bigdata.caicf.service;

import com.bigdata.caicf.dao.PageDataMapper;
import com.bigdata.caicf.dao.PageInfoMapper;
import com.bigdata.caicf.model.PageData;
import com.bigdata.caicf.model.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by caicf on 2016/6/17.
 */
@Service
public class DataDurableServiceImpl implements DataDurableService {

    @Autowired
    public PageDataMapper pageDataMapper;

    public void setPageInfoMapper(PageInfoMapper pageInfoMapper) {
        this.pageInfoMapper = pageInfoMapper;
    }

    public void setPageDataMapper(PageDataMapper pageDataMapper) {
        this.pageDataMapper = pageDataMapper;
    }

    @Autowired
    public PageInfoMapper pageInfoMapper;

    @Transactional
    public void durableDate(PageInfo pageInfo, PageData pageData) {
        pageInfoMapper.insert(pageInfo);
        pageData.setObjId(pageInfo.getId());
        pageDataMapper.insert(pageData);
    }
}
