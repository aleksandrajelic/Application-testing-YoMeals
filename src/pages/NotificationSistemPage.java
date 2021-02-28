package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NotificationSistemPage extends BasicPage{

	public NotificationSistemPage(WebDriver driver) {
		super(driver);
		
	}
	
	public WebElement getMsg() {
		return this.driver.findElement(By.xpath("//*[contains(@class, 'alert--success')"));
	}
	
	public String getMsgText() {
		return this.getMsg().getText();
	}
	
	public void closeNotification() {
		WebDriverWait waiter = new WebDriverWait(driver, 30);
		waiter.until(ExpectedConditions.invisibilityOf(this.getMsg()));
	}
	


}
