package org.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.utils.AppiumUtils;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class AppiumAndroidConfig extends AppiumUtils {
    public AndroidDriver driver;

    @BeforeClass
    public void AppiumStart() throws MalformedURLException {
        AppiumDriverLocalService service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Nexus-6");
        options.setApp("D://AutomationWork//Java-Framework//Appium-Project//General-Store.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}
