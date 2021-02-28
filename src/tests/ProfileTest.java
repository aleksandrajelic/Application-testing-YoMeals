package tests;

import java.io.File;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

public class ProfileTest extends BasicTest{
	
	public ProfileTest(String baseUrl, String email, String password) {
		super(baseUrl, email, password);
	}

	@Test (priority = 0)
	public void editProfileTest() {
		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		this.locationPopupPage.closeDialog();
		this.loginPage.Login(this.email, this.password);
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Login Successfull"), "[ERROR] Unexpected message");
		
		this.driver.navigate().to(this.baseUrl + "/member/profile");
		this.profilePage.editPersonalInformation("Aleksandra", "Jelic", "Pobedina 3", "018349865", "18000");
		this.profilePage.getCountry("Srbija");
		this.profilePage.getState("Nis");
		this.profilePage.getCity("Nis");
		this.profilePage.getSave();
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Setup Successful"), "[ERROR] Unexpected message");
		
		this.authPage.btnLogout().click();
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Logout Successfull!"), "[ERROR] Unexpected message");
		
	}
	
	@Test (priority = 5)
	public void changeProfileImage() throws IOException {
		this.driver.navigate().to(this.baseUrl + "/guest-user/login-form");
		this.locationPopupPage.closeDialog();
		this.loginPage.Login(this.email, this.password);
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Login Successfull"), "[ERROR] Unexpected message");
		
		this.driver.navigate().to(this.baseUrl + "/member/profile");
		
		String imgPath = new File("imagеs/profile_picture.jpg").getCanonicalPath();
		this.profilePage.uploadProfilePicture(imgPath);
		
		this.authPage.btnLogout().click();
			
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Profile Image Uploaded Successfully"), "[ERROR] Unexpected message");
		
		this.notificationSistemPage.closeNotification();
		
		this.profilePage.removeProfilePicture();
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Profile Image Deleted Successfully"), "[ERROR] Unexpected message");
		this.notificationSistemPage.closeNotification();
		
		this.authPage.btnLogout().click();
		Assert.assertTrue(this.notificationSistemPage.getMsgText().contains("Logout Successfull!"), "[ERROR] Unexpected message");

	}
	
		



}
