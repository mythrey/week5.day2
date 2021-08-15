package testcase;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead extends Baseclass {
	@Test(dataProvider="editdata")
	public void TLEditLead(String phNo, String company) throws InterruptedException {
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
		System.out.println("I am Inside EditLead class @Test");
		driver.findElement(By.linkText("Find Leads")).click();
		driver.findElement(By.xpath("//span[text()='Phone']")).click();
		driver.findElement(By.xpath("//input[@name='phoneNumber']")).sendKeys(phNo);
		driver.findElement(By.xpath("//button[text()='Find Leads']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']/a")).click();
		driver.findElement(By.linkText("Edit")).click();
		driver.findElement(By.id("updateLeadForm_companyName")).clear();
		driver.findElement(By.id("updateLeadForm_companyName")).sendKeys(company);
		driver.findElement(By.name("submitButton")).click();
		/* driver.close(); */
	}

	@DataProvider(name = "editdata")
	public String[][] editData() throws IOException {
		ReadExcel re = new ReadExcel();
		return re.readData("EditLead");

	}

}
