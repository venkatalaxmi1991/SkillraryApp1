package TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericlibraries.BaseClass;
import genericlibraries.IConstantPath;

public class AddCourseTest extends BaseClass {
	@Test
	public void addCourseTest() throws InterruptedException {
		SoftAssert soft = new SoftAssert();
		home.clickCoursesTab();
		home.clickCourseListLink();
		soft.assertTrue(course.getPageHeader().contains("Course List"));
		course.clickNewButton();
		Thread.sleep(3000);
		soft.assertEquals(newCourse.getPageHeader(), "Add New Course");

		Map<String, String> map = excel.readFromExcel("Add Course");
		newCourse.setName(map.get("Name"));
		newCourse.selectCategory(web, map.get("Category"));
		newCourse.setPrice(map.get("Price"));
		newCourse.uploadPhoto(map.get("Photo"));
		newCourse.setDescription(map.get("Description"), web);
		newCourse.clicksaveButton();

		soft.assertEquals(course.getSuccessMessage(), "Success!");
		// System.out.println(courseList.getSuccessMessage());
		course.deleteCourse(web, map.get("Name"));
		soft.assertEquals(course.getSuccessMessage(), "Success!");
		// System.out.println(courseList.getSuccessMessage());

		if (course.getSuccessMessage().equals("Success!"))
			excel.updateTestStatus("Add Course", "Pass", IConstantPath.EXCEL_PATH);
		else
			excel.updateTestStatus("Add Course", "Fail", IConstantPath.EXCEL_PATH);
		soft.assertAll();

	}

}