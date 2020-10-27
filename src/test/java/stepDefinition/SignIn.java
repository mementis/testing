package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

 
public class SignIn {

	String baseURL;

	WebDriver driver;
	


	@Given("^User lands on homepage$")
	public void user_lands_on_homepage() throws Throwable {
		baseURL  = "http://automationpractice.com/index.php";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mena\\eclipse-workspace\\meniki\\chromedriver.exe");
		driver  = new ChromeDriver();
		driver.get(baseURL);
		assertEquals(driver.getCurrentUrl(), baseURL);
		
		
		
	}

	@When("^User navigates to SignIn Page$")
	public void user_navigates_to_sign_in_page() throws Throwable {
		
		String expectedURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		String expectedPage = "Login - My Store";
		driver.findElement(By.className("login")).click();
		assertEquals(driver.getCurrentUrl(), expectedURL);
		assertEquals(driver.getTitle(), expectedPage);
		
		System.out.println(driver.getTitle());

	}
	@When("^User enters valid username and password$")
	public void user_enters_valid_username_and_password() throws Throwable {

		String validEmail = "mena_tra@yahoo.com";
		String validPassword = "kokoska";
		String url = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		driver.get(url);
		// Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("email")).sendKeys(validEmail);
		driver.findElement(By.name("passwd")).sendKeys(validPassword);
		assertNotNull(driver.findElement(By.className("form-ok")));
		
		driver.findElement(By.name("SubmitLogin")).click();

	}

	@Then("^User gets access to user's account$")
	public void user_gets_access_to_user_s_account() throws Throwable {
			String expURL = "http://automationpractice.com/index.php?controller=my-account";
			driver.get(driver.getCurrentUrl());
			assertEquals(driver.getCurrentUrl(), expURL);

			assertNotNull(driver.findElement(By.className("header_user_info")));

			System.out.println("access");
				
		
	}
	@Then("^User clicks on SignOut button$")
	public void user_clicks_on_sign_out_button() throws Throwable{
		driver.get(driver.getCurrentUrl());
		System.out.println(driver.getCurrentUrl());
		driver.findElement(By.className("logout")).click();
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("^User is no longer logged in$")
	public void user_is_no_longer_logged_in() throws Throwable{
		String outURL = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		assertEquals(driver.getCurrentUrl(), outURL);
		System.out.println(driver.getCurrentUrl());
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}
	
}
