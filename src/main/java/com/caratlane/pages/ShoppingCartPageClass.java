package com.caratlane.pages;

import com.caratlane.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ShoppingCartPageClass extends BaseClass {

    @FindBy(xpath="//div[contains(@class,'cart-item-content')]/p[contains(@class,'cart-item-product-name')]")
    WebElement productname;

    @FindBy(xpath = "//div[contains(@class,'cart-item-option')]//p[contains(@class,'cart-item-price')]")
    WebElement productprice;

    public ShoppingCartPageClass(){
        PageFactory.initElements(driver,this);
    }

    public String getProductName(){
        wait.until(ExpectedConditions.visibilityOf(productname));
        return productname.getText();
    }

    public String getProductPrice(){
        return productprice.getText();
    }
}
