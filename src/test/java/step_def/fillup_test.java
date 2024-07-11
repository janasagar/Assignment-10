package step_def;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class fillup_test {
	
	WebDriver driver;
	
	@Given("User visit Simple Form web application")
	public void user_visit_simple_form_web_application() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://v1.training-support.net/selenium/simple-form?");
		driver.manage().window().maximize();
		Thread.sleep(4000);
	    
	}

	@When("User enter {string},{string},{string},{string},{string}")
	public void user_enter(String FirstNmae, String LastName, String Email, String ContactNumber, String Message) {
		driver.findElement(By.id("firstName")).sendKeys(FirstNmae);
		driver.findElement(By.id("lastName")).sendKeys(LastName);
		driver.findElement(By.id("email")).sendKeys(Email);
		driver.findElement(By.id("number")).sendKeys(ContactNumber);
		driver.findElement(By.xpath("//div[@class='field']//textarea")).sendKeys(Message);
		
	
	}

	@When("User click the submit button")
	public void user_click_the_submit_button() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		Thread.sleep(2000);
	    
	}

	@Then("User should get Thank You popup")
	public void user_should_get_thank_you_popup() throws InterruptedException {
		Alert alert = driver.switchTo().alert();
		String msg = alert.getText();
		boolean verify = msg.contains("Thank You");
		Assert.assertTrue(verify);
		alert.accept();
		Thread.sleep(3000);
		
		driver.quit();
	    
	}
	


}
