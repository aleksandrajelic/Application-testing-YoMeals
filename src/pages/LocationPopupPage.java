package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocationPopupPage extends BasicPage{

	public LocationPopupPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement getSelectLocation() {
		return this.driver.findElement(By.id("locality_keyword"));
		
	}
	
	public WebElement getBtnClose() {
		return this.driver.findElement(By.xpath("//*[@id='location-popup']/div/div/div/div/a"));
		
	}
	
	public WebElement getKeyword() {
		return this.driver.findElement(By.xpath("//*[@id='locality_keyword']"));
		
	}
	
	public WebElement getLocationItem(String locationName) {
		return this.driver.findElement(By.xpath("//li/a[contains(text(), '\" + locationName + \"')]/.."));
		
	}
	
	public WebElement getLocationInput() {
		return this.driver.findElement(By.xpath("//*[@id='location_id']"));
		
	}
	
	public WebElement getSubmit() {
		return this.driver.findElement(By.xpath("//*[@name='btn_submit']"));
		
	}
	
	public void openLocation() {
		this.getSelectLocation().click();
		
	}
	
	public void addLocation(String locationName) {
		this.getKeyword().click();
		String num = this.getLocationItem(locationName).getAttribute(locationName);
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].value=arguments[1]", num);
		
	}
	
	public WebElement closeDialog() {
		return this.driver.findElement(By.className("close-btn close-btn-white"));
	}
	
		
	

}
