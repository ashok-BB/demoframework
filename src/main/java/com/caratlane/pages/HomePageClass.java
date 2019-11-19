package com.caratlane.pages;

import com.caratlane.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.swing.*;

public class HomePageClass extends BaseClass {

    Actions action = new Actions(driver);
    @FindBy(xpath="//a[text()='RINGS']")
    WebElement rings;

    @FindBy(xpath="//h4[text()='ENGAGEMENT']")
    WebElement engagement;

    @FindBy(xpath="//a[@aria-labelledby=\"takes to wishlist\"]")
    WebElement wishlistnavigator;

    @FindBy(xpath="//button[@aria-labelledby='takes to cart']")
    WebElement cartnavigator;

    @FindBy(xpath="//span[text()='Pincode']")
    WebElement pincode;

    @FindBy(xpath="//input[@placeholder='Enter Pincode']")
    WebElement enterpincode;

    @FindBy(xpath ="//div[contains(@class,'input-wrapper')]/div/span")
    WebElement confirmpincode;

    @FindBy(xpath = "//nav[@id='NavMenu']//a[text()='EARRINGS']")
    WebElement earrings;

    @FindBy(xpath = "//div[@type='FULL_SIZED_BANNER_BLOCK']//span[contains(text(),'Delivery in')]")
    WebElement imagebanner;

    public HomePageClass(){
        PageFactory.initElements(driver,this);
    }

    public void hoverRings(){
        action.moveToElement(rings).build().perform();
    }

    public EngagementRingsPageClass clickOnEngagement(){
        engagement.click();
        return new EngagementRingsPageClass();
    }

    public WishListPageClass navigateToWishList(){
        wishlistnavigator.click();
        return new WishListPageClass();
    }

    public ShoppingCartPageClass navigateToCart(){
        cartnavigator.click();
        return new ShoppingCartPageClass();
    }

    public void hoverPincode(){
        action.moveToElement(pincode).build().perform();
    }

    public void enterPincode(){
        enterpincode.sendKeys(prop.getProperty("pincode"));
    }

    public void confirmPincode(){
        confirmpincode.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hoverEarRings(){
        action.moveToElement(earrings).build().perform();
    }

    public void clickImageBanner(){
        wait.until(ExpectedConditions.visibilityOf(imagebanner));
        imagebanner.click();
    }
}
