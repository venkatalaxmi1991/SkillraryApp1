package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;


public class AddUserTest extends BaseClass {
	@Test
	public void addUserTest() throws InterruptedException {
		SoftAssert soft=new SoftAssert();
		home.clickusersTab();
		soft.assertTrue(user.getPageHeader().contains("User"));
		user.clicNewButton();
		Thread.sleep(3000);
		soft.assertEquals(newUser.getPageHeader(), "Add New User");
		
		Map<String, String> map = excel.readFromExcel("Add User");

		newUser.setEmail(map.get("Email"));
           newUser.setpassword(map.get("Password"));
		newUser.setFirstName(map.get("Firstname"));
		newUser.setLastName(map.get("Lastname"));
		newUser.setAddress(map.get("Address"));
		newUser.setcontact(map.get("Contact Info"));
		newUser.uploadPhoto(map.get("Photo"));

		newUser.clicksave();
		
		soft.assertEquals(user.getSuccessMessage(), "Success!");
		soft.assertAll();
		

	}

}