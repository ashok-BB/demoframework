package com.caratlane.tests;

import com.caratlane.base.BaseClass;
import com.caratlane.pages.EngagementRingsPageClass;
import com.caratlane.pages.HomePageClass;
import com.caratlane.pages.ShoppingCartPageClass;
import com.caratlane.pages.WishListPageClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class HomePageTests extends BaseClass {

    @BeforeMethod
    public void setup() {
        testsetup();
    }

    @Test
    public void addToWishlist_test(){
        initialization();
        HomePageClass homepage = new HomePageClass();
        EngagementRingsPageClass engagementrings = new EngagementRingsPageClass();
        WishListPageClass wishlistpage = new WishListPageClass();
        ShoppingCartPageClass shoppingcartpage = new ShoppingCartPageClass();
        homepage.hoverRings();
        homepage.clickOnEngagement();
        engagementrings.getProductDetails();
        engagementrings.addToWishList();
        engagementrings.VerifyAddedToCartMessage();
        homepage.navigateToWishList();
        Assert.assertEquals(EngagementRingsPageClass.prname,wishlistpage.getProductName(),"Products are not as selected");
        Assert.assertEquals(EngagementRingsPageClass.prprice,wishlistpage.getProductPrice(), "Product price is not as selected");
        wishlistpage.clickMoveToCartButton();
        wishlistpage.verifyMovedToCartMessage();
        homepage.navigateToCart();
        Assert.assertEquals(EngagementRingsPageClass.prname,shoppingcartpage.getProductName(),"Product name is different");
        Assert.assertEquals(shoppingcartpage.getProductPrice(),EngagementRingsPageClass.prprice.replace(" ",""),"Price is different");
    }

    @AfterMethod
    public void teardown(){
        driver.close();
    }
}
