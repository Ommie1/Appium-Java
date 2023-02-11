import io.appium.java_client.android.Activity;
import org.pageObject.android.CartPage;
import org.pageObject.android.ProductListingPage;
import org.pageObject.android.StoreFormPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class StoreHomeFlow extends AppiumConfig{
    @BeforeMethod
    public void setupTest(){
        Activity activity = new Activity("com.androidsample.generalstore", "com.androidsample.generalstore.MainActivity");
        driver.startActivity(activity);
    }
    @Test (dataProvider = "getData")
    public void StoreLandingForm(HashMap<String,String> input) throws InterruptedException {
        StoreFormPage storeFormPage = new StoreFormPage(driver);
        storeFormPage.setNameField(input.get("name"));
        storeFormPage.setGenderOption();
        storeFormPage.selectCountry(input.get("country"));
        storeFormPage.setShopButton();
        Thread.sleep(5000);
    }
    @DataProvider
    public Object[][] getData() throws IOException {
       List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"//src//test//java//org//testData//shopping.json");
       return new Object[][]{{data.get(0)}};
    }
}
