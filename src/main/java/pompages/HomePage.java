package pompages;


	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;

	public class HomePage {

		//Declaration 
		@FindBy(xpath =" //a[text()=' Home']")
		private WebElement pageHeader;
		
		@FindBy(xpath="//span[text()='Users']")
		private WebElement usersTab;
		
		@FindBy(xpath="//span[text()='Courses']")
		private WebElement coursesTab;
		
		@FindBy(xpath="//a[text()=' Course List']")
		private WebElement CourseListLink;
		
		@FindBy(xpath=" //a[text()=' Category']")
		private WebElement CategoryLink;
		
		@FindBy(xpath="//span[text()='SkillRaryAdmin']")
		private WebElement SkillRaryAdminIcon;
		
		@FindBy(xpath="//text()='Sign out']")
		private WebElement signoutLink;
	    
		//Initialization
				public HomePage(WebDriver driver) {
					PageFactory.initElements(driver, this);
				}


	//Utilization
	public String getPageHeader()
	{
		return pageHeader.getText();
	}

	public void clickusersTab()
	{
		usersTab.click();
	}

	public void clickCoursesTab()
	{
		coursesTab.click();
	}

	public void clickCourseListLink()
	{
	CourseListLink.click();
	}
	
	public void clickCategoryLink() {
		CategoryLink.click();
	}
	public void signoutApp()
	{
		SkillRaryAdminIcon.click();
		signoutLink.click();
	}
	}
	
	

				
				
				

				