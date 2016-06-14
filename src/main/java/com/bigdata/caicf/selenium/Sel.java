package com.bigdata.caicf.selenium;

import com.bigdata.caicf.utility.WebUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by caicf on 2016/6/14.
 */
public class Sel {

    public static void main(String[] args) {
        //The path to the driver executable must be set by
        //the webdriver.chrome.driver system property
       //System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");

       //ie
//        System.setProperty("webdriver.ie.driver","src\\main\\resources\\IEDriverServer.exe");
//        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
//        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);



        String path = "http://v.qq.com/cover/v/va107nb989aqmje.html?ptag=2345.movie";
       // String path = "http://v.qq.com/prev/f/fetiylrqxyebh7g.html";
       // WebDriver driver = new ChromeDriver();
//        WebDriver driver = new InternetExplorerDriver(ieCapabilities);

        WebDriver driver= WebUtil.getIEDriver();

        driver.get(path);

        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return   ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        });

        //面包屑导航    电影>韩国>欲望
        String breadcrumbXPath="/html/body/div[2]/div[1]/div[1]";
        //电影名
        String movieNameXPath="//*[@id=\"h1_title\"]";
        //评论数量
        String commentXPath="//*[@id=\"commentnum\"]";
        //播放次数
        String playtimesXPath="//*[@id=\"act_playnum\"]";


        System.out.println(WebUtil.getWebElementText(By.xpath(breadcrumbXPath)));


        String movieName=driver.findElement(By.xpath(movieNameXPath)).getText();

        System.out.println(movieName);


        String comment=driver.findElement(By.xpath(commentXPath)).getText();

        System.out.println(comment);


        String playtimes=driver.findElement(By.xpath(playtimesXPath)).getText();
        System.out.println(playtimes);




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
        System.out.println(WebUtil.getWebElementText(By.xpath(tags)));
        System.out.println(WebUtil.getWebElementText(By.xpath(director)));
        System.out.println(WebUtil.getWebElementText(By.xpath(starring)));
        System.out.println(WebUtil.getWebElementText(By.xpath(infofull)));

        driver.quit();
    }

}
