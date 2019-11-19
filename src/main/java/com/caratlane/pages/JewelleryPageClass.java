package com.caratlane.pages;

import com.caratlane.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class JewelleryPageClass extends BaseClass {

    @FindBy(xpath = "//div[@id='customisation-section']//h1[@itemprop='name']")
    WebElement productname;

    @FindBy(xpath = "//div[@itemprop='offers']//span[1]")
    WebElement productprice;

    @FindBy(xpath = "//button[@content='Add to Cart']")
    WebElement addtocart;

    @FindBy(xpath = "//div[@data-component='delivery options'][2]//span[2]")
    WebElement deliverydate;

    public JewelleryPageClass(){
        PageFactory.initElements(driver,this);
    }

    public void clickOnAddToCart(){
        addtocart.click();
    }

    public void getDetails(){
        productname.getText();
        productprice.getText();
    }

    public int getDeliveryDate(){
        String delivery = deliverydate.getText();
        String[] dates = delivery.split(" ");
        dates[3] = dates[3].replaceAll("[^0-9]","");
    }
}
