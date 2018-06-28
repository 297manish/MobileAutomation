package newLearning;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

public class LearnTest {

	AppiumDriver<MobileElement> driver;
	@BeforeClass
	public void setUp() throws MalformedURLException {
		//Set the Desired Capabilities
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "My Phone");
		caps.setCapability("udid", "3300b85e1609b299"); //Give Device ID of your mobile phone
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "7.0");
		caps.setCapability("appPackage", "com.sec.android.app.popupcalculator");
		caps.setCapability("appActivity", "com.sec.android.app.popupcalculator.Calculator");
		caps.setCapability("noReset", "true");
		//Instantiate Appium Driver
		driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}
	
	@Test
	public void add() {
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"5\"]")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Plus\"]")).click();
		driver.findElement(By.id("com.sec.android.app.popupcalculator:id/bt_05")).click();
		driver.findElement(By.xpath("//android.widget.Button[@content-desc=\"Equal\"]")).click();
		String text = driver.findElement(By.className("android.widget.EditText")).getText();
		System.out.println(text);
		Assert.assertEquals("10", text);
		
	}
}
