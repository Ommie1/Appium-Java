package org.pageObject.android;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

import java.util.List;
public class ProductListingPage extends AndroidActions {
    AndroidDriver driver;
    public ProductListingPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }
    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement> addToCart;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/appbar_btn_cart")
    private WebElement cartButton;
    public void addItemToCartWithIndex(int Index) {
    addToCart.get(Index).click();
    }
    public void clickCartIcon() throws InterruptedException {
        cartButton.click();
    }
}
