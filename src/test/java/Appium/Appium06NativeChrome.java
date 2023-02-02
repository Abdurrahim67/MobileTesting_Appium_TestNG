package Appium;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;

public class Appium06NativeChrome {

    @Test
public void test() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities=new DesiredCapabilities();


        capabilities.setCapability(MobileCapabilityType.APPLICATION_NAME,"Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.0");
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"RealDevice");//adb devices
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"UiAutomator2");
        capabilities.setCapability("appPackage","com.android.chrome");
        capabilities.setCapability("appActivity","com.google.android.apps.chrome.Main");
        AndroidDriver<MobileElement>driver=new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);




        MobileElement accept=driver.findElementById("com.android.chrome:id/terms_accept");
        if(accept.isDisplayed()){
                accept.click();
                MobileElement yesIm=driver.findElementById("com.android.chrome:id/positive_button");
                yesIm.click();
        }

        driver.get("https://www.amazon.com");

            System.out.println("app Type= "+driver.getContext());
            Set<String> allTypes=driver.getContextHandles();
            for(String type: allTypes){
                    System.out.println(type);
                    if(type.contains("WEBVIEW_chrome")){

                            driver.context(type);
                    }
            }


            System.out.println("after the change= "+driver.getContext());

            Thread.sleep(3000);



        }



    }



