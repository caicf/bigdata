package com.bigdata.caicf;

import com.bigdata.caicf.utility.WebUtil;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by caicf on 2016/6/15.
 */
public class CRUDTest {
    @Test
    public void testCreate(){
        WebDriver driver= WebUtil.getIEDriver();
        String path="http://v.qq.com/cover/v/va107nb989aqmje.html?ptag=2345.movie";
        new WebUtil().waitPageLoadComplete(driver);
        driver.get(path);
        //面包屑导航    电影>韩国>欲望
        String breadcrumbXPath="/html/body/div[2]/div[1]/div[1]";
        //电影名
        String movieNameXPath="//*[@id=\"h1_title\"]";
        //评论数量
        String commentXPath="//*[@id=\"commentnum\"]";
        //播放次数
        String playtimesXPath="//*[@id=\"act_playnum\"]";

        //标签
        String tags="//*[@id=\"mod_descContent\"]/ul/li[1]/div";
        //导演
        String director="//*[@id=\"mod_descContent\"]/ul/li[2]/div";
        //主演
        String starring="//*[@id=\"mod_descContent\"]/ul/li[3]/div";
        //简介
        WebElement info=driver.findElement(By.xpath("//*[@id=\"btn_desc_expand\"]/span"));
        info.click();
        String infofull="//*[@id=\"mod_desc\"]/p[2]";

        System.out.println("============================================================");

        System.out.println(WebUtil.getWebElementText(By.xpath(breadcrumbXPath)));
        System.out.println(WebUtil.getWebElementText(By.xpath(movieNameXPath)));
        System.out.println(WebUtil.getWebElementText(By.xpath(commentXPath)));
        System.out.println(WebUtil.getWebElementText(By.xpath(playtimesXPath)));
        System.out.println(WebUtil.getWebElementText(By.xpath(tags)));
        System.out.println(WebUtil.getWebElementText(By.xpath(director)));
        System.out.println(WebUtil.getWebElementText(By.xpath(starring)));
        System.out.println(WebUtil.getWebElementText(By.xpath(infofull)));


        WebUtil.quitDriver();



    }
}
