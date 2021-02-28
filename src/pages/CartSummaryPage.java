package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartSummaryPage extends BasicPage{

	public CartSummaryPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement btnClearAll() {
		return this.driver.findElement(By.xpath("//*[class='cart-head']/a[2]"));
	}
	
	public void btnClearAllClick() {
		this.btnClearAll().click();
	}

}
