package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AuthPage extends BasicPage{

	public AuthPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement btnMyAccount() {
		return this.driver.findElement(By.xpath("//*[class='my-account-dropdown']/ul/li[1]/a"));
		
	}
	
	public WebElement btnLogout() {
		return this.driver.findElement(By.xpath("//*[class='my-account-dropdown']/ul/li[2]/a"));
	}

}
