package com.caratlane.pages;

import com.caratlane.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.security.cert.X509Certificate;

public class ShippingEarringsByLatestPage extends BaseClass {

    static String productname;
    static String productprice;
    @FindBy(xpath = "//div[@itemprop='itemListElement']/div[@itemprop='item'][1]")
    WebElement selectproduct;

    @FindBy(xpath = "//div[@itemprop='itemListElement']/div[@itemprop=\"item\"][1]//div[contains(@class,'bottomContainer')]//a/p")
    WebElement prname;

    @FindBy(xpath = "//div[contains(@class,'bottomContainer')][1]//span")
    WebElement prprice;

    public ShippingEarringsByLatestPage(){
        PageFactory.initElements(driver,this);
    }

    public void selectAnyProduct(){

        selectproduct.click();
    }

    public void getDetails(){
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        productname = prname.getText();
        productprice = prprice.getText();
    }
}
