package com.bigdata.caicf;

import com.alibaba.fastjson.JSON;
import com.bigdata.caicf.dao.PageDataMapper;
import com.bigdata.caicf.dao.PageInfoMapper;
import com.bigdata.caicf.model.PageData;
import com.bigdata.caicf.model.PageInfo;
import com.bigdata.caicf.utils.TencentXPathUtil;
import com.bigdata.caicf.utils.WebResolveUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;
import java.util.Properties;

/**
 * Created by caicf on 2016/6/15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class TestDB {

    @Autowired
    private PageDataMapper pageDataMapper;

    @Autowired
    private PageInfoMapper pageInfoMapper;

    @Test
//    @Transactional
    public void test2() {
        Properties properties=new Properties();
        try {
            properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("globalconfig.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.setProperty("webdriver.ie.driver",properties.getProperty("ie.driver"));
        WebDriver driver= WebResolveUtil.getIEDriver();
        String path="http://v.qq.com/cover/v/va107nb989aqmje.html?ptag=2345.movie";
        new WebResolveUtil().waitPageLoadComplete(driver);
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

        PageInfo pageInfo=new PageInfo();
        pageInfo.setBreadcrumbtext(WebResolveUtil.getWebElementText(By.xpath(TencentXPathUtil.breadcrumbXPath)));
        pageInfo.setMoviename(WebResolveUtil.getWebElementText(By.xpath(movieNameXPath)));
        pageInfo.setComments(WebResolveUtil.getWebElementText(By.xpath(commentXPath)));
        pageInfo.setPlaytimes(WebResolveUtil.getWebElementText(By.xpath(playtimesXPath)));
        pageInfo.setTags(WebResolveUtil.getWebElementText(By.xpath(tags)));
        pageInfo.setDirector(WebResolveUtil.getWebElementText(By.xpath(director)));
        pageInfo.setStarring(WebResolveUtil.getWebElementText(By.xpath(starring)));
        pageInfo.setSummary(WebResolveUtil.getWebElementText(By.xpath(infofull)));

        pageInfoMapper.insert(pageInfo);
        System.out.println(pageInfo.getId());
        PageData pageData=new PageData();
        pageData.setUrl(path);
        pageData.setValue(JSON.toJSONString(pageInfo));
        pageData.setDate(new Date());
        pageData.setObjId(pageInfo.getId());
        pageDataMapper.insert(pageData);

        WebResolveUtil.quitDriver();
    }

    @Test
    public void test1() throws ClassNotFoundException, SQLException {
        PageInfo pageInfo=pageInfoMapper.selectByPrimaryKey(1);
        System.out.println(JSON.toJSONString(pageInfo));

        String str=JSON.toJSONString(pageInfo);

        PageData pageData=new PageData();
        pageData.setValue("fsdafsaf");
        pageData.setDate(new Date());
        pageData.setObjId(2);
        int i=pageDataMapper.insert(pageData);


        PageInfo info1= JSON.parseObject(str,PageInfo.class);
        System.out.println(info1.getComments());
        //JDBC操作可行System.out.println(i);
//        String sql="select * from page_data";
//        Class.forName("com.mysql.jdbc.Driver");
//        java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bigdata", "root", "8860");
//        PreparedStatement preparedStatement=conn.prepareStatement(sql);
//        ResultSet resultSet=preparedStatement.executeQuery();
//        while (resultSet.next()){
//            System.out.println(          resultSet.getString(2)   );
//            System.out.println(          resultSet.getString(3)   );
//        }
    }

}
