
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.pageObject.android.StoreFormPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class StoreFlow extends AppiumConfig{
    @Test
    public void StoreLandingForm() throws InterruptedException {
        StoreFormPage storeFormPage = new StoreFormPage(driver);
        storeFormPage.setNameField("Jenifer");
        storeFormPage.setGenderOption();
//        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("android:id/text1")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Austria']")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Jordan Lift Off\"));"));
        int countItems = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        for (int i=0; i<countItems; i++){
            String itemName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if (itemName.equalsIgnoreCase("Jordan Lift Off")){
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/productName")).click();
        String cartProductName = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();
        Assert.assertEquals(cartProductName,"Jordan Lift Off");
    }
}
