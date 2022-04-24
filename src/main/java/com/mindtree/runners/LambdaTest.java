package com.mindtree.runners;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mindtree.utilities.RetreiveExcelData;

public class LambdaTest {

	public RemoteWebDriver driver = null;
	String username = "m1070636";
	String accessKey = "VmfuPqOEuVu447MQ3EauXhcssmf4u3ugUkt5thEcg3BoIwZDZ3";

	
	public void setUp(String BrowserType, String Version, String Os, String TestName) throws Exception {
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("platform", Os);
		capabilities.setCapability("browserName", BrowserType);
		capabilities.setCapability("version", Version); // If this cap isn't specified, it will just get the any
														// available one
		capabilities.setCapability("resolution", "1024x768");
		capabilities.setCapability("build", "First Build");
		capabilities.setCapability("name", TestName);
		capabilities.setCapability("network", true); // To enable network logs
		capabilities.setCapability("visual", true); // To enable step by step screenshot
		capabilities.setCapability("video", true); // To enable video recording
		capabilities.setCapability("console", true); // To capture console logs

		try {

			driver = new RemoteWebDriver(
					new URL("https://" + username + ":" + accessKey + "@hub.lambdatest.com/wd/hub"), capabilities);
		} catch (MalformedURLException e) {
			System.out.println("Invalid grid URL");
		}
	}

	@Test
	public void test1() throws Exception {
		try {

			System.out.println("Test1 staretd");
			ArrayList<String> thirdVMProperties = RetreiveExcelData.getData("Chrome");

			// SENDING VM'S PROPERTIES browsername, version and OS
			setUp(thirdVMProperties.get(0), thirdVMProperties.get(1), thirdVMProperties.get(2), "First Test");

			driver.get("https://www.lambdatest.com/selenium-playground");
			driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).click();

			if (driver.findElement(By.xpath("//a[text()='Simple Form Demo']")).getText()
					.equalsIgnoreCase("Simple Form Demo"))
				Assert.assertTrue(true);

			else
				Assert.assertFalse(false);

			String ourMassage = "Welcome To Possible";
			driver.findElement(By.id("user-message")).clear();
			driver.findElement(By.id("user-message")).sendKeys(ourMassage);
			driver.findElement(By.id("showInput")).click();

			if (driver.findElement(By.id("message")).getText().equalsIgnoreCase(ourMassage)) {
				Assert.assertTrue(true);
			} else {
				Assert.assertTrue(false);
			}

			driver.quit();
			System.out.println("Test1 end");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test2() throws Exception {
		try {
			System.out.println("Test2 staretd");
			
			ArrayList<String> secondVMProperties = RetreiveExcelData.getData("MicrosoftEdge");
       
			// SENDING VM'S PROPERTIES browsername, version and OS
			setUp(secondVMProperties.get(0), secondVMProperties.get(1), secondVMProperties.get(2), "Second Test");
  
			driver.get("https://www.lambdatest.com/selenium-playground");

			driver.findElement(By.xpath("//a[text()='Drag & Drop Sliders']")).click();

			// Select Slider
			WebElement slider = driver.findElement(By.cssSelector("input[value='15']"));

			for (int i = 1; i <= 80; i++) {
				slider.sendKeys(Keys.ARROW_RIGHT);
			}

			if (driver.findElement(By.xpath("//*[text()='95']")).getText().equalsIgnoreCase("95"))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);

			driver.quit();
			System.out.println("Test2 end");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Test
	public void test3() throws Exception {
		try {
			System.out.println("Test3 staretd");
			ArrayList<String> firstVMProperties = RetreiveExcelData.getData("Chrome");

			// SENDING VM'S PROPERTIES:- browsername, version and OS
			setUp(firstVMProperties.get(0), firstVMProperties.get(1), firstVMProperties.get(2), "Third Test");

			driver.get("https://www.lambdatest.com/selenium-playground");

			driver.findElement(By.xpath("//*[@class='cookie__bar__close hover:underline smtablet:hidden']")).click();
			//Thread.sleep(5000L);

			driver.findElement(By.xpath("//*[@href='https://www.lambdatest.com/selenium-playground/input-form-demo']")).click();

			driver.findElement(By.id("name")).sendKeys("zacknjil");
			driver.findElement(By.id("inputEmail4")).sendKeys("zacknjil@gmail.com");
			driver.findElement(By.xpath("//*[@type='password']")).sendKeys("zacknjil@123");
			driver.findElement(By.id("company")).sendKeys("zacknjil");
			driver.findElement(By.id("websitename")).sendKeys("zacknjil.com");
			Select country = new Select(driver.findElement(By.name("country")));
			country.selectByVisibleText("United States");

			driver.findElement(By.id("inputCity")).sendKeys("california");
			driver.findElement(By.id("inputAddress1")).sendKeys("mata colony");
			driver.findElement(By.id("inputAddress2")).sendKeys("jagga road");
			driver.findElement(By.id("inputState")).sendKeys("los angeles");
			driver.findElement(By.id("inputZip")).sendKeys("476111");
			
			driver.findElement(By.xpath("//*[text()='Submit']")).click();

			if (driver.findElement(By.xpath("//*[@class = 'success-msg hidden']")).getText()
					.equalsIgnoreCase("Thanks for contacting us, we will get back to you shortly."))
				Assert.assertTrue(true);
			else
				Assert.assertTrue(false);

			driver.quit();
			System.out.println("Test3 ed");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}

