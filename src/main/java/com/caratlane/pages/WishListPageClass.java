package com.caratlane.pages;

import com.caratlane.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WishListPageClass extends BaseClass {

    @FindBy(xpath="//div[@role='presentation']/div[contains(@class,'bottomContainer')]/p/span")
    WebElement productprice;

    @FindBy(xpath = "//div[@role='presentation']/div[contains(@class,'bottomContainer')]/a/p")
    WebElement productname;

    @FindBy(xpath = "//button[@content='Move to Cart']")
    WebElement movetocartbutton;

    @FindBy(xpath="//div[contains(@class,'toaster-message')]/div")
    WebElement movedtocartmessage;

    public WishListPageClass(){
        PageFactory.initElements(driver,this);
    }

    public String getProductName(){
        return productname.getText();
    }

    public String getProductPrice(){
        return productprice.getText();
    }

    public void clickMoveToCartButton(){
        movetocartbutton.click();
    }

    public String verifyMovedToCartMessage(){
        wait.until(ExpectedConditions.visibilityOf(movedtocartmessage));
        String verifymovetocart = movedtocartmessage.getText();
//        wait.until(ExpectedConditions.invisibilityOf(movedtocartmessage));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return verifymovetocart;
    }

}
