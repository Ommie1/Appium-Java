import io.appium.java_client.android.Activity;
import org.pageObject.android.CartPage;
import org.pageObject.android.ProductListingPage;
import org.pageObject.android.StoreFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StoreProductListingFlow extends AppiumConfig{

    @BeforeMethod
    public void setupTest(){
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
        driver.startActivity(activity);
    }

    @Test (priority=1)
    public void AddProductToCart() throws InterruptedException {
        StoreFormPage storeFormPage = new StoreFormPage(driver);
        ProductListingPage productListingPage = new ProductListingPage(driver);
        storeFormPage.setNameField("Jenifer");
        storeFormPage.setGenderOption();
        storeFormPage.selectCountry("Austria");
        storeFormPage.setShopButton();
        productListingPage.addItemToCartWithIndex(0);
        productListingPage.clickCartIcon();
        CartPage cartPage = new CartPage(driver);
        cartPage.cartPageTitle("Cart");
        cartPage.verifyProductInCart("Air Jordan 4 Retro");
        Thread.sleep(5000);
    }
}
