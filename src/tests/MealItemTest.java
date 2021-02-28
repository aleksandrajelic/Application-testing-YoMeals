package tests;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MealItemTest extends BasicTest{

		
	public MealItemTest(String baseUrl, String email, String password) {
		super(baseUrl, email, password);

	}
	
	@Test(priority = 5)
	public void addMeal() {
		this.driver.navigate().to(this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopupPage.closeDialog();
		
		this.mealPage.addMeal(3);
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("The Following Errors Occurred:"), "[ERROR] Unexpected message");
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Please Select Location"), "[ERROR] Unexpected message");
		this.notificationSistemPage.closeNotification();
		
		this.locationPopupPage.addLocation("City Center - Albany");
		this.mealPage.addMeal(3);
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Meal Added To Cart"), "[ERROR] Unexpected message");
	
	}
	
	@Test(priority = 3)
	public void addMealToFavorite() {
		this.driver.navigate().to(this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		this.locationPopupPage.closeDialog();
		this.mealPage.btnFavoriteClick();
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Please login first!"), "[ERROR] Unexpected message");
		
		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		this.loginPage.Login(this.email, this.password);
		this.driver.navigate().to(this.baseUrl + "/meal/lobster-shrimp-chicken-quesadilla-combo");
		this.mealPage.btnFavoriteClick();
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Product has been added to your favorites."), "[ERROR] Unexpected message");
	
	}
		
	@Test (priority = 10)
	public void clearCart() throws IOException {
		this.driver.navigate().to(this.baseUrl + "/meals");
		this.locationPopupPage.addLocation("City Center - Albany");
		
		File file = new File("data/data.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet meals = wb.getSheetAt(1);
		
		for (int i = 1; i < meals.getLastRowNum(); i++) {
			String mealUrl = meals.getRow(i).getCell(0).getStringCellValue(); 
			String quantity = meals.getRow(i).getCell(1).getStringCellValue();
			int numberOfMeals = Integer.parseInt(quantity);
			
			this.mealPage.addMeal(numberOfMeals);
			
			SoftAssert softAssert = new SoftAssert();
			softAssert.assertEquals(this.notificationSistemPage.getMsgText(), "Meal Added To Cart", "[ERROR] Unexpected message");

			this.cartSummaryPage.btnClearAllClick();
			Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Meal Added To Cart"), "[ERROR] Unexpected message");
			
			
		
			
			
			
		}
		
		
			
			/* 
	
	za svako dodavanje proizvioda verifikujte da je prikazana poruka sa tekstom "Meal Added To Cart"
	koristite SoftAssert za ovu proveru
	obrišite sve stavke iz korpe
	verifikujte da je prikazana poruka sa tekstom "All meals removed from Cart successfully" */

		}


}
