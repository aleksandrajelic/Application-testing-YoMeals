package tests;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import pages.AuthPage;
import pages.CartSummaryPage;
import pages.LocationPopupPage;
import pages.LoginPage;
import pages.MealPage;
import pages.NotificationSistemPage;
import pages.ProfilePage;

public abstract class BasicTest {
		
		protected WebDriver driver;
		protected LocationPopupPage locationPopupPage;
		protected LoginPage loginPage;
		protected NotificationSistemPage notificationSistemPage;
		protected ProfilePage profilePage;
		protected AuthPage authPage;
		protected MealPage mealPage;
		protected CartSummaryPage cartSummaryPage;
		
		protected String baseUrl;
		protected String email;
		protected String password;

		public BasicTest(String baseUrl, String email, String password) {
			this.baseUrl = "http://demo.yo-meals.com";
			this.email = "customer@dummyid.com";
			this.password = "12345678a";
		}
		
		@BeforeClass
		public void setup() {
			System.setProperty("webdriver.chrome.driver",
					 "driver-lib\\chromedriver.exe");
			this.driver = new ChromeDriver();
			
			this.locationPopupPage = new LocationPopupPage(driver);
			this.loginPage = new LoginPage(driver);
			this.notificationSistemPage = new NotificationSistemPage(driver);
			this.profilePage = new ProfilePage(driver);
			this.authPage = new AuthPage(driver);
			this.mealPage = new MealPage(driver);
			this.cartSummaryPage = new CartSummaryPage(driver);
			
			this.driver.manage().window().maximize();
			this.driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			this.driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			
		}
		
		@AfterClass
		public void clearAllCookies() {
			this.driver.manage().deleteAllCookies();
			
		}
		
		@AfterClass
		public void createScreenShot(ITestResult result) throws IOException, AWTException {
			if (result.getStatus() == ITestResult.FAILURE) {
				Rectangle screenRect = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				BufferedImage capture = new Robot().createScreenCapture(screenRect);
			
				DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss");  
				LocalDateTime now = LocalDateTime.now();  
				ImageIO.write(capture, "png", new File(now+".png"));
			
				System.out.println("Sacuvan je screenshot!");
				}
		}
		
		@AfterClass
		public void clear() {
			this.driver.quit();
		}

	}
		


