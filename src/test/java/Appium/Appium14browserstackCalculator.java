package Appium;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.experimental.theories.Theories;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class Appium14browserstackCalculator {

    @Test
    public void test() throws MalformedURLException, InterruptedException {


        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", "abdurrahimakgn_dnbkvy");
        caps.setCapability("browserstack.key", "qBxtokCYmXx8AFnRywvb");

        // Set URL of the application under test
        caps.setCapability("app", "bs://cb69226753a60e3f71ce7f7ab57e050ef590f621");

        // Specify device and os_version for testing
        caps.setCapability("device", "Samsung Galaxy S22 Ultra");
        caps.setCapability("os_version", "12.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        AndroidDriver<AndroidElement> driver = new AndroidDriver<AndroidElement>(
                new URL("http://hub.browserstack.com/wd/hub"), caps);

        // Write your test case statements here
        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("plus").click();

        driver.findElementById("com.google.android.calculator:id/digit_5").click();
        Thread.sleep(3000);
        driver.findElementByAccessibilityId("equals").click();

        Assert.assertEquals(driver.findElementById("com.google.android.calculator:id/result").getText(),10);


        // Invoke driver.quit() after the test is done to indicate that the test is completed.
        driver.quit();


    }


}
