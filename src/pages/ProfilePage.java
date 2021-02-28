package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class ProfilePage extends BasicPage{

	public ProfilePage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement getFirstName() {
		return this.driver.findElement(By.name("user_first_name"));
	}
	
	public WebElement getLastName() {
		return this.driver.findElement(By.name("user_last_name"));
	}
	
	public WebElement getAddress() {
		return this.driver.findElement(By.name("user_address"));
	
	}
	
	public WebElement getPhoneNo() {
		return this.driver.findElement(By.name("user_phone"));
	}
	
	public WebElement getZipCode() {
		return this.driver.findElement(By.name("user_zip"));
	}
	
	public void getCountry(String country) {
		WebElement selectEl = this.driver.findElement(By.id("user_country_id"));
		Select countrySelect = new Select(selectEl);
		countrySelect.selectByValue(country);
				
	}
	
	public void getState(String state) {
		WebElement selectEl = this.driver.findElement(By.id("user_state_id"));
		Select stateSelect = new Select(selectEl);
		stateSelect.selectByValue(state);
	}
	
	public void getCity(String city) {
		WebElement selectEl = this.driver.findElement(By.id("user_city"));
		Select citySelect = new Select(selectEl);
		citySelect.selectByValue(city);
	
	}
	
	public WebElement getSave() {
		return this.driver.findElement(By.name("btn_submit"));
	}
	
	public void getProfilePicture() {
		WebElement upload = this.driver.findElement(By.className("uploadFile-Js"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", upload);
		
	}
	
	public void uploadProfilePicture(String imgPath) {
		this.getProfilePicture();
	
	}
	
	public void removeProfilePicture() {
		WebElement remove = this.driver.findElement(By.className("remove"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", remove);
		
	}
	
	public void editPersonalInformation(String firstName, String lastName, String address, String phoneNo, String zipCode) {
		this.getFirstName().sendKeys(firstName);
		this.getLastName().sendKeys(lastName);
		this.getAddress().sendKeys(address);
		this.getPhoneNo().sendKeys(phoneNo);
		this.getZipCode().sendKeys(zipCode);
	}

}

