package com.caratlane.pages;

import com.caratlane.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.concurrent.TimeUnit;

public class EngagementRingsPageClass extends BaseClass {
    public static String prname;
    public static String prprice;
    @FindBy(xpath = "//div[@itemprop='item'][1]//div[contains(@class,'bottomContainer')]/p/span")
    WebElement productprice;

    @FindBy(xpath="//div[@itemprop='item'][1]//div[contains(@class,'bottomContainer')]/a/p")
    WebElement prodcutname;

    @FindBy(xpath="//div[@itemprop='item'][1]//div[@role='presentation']//span[@data-status='inactive']")
    WebElement wishlist;

    @FindBy(xpath="//div[contains(@class,'toaster-message')]/div")
    WebElement wishlistsuccesstext;

    public EngagementRingsPageClass(){
        PageFactory.initElements(driver,this);
    }

    public void getProductDetails(){
        prname = prodcutname.getText();
        prprice = productprice.getText();
    }

    public WishListPageClass addToWishList(){
        wishlist.click();
        return new WishListPageClass();
    }

    public String VerifyAddedToCartMessage(){
        wait.until(ExpectedConditions.visibilityOf(wishlistsuccesstext));
        String successmessage = wishlistsuccesstext.getText();
        System.out.println(successmessage);
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[contains(@class,'toaster-message')]/div")));
//        try {
////            Thread.sleep(3000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        return successmessage;
    }
}
