package com.bigdata.caicf.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * 工具类
 * Created by caicf on 2016/6/14.
 */
public class WebUtil {

    private static WebDriver driver;

    /**
     * 支持Chrome
     * @return
     */
    public static WebDriver getChromeDriver() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver=new ChromeDriver();
        return  driver;
    }

    /**
     * 支持IE
     * @return
     */
    public static WebDriver getIEDriver() {
        System.setProperty("webdriver.ie.driver","src\\main\\resources\\IEDriverServer.exe");
        //解决IE启动报错问题
        DesiredCapabilities ieCapabilities = DesiredCapabilities.internetExplorer();
        ieCapabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        driver = new InternetExplorerDriver(ieCapabilities);
        return driver;
    }

    /**
     * 等待页面加载完成函数，超过60s抛出异常
     */
    public void waitPageLoadComplete(WebDriver driver){
        WebDriverWait wait=new WebDriverWait(driver,60);
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return   ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        });
    }

    /**
     * 获取元素的Text
     * @param by
     * @return
     */
    public static String getWebElementText(By by) {
        try {
            return driver.findElement(by).getText();
        } catch (NoSuchElementException e) {
            return "Element not existed!";
        }
    }

    /**
     * 判断元素是否存在
     * @param selector
     * @return
     */
    public static boolean isWebElementExist(By selector) {
        try {
            driver.findElement(selector);
            return true;
        } catch(NoSuchElementException e) {
            return false;
        }
    }

    /**
     * 关闭driver
     */
    public static void quitDriver() {
        driver.quit();
    }

}
