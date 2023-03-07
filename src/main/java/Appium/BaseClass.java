package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseClass {

@Test
    public AndroidDriver getAndroidDriver() throws MalformedURLException {

    DesiredCapabilities capabilities = new DesiredCapabilities();


    capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME, "Android");
    capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10.0");
    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "RealDevice");//adb devices
    capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
    capabilities.setCapability(MobileCapabilityType.APP, "C:\\mobile_Testing_TestNG\\src\\Apps\\apiDemos.apk");
    capabilities.setCapability("noReset", "true");

    AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);

    //If the phone is locked, it allows us to open it
    if (driver.isDeviceLocked()) {
        driver.unlockDevice();
    }


    return driver;
}

}
