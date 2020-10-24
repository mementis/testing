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
	
	@Before
	public void before(Scenario scenario){
		baseURL  = "http://automationpractice.com/index.php";
		driver  = new ChromeDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mena\\eclipse-workspace\\meniki\\chromedriver.exe");
		System.out.println(scenario.getName());
	}
	
	@After
	public void after() {
		driver.close();
	}

	@Given("^User lands on homepage$")
	public void user_lands_on_homepage() throws Throwable {
		String expectedValue = "My Store";
		driver.get(baseURL);
		System.out.println(driver.getTitle());
		assertEquals(driver.getTitle(), expectedValue);
		
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
		driver.findElement(By.name("SubmitLogin")).submit();
		assertNotNull(driver.findElement(By.className("header_user_info")));

	}

	@Then("^User gets access to user's account$")
	public void user_gets_access_to_user_s_account() throws Throwable {
		    driver.get(driver.getCurrentUrl());
			System.out.println("access");
				
		
	}
}
