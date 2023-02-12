package org.pageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.utils.AndroidActions;

public class StoreFormPage extends AndroidActions {
    AndroidDriver driver;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
    private WebElement nameField;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement genderOption;
    @AndroidFindBy(id = "android:id/text1")
    private WebElement countryDropdown;
    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;
    public StoreFormPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public void setNameField(String name) {
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGenderOption() {
        genderOption.click();
    }

    public void selectCountry(String name) {
        countryDropdown.click();
        scrollToText(name);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + name + "']")).click();
    }

    public void setShopButton() {
        shopButton.click();
    }
}
