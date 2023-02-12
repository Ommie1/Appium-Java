package org.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumAndroidConfig extends AppiumCommonUtils {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void AppiumStart() throws MalformedURLException {
        service = new AppiumServiceBuilder().withIPAddress("127.0.0.1").usingPort(4723).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Nexus-6");
        options.setApp("D://AutomationWork//Java-Framework//Appium-Project//General-Store.apk");
        driver = new AndroidDriver(new URL("http://0.0.0.0:4723"), options);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
