package testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead extends Baseclass {
	@Test(dataProvider = "fetchdata")
	public void TLCreateLead(String company, String firstName, String lastName, String phNo) {
		/*
		 * WebDriverManager.chromedriver().setup(); ChromeDriver driver = new
		 * ChromeDriver(); driver.manage().window().maximize();
		 * driver.get("http://leaftaps.com/opentaps/");
		 * driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		 * driver.findElement(By.id("username")).sendKeys("DemoSalesManager");
		 * driver.findElement(By.id("password")).sendKeys("crmsfa");
		 * driver.findElement(By.className("decorativeSubmit")).click();
		 * driver.findElement(By.linkText("CRM/SFA")).click();
		 * driver.findElement(By.linkText("Leads")).click();
		 */
		driver.findElement(By.linkText("Create Lead")).click();
		driver.findElement(By.id("createLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
		driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
		driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phNo);
		driver.findElement(By.name("submitButton")).click();
		/* driver.close(); */
		System.out.println("I am Inside CreateLead class @Test");
	}

	@DataProvider(name = "fetchdata")
	public String[][] sendData() throws IOException {
		// create object for ReadExcel
		ReadExcel re = new ReadExcel();
		// String[][] data = re.readData();

		return re.readData("CreateLead");

	}

}
