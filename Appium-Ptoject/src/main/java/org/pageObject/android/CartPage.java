package org.pageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.utils.AndroidActions;

import java.time.Duration;

public class CartPage extends AndroidActions {
    AndroidDriver driver;

    public CartPage (AndroidDriver driver)
    {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id = "com.androidsample.generalstore:id/toolbar_title")
    private WebElement cartTitle;

    @AndroidFindBy(id = "com.androidsample.generalstore:id/productName")
    private WebElement productName;

    public void cartPageTitle(String text) {
        String cartTitleText = cartTitle.getText();
        Assert.assertEquals(cartTitleText, text);
    }

    public void verifyProductInCart(String text){
        String productNameTitle = productName.getText();
        Assert.assertEquals(productNameTitle,text);
    }
}
