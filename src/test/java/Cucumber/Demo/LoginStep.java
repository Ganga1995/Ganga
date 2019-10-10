package Cucumber.Demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class LoginStep {
	WebDriver driver;
	@Given("^Launch the browser$")
	public void launch_the_browser() throws Throwable {
		//driver=TestUtilityClass.openBrowser("Chrome");
		driver=TestUtilityClass.openBrowser("Ie");
		driver.get("http://newtours.demoaut.com/");
	}

	@When("^Enter the credetials and perform login$")
	public void enter_the_credetials_and_perform_login() throws Throwable {
		LoginPage page= new LoginPage(driver);
		page.login("tutorial", "tutorial");
	}

	@Then("^Test If login works Successfully$")
	public void test_If_login_works_Successfully() throws Throwable {
		WebDriverWait wait= new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.name("tripType")));
		Assert.assertEquals(driver.getTitle(), "Find a Flight: Mercury Tours:");
		System.out.println("Logged in Successfully !!");
		driver.close();
	}


}
