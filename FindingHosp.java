package hackathon.FindingHospitals;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Practo {
	public static WebDriver driver;
	public WebDriver Driver(String browser) {
		driver=Driver.getDriver(browser);
		driver.manage().window().maximize();
		driver.get("https://www.practo.com");
		driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);
		return driver;
	}
	public void search() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement city=driver.findElement(By.xpath("//input[@placeholder='Search location']"));
		city.clear();
		city.sendKeys("Bangalore");
		WebElement hosp=driver.findElement(By.xpath("//input[@placeholder='Search doctors, clinics, hospitals, etc.']"));
		hosp.sendKeys("Hospital",Keys.ENTER);
		WebElement hospEnter=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='c-omni-suggestion-item__content']/div[contains(text(),Hospital)]//ancestor::div[@data-qa-id='omni-suggestion-listing']//span[@class='c-omni-suggestion-item__right']/span[contains(text(),'TYPE')]")));
		hospEnter.click();
		//*[@id="c-omni-container"]/div/div[2]/div[2]/div[1]/div[2]/span[1]/div
	}
	
	public static void main(String[] args) throws InterruptedException {
		Practo site=new Practo();
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the browser (Chrome / Edge) : ");
		String driverName=sc.nextLine();
		site.Driver(driverName);
		
		site.search();
		
//		wait.wait();
//		driver.close();
	}

}

