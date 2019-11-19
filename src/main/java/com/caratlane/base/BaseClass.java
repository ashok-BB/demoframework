package com.caratlane.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;
    public static WebDriverWait wait;
    String date[] = new String[3];
    public void testsetup() {
        prop = new Properties();
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("/home/ashok/code-base/caratlanecom/src/main/resources/config.properties");
            prop.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void initialization(){
        System.setProperty("webdriver.chomre.driver",prop.getProperty("driverpath"));
        driver = new ChromeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver,10);
    }

    public void switchwindow(){
        Set<String> handle = driver.getWindowHandles();
        Iterator<String> it = handle.iterator();
        String parent = it.next();
        String child = it.next();
        driver.switchTo().window(child);
    }

    public int getTodayDate(){
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date dat = new Date();
        date = dateFormat.format(dat).split("/");
        return Integer.getInteger(date[0]);
    }

}
