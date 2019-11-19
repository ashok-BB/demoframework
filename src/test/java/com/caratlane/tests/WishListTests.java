package com.caratlane.tests;

import com.caratlane.base.BaseClass;
import com.caratlane.pages.HomePageClass;
import com.caratlane.pages.JewelleryPageClass;
import com.caratlane.pages.ShippingEarringsByLatestPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class WishListTests extends BaseClass {

    HomePageClass homepageobject ;
    ShippingEarringsByLatestPage shippingEarringsByLatestObject;
    JewelleryPageClass jwellerypageobject;
    @BeforeMethod
    public void set(){
        testsetup();
    }

    @Test
    public void verify_Delivery_Date_test(){
        initialization();
        homepageobject = new HomePageClass();
        shippingEarringsByLatestObject = new ShippingEarringsByLatestPage();
        jwellerypageobject = new JewelleryPageClass();
        homepageobject.hoverPincode();
        homepageobject.enterPincode();
        homepageobject.confirmPincode();
        homepageobject.hoverEarRings();
        homepageobject.clickImageBanner();
        shippingEarringsByLatestObject.getDetails();
        shippingEarringsByLatestObject.selectAnyProduct();
        switchwindow();
        jwellerypageobject.getDetails();
        getTodayDate(); 
//        Assert.assertEquals();

    }

//    @AfterMethod
    public void teardown(){
        driver.quit();
    }
}
