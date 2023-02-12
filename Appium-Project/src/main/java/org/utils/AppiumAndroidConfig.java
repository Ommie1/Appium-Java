package org.utils;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;

public class AppiumAndroidConfig extends AppiumCommonUtils {
    public AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void AppiumStart() throws IOException {
        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "//src//main//java//org//resources//androidConfig.properties");
        prop.load(fis);
        service = new AppiumServiceBuilder().withIPAddress(prop.getProperty("ipAddress")).usingPort(Integer.parseInt(prop.getProperty("port"))).build();
        service.start();
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName(prop.getProperty("deviceName"));
        options.setApp(System.getProperty("user.dir") + "//General-Store.apk");
        driver = new AndroidDriver(new URL(prop.getProperty("sessionURL")), options);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        service.stop();
    }
}
