package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasicPage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement getUsername() {
		return this.driver.findElement(By.name("username"));
	}
	
	public WebElement getPassword() {
		return this.driver.findElement(By.name("password"));
	}
	
	public WebElement getBtnRememberMe() {
		return this.driver.findElement(By.name("remember_me"));
	}
	
	public WebElement getBtnLogin() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	public void Login(String username, String password) {
		this.getUsername().sendKeys(username);
		this.getPassword().sendKeys(password);
		this.getBtnLogin().click();
		
	}

}
