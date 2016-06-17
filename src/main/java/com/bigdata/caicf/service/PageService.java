package com.bigdata.caicf.service;

import com.alibaba.fastjson.JSON;
import com.bigdata.caicf.model.PageData;
import com.bigdata.caicf.model.PageInfo;
import com.bigdata.caicf.utils.TencentXPathUtil;
import com.bigdata.caicf.utils.WebResolveUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * Created by caicf on 2016/6/16.
 */
public class PageService implements Runnable {

    private String url;
    private DataDurableService dataDurableService;

    public PageService(String url, DataDurableService dataDurableService) {
        this.url = url;
        this.dataDurableService = dataDurableService;
    }

    private PageData pageData =new PageData();
    private PageInfo pageInfo =new PageInfo();

    private Map<String,String> map=new HashMap<String, String>();


    private void getTextSetObject()  {
        Properties properties=new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("globalconfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.ie.driver",properties.getProperty("ie.driver"));
        WebDriver driver= WebResolveUtil.getIEDriver();
        String path=url;
        new WebResolveUtil().waitPageLoadComplete(driver);
        driver.get(path);
        driver.findElement(By.xpath(TencentXPathUtil.detailXPath)).click();

        map.put("breadcrumb", WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.breadcrumbXPath)).toString());
        System.out.println(map.get("breadcrumb"));
//        pageInfo.setBreadcrumbtext(map.get("breadcrumb"));
        pageInfo.setBreadcrumbtext(WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.breadcrumbXPath)));
        pageInfo.setMoviename(WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.movieNameXPath)));
        pageInfo.setComments(WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.commentXPath)));
        pageInfo.setPlaytimes(WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.playtimesXPath)));
        pageInfo.setTags(WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.tagsXPath)));
        pageInfo.setDirector(WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.directorXPath)));
        pageInfo.setStarring(WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.starringXPath)));
        pageInfo.setSummary(WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.summaryfullXPath)));

        pageData.setUrl(url);
        pageData.setValue(JSON.toJSONString(pageInfo));
        pageData.setDate(new Date());

        WebResolveUtil.quitDriver();
    }

////    @Transactional
//    private void durableToDB(){
//        System.out.println("---------->>>>>>>>>执行插入数据");
//        pageInfoMapper.insert(pageInfo);
//        System.out.println(JSON.toJSONString(pageInfo));
//        pageData.setUrl(url);
//        pageData.setValue(JSON.toJSONString(pageInfo));
//        pageData.setDate(new Date());
//        pageData.setObjId(pageInfo.getId());
//        pageDataMapper.insert(pageData);
//        System.out.println(JSON.toJSONString(pageData));
//    }

    public void run() {
        getTextSetObject();
        dataDurableService.durableDate(pageInfo,pageData);
    }
}
