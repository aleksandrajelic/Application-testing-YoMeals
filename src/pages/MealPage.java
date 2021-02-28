package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MealPage extends BasicPage{

	public MealPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement btnFavorite() {
		return this.driver.findElement(By.className("svg-icn"));
	}
	
	public WebElement BtnQuantity() {
		return this.driver.findElement(By.name("product_qty"));
	}
	
	public WebElement BtnAddToCart() {
		return this.driver.findElement(By.className("btn btn--primary btn--large js-proceedtoAddInCart"));
	}
	
	public void addMeal(int quantity) {
		this.driver.findElement(By.name("product_qty"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].value = "+ quantity +"");
	}
	
	public void btnFavoriteClick() {
		this.btnFavorite().click();
	}
	
	
	
	



}
