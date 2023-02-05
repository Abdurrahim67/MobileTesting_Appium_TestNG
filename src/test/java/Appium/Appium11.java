package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium11 {

    @Test
    public void test() throws MalformedURLException, InterruptedException {
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



        //click on the Api Demos
        driver.findElementByXPath("//android.widget.TextView[@text='API Demos']").click();

        //click on the Preference
        driver.findElementByXPath("//android.widget.TextView[@text='Preference']").click();

        //click on the Preference dependencies
        driver.findElementByXPath("//android.widget.TextView[@text='3. Preference dependencies']").click();

        //click on the checkbox
        String isChecked=driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"android:id/checkbox\")").getAttribute("checked");
        if(isChecked.equals("false")){
            driver.findElementById("android:id/checkbox").click();
        }

      //  driver.findElementById("android:id/checkbox").click();

        //click on the WIFI settings
        driver.findElementByXPath("//android.widget.TextView[@text='WiFi settings']").click();

        //verify WiFi settings oppenend
        Assert.assertTrue(driver.findElementById("android:id/alertTitle").isDisplayed());

        //send a text
        driver.findElementById("android:id/edit").sendKeys("textAppium");

        //click on the  OK
        driver.findElementById("android:id/button1").click();







        // driver.closeApp();

    }


}
