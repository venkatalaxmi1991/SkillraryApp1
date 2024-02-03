package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;
import pompages.AddNewCategoryPage;

public class AddCategoryTest extends BaseClass {
			@Test
			public void addCategoryTest() throws InterruptedException {
				SoftAssert soft = new SoftAssert();
				home.clickCoursesTab();
				home.clickCategoryLink();;
				soft.assertTrue(category.getPageHeader().contains("Category"));

				category.clickNewButton();
				Thread.sleep(3000);
				soft.assertEquals(newCategory.GetPageHeader(), "Add New Category");
				Map<String, String> map = excel.readFromExcel("Add Category");
				newCategory.setName(map.get("Name"));
				newCategory.clickSave();

				soft.assertEquals(category.getSuccessMessage(), "Success!");
				category.deleteCategory(web, map.get("Name"));
				soft.assertEquals(category.getSuccessMessage(), "Success!");
				if (category.getSuccessMessage().equals("Success!"))
					excel.updateTestStatus("Add Category", "Pass", IConstantPath.EXCEL_PATH);
				else
					excel.updateTestStatus("Add Category", "Fail", IConstantPath.EXCEL_PATH);
				soft.assertAll();

			}

		
}
