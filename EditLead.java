package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) {
		//setup chromedriver
		WebDriverManager.chromedriver().setup();
		
		//Create an object for the chromedriver and open the browser
		ChromeDriver driver = new ChromeDriver();
		
		//1. Launch the URL
		driver.get("http://leaftaps.com/opentaps/control/main");
		
		//maximize the browser window
		driver.manage().window().maximize();

		//Identify WebElement
		//2. Enter UserName and Password Using Id Locator
		WebElement eleUserName = driver.findElement(By.id("username"));
		eleUserName.sendKeys("DemoSalesManager");
		driver.findElement(By.id("password")).sendKeys("crmsfa");
		
		//3. Click on Login Button using Class Locator 
		driver.findElement(By.className("decorativeSubmit")).click();
		
		//4. Click on CRM/SFA Link		
		driver.findElement(By.linkText("CRM/SFA")).click();
		
		//5. Click on Leads button		
		driver.findElement(By.linkText("Leads")).click();
		
		//6. Click on Create Lead 
		driver.findElement(By.linkText("Create Lead")).click();
		
		//7. Enter CompanyName Field Using id Locator
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys("TestLeaf");
		
		//8.Enter FirstName Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys("Dhayaranjani");
		
		//9. Enter LastName Field Using id Locator
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys("Subbiah");
		
		//10. Enter FirstName(Local) Field Using id Locator
		driver.findElement(By.id("createLeadForm_firstNameLocal")).sendKeys("Dhaya");
		
		//11. Enter Department Field Using any Locator of Your Choice
		driver.findElement(By.id("createLeadForm_departmentName")).sendKeys("Information Technology");
		
		//12. Enter Description Field Using any Locator of your choice
		driver.findElement(By.id("createLeadForm_description")).sendKeys("This is the TestLeaf test data for the description.");
		
		//13. Enter your email in the E-mail address Field using the locator of your choice
		driver.findElement(By.id("createLeadForm_primaryEmail")).sendKeys("dhayaranjani@gmail.com");
		
		//Select Conference in the dropdown
		//1. Identify the dropdrown element (Select tag)
		WebElement eleSource = driver.findElement(By.id("createLeadForm_dataSourceId"));
		//2.Create an object for Select class and link with the dropdown element
		Select dropdownSource = new Select(eleSource); //pass the element to the constructor		
		//a) Choose the option based on value
		dropdownSource.selectByValue("LEAD_CONFERENCE");
		//b) Choose the option based on visible text
		//c) Choose the option based on index

		//14. Select State/Province as NewYork Using Visible Text
		//1. Identify the dropdrown element (Select tag)
		WebElement selState = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		//2. Create an object for Select class and link with the dropdown element
		Select dropdownState = new Select(selState);
		//a) Choose the option based on value
		//b) Choose the option based on visible text
		dropdownState.selectByVisibleText("New York");
		//c) Choose the option based on index
		
		//15. Click on Create Button
		driver.findElement(By.name("submitButton")).click();
		
		//16. Click on Edit Button
		driver.findElement(By.linkText("Edit")).click();
		
		//17. Clear the Description Field using .clear()
		driver.findElement(By.id("updateLeadForm_description")).clear();
	
		//18. Fill ImportantNote Field with Any text
		driver.findElement(By.id("updateLeadForm_importantNote")).sendKeys("This is the TestLeaf testdata for the Important Note.");
		
		//19. Click on update button
		driver.findElement(By.className("smallSubmit")).click();
		
		//20. Get the Title of Resulting Page. 
		String title = driver.getTitle();
		System.out.println("Title of the page: " + title);

	}

}
