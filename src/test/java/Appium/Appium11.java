package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class Appium11 extends BaseClass {

    @Test
    public void test() throws MalformedURLException, InterruptedException {

        AndroidDriver driver=getAndroidDriver();



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
