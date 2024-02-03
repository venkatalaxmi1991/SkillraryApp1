package pompages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericlibraries.WebDriverUtility;


public class AddNewCoursePage {

	// Declaration

	@FindBy(xpath = "//b[text()='Add New Course']")
	private WebElement pageHeader;

	@FindBy(id = "name")
	private WebElement nameTF;

	@FindBy(id = "price")
	private WebElement priceTF;

	@FindBy(xpath = "//select[@id='category' and @required]")
	private WebElement categoryDropdown;

	@FindBy(xpath = "(//input[@type='file'])[2]")
	private WebElement uploadPhoto;

	@FindBy(xpath = "//iframe[contains(@title,'editor1')]")
	private WebElement descriptionframe;

	@FindBy(xpath = "//html/body/p")
	private WebElement descriptionTextArea;

	@FindBy(xpath = "//button[@name='add']")
	private WebElement saveButton;

	// Initialization

	public AddNewCoursePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	// Utilization

	public String getPageHeader() {
		return pageHeader.getText();
	}

	public void setName(String coursename) {
		nameTF.sendKeys(coursename);
	}

	public void setPrice(String price) {
		priceTF.sendKeys(price);
	}

	public void selectCategory(WebDriverUtility web, String text) {
		web.selectFromDropdown(text, categoryDropdown);
		
	}

	public void uploadPhoto(String path) {
		uploadPhoto.sendKeys(path);
	}

	public void clicksaveButton() {

		saveButton.click();
		
	}

	public void setDescription(String description, WebDriverUtility web) {
		web.switchToFrame(descriptionframe);
		descriptionTextArea.sendKeys(description);
		web.switchBackFromFrame();
	}

}