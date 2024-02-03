package pompages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebDriverUtility;


public class CourseListPage {

	// Declaration

	@FindBy(xpath = "//h1[normalize-space(text())='Course List']")
	private WebElement pageHeader;

	@FindBy(xpath = "//a[text()=' New']")
	private WebElement newButton;

	private String deletepath = "//td[text()='%s']/ancestor::tr/descendant::button[text()=' Delete']";
	// "%s" for string replacement,"%d" for integer replacement

	@FindBy(name = "delete")
	private WebElement deleteButton;

	@FindBy(xpath = "//h4[text()=' Success!']")
	private WebElement successmessage;

	// Initialization

	public CourseListPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization
	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void clickNewButton() {

		newButton.click();
	}

	public void deleteCourse(WebDriverUtility web, String courseName) {
		web.convertPathToWebElement(deletepath, courseName).click();
		deleteButton.click();
	}

	public String getSuccessMessage() {
		return successmessage.getText();
	}

}