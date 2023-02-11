import io.appium.java_client.android.Activity;
import org.pageObject.android.CartPage;
import org.pageObject.android.ProductListingPage;
import org.pageObject.android.StoreFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class StoreHomeFlow extends AppiumConfig{

    @BeforeMethod
    public void setupTest(){
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
        driver.startActivity(activity);
    }
    @Test (priority=1)
    public void StoreLandingForm() throws InterruptedException {
        StoreFormPage storeFormPage = new StoreFormPage(driver);
        storeFormPage.setNameField("Jenifer");
        storeFormPage.setGenderOption();
        storeFormPage.selectCountry("Austria");
        storeFormPage.setShopButton();
        Thread.sleep(5000);
    }
}
