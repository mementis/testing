package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.Account;
import utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

public class CreateAccount {
	String baseURL;

	WebDriver driver;
	
	@Given("User lands on authentication page")
	public void user_lands_on_authentication_page() throws Throwable{
		baseURL  = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		driver  = new ChromeDriver();
		driver.get(baseURL);
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mena\\eclipse-workspace\\meniki\\chromedriver.exe");
	    
	}

	@When("User submits valid e-mail into e-mail address box")
	public void user_enters_e_mail_into_e_mail_adress_box() throws Throwable{
		driver.get(baseURL);
		driver.findElement(By.name("email_create")).sendKeys(TestUtils.generateEmail());
		driver.findElement(By.name("SubmitCreate")).click();
		System.out.println(TestUtils.generateEmail());
	   
	}
	
	@Then("User gets redirected to account creation page")
	public void user_gets_redirecetd_to_account_creation_page() throws Throwable {
		driver.getCurrentUrl();
		
		
	    // Write code here that turns the phrase above into concrete actions
	    //throw new io.cucumber.java.PendingException();
	}

	@When("User fills form with valid credentials")
	public void user_fills_form_with_valid_credentials() {

		Account account = TestUtils.generateAccount();
		driver.findElement(By.name("customer_firstname")).sendKeys(account.getFirstName());
		driver.findElement(By.name("customer_lastname")).sendKeys(account.getLastName());
		driver.findElement(By.name("passwd")).sendKeys(account.getPassword());
		driver.findElement(By.name("firstname")).sendKeys(account.getFirstName());
		driver.findElement(By.name("lastname")).sendKeys(account.getLastName());
		driver.findElement(By.name("address1")).sendKeys(String.valueOf(account.getAddress().getPoBox()) + account.getAddress().getAddressName());
		driver.findElement(By.name("city")).sendKeys(account.getCity());
		
		Select dropState = new Select(driver.findElement(By.name("id_state")));
		dropState.selectByVisibleText(account.getState());
		
		driver.findElement(By.name("postcode")).sendKeys(String.valueOf(account.getZipCode()));
		
		Select dropCountry = new Select(driver.findElement(By.name("id_country")));
		dropCountry.selectByVisibleText(account.getCountry());
		
		driver.findElement(By.name("phone_mobile")).sendKeys(account.getPhone().getMobile());
	    driver.findElement(By.name("alias")).sendKeys(account.getAddress().getAliasAddress());
		
	}

	@When("User submits form")
	public void user_submits_form() throws Throwable{
		driver.findElement(By.name("submitAccount")).click();
		
	    
	}

	@Then("User is redirected to user's account")
	public void user_is_redirected_to_user_s_account() throws Throwable{
		driver.getCurrentUrl();
	}

}
