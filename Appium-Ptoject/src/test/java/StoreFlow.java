import org.pageObject.android.CartPage;
import org.pageObject.android.ProductListingPage;
import org.pageObject.android.StoreFormPage;
import org.testng.annotations.Test;
public class StoreFlow extends AppiumConfig{
    @Test
    public void StoreLandingForm() throws InterruptedException {
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
