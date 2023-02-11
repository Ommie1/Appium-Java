package org.pageObject.android;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class StoreFormPage {
    AndroidDriver driver;

    public StoreFormPage(AndroidDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;

    @AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
    private WebElement genderOption;

    public void setNameField(String name){
        nameField.sendKeys(name);
        driver.hideKeyboard();
    }

    public void setGenderOption(){
        genderOption.click();
    }


}
