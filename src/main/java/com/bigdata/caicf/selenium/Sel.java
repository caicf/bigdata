package com.bigdata.caicf.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by caicf on 2016/6/14.
 */
public class Sel {

    public static void main(String[] args) {
        //The path to the driver executable must be set by
        //the webdriver.chrome.driver system property
        System.setProperty("webdriver.chrome.driver","src\\main\\resources\\chromedriver.exe");

        String path = "http://v.qq.com/cover/v/va107nb989aqmje.html?ptag=2345.movie";
       // String path = "http://v.qq.com/prev/f/fetiylrqxyebh7g.html";
        WebDriver driver = new ChromeDriver();
        driver.get(path);

        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return   ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        });

        String breadcrumbXPath="/html/body/div[2]/div[1]/div[1]";

        WebElement breadcrumb = driver.findElement(By.xpath(breadcrumbXPath));
        WebElement subBreadcrumb1=breadcrumb.findElement(By.xpath(breadcrumbXPath+"/a[1]"));
        WebElement subBreadcrumb2=breadcrumb.findElement(By.xpath(breadcrumbXPath+"/a[2]"));
        WebElement subBreadcrumb3=breadcrumb.findElement(By.xpath(breadcrumbXPath+"/a[3]"));

        String breadcrumbText=subBreadcrumb1.getText()+"/"+subBreadcrumb2.getText()+"/"+subBreadcrumb3.getText();

        System.out.println(breadcrumbText);

        String movieNameXPath="//*[@id=\"h1_title\"]";
        String movieName=driver.findElement(By.xpath(movieNameXPath)).getText();

        System.out.println(movieName);

        String commentXPath="//*[@id=\"commentnum\"]";
        String comment=driver.findElement(By.xpath(commentXPath)).getText();

        System.out.println(comment);

        String playtimesXPath="//*[@id=\"act_playnum\"]";
        String playtimes=driver.findElement(By.xpath(playtimesXPath)).getText();
        System.out.println(playtimes);






        driver.quit();
    }
}
