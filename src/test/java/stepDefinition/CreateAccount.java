package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import page_objects.Account;
import utils.TestUtils;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.concurrent.TimeUnit;

public class CreateAccount {
	
	String baseURL;
	WebDriver driver;
	
	
	@Given("User lands on authentication page")
	public void user_lands_on_authentication_page() throws Throwable{
		baseURL  = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Mena\\eclipse-workspace\\meniki\\chromedriver.exe");
		driver  = new ChromeDriver();
		driver.get(baseURL);
	}

	@When("User submits valid e-mail into e-mail address box")
	public void user_enters_e_mail_into_e_mail_adress_box() throws Throwable{
		//driver.get(baseURL);
		driver.findElement(By.name("email_create")).sendKeys(TestUtils.generateEmail());
		driver.findElement(By.name("SubmitCreate")).click();
		
		System.out.println(TestUtils.generateEmail());
	   
	}
	
	@Then("User gets redirected to account creation page")
	public void user_gets_redirecetd_to_account_creation_page() throws Throwable {
		driver.getCurrentUrl();
	
		
	    
	}

	@When("User fills form with valid credentials")
	public void user_fills_form_with_valid_credentials() throws Throwable{
		//driver.navigate().to(baseURL + "#account-creation");
		WebDriverWait wdw = new WebDriverWait(driver, 10);
		WebElement we = wdw.until(ExpectedConditions.presenceOfElementLocated(By.id("account-creation_form")));
		Account account = TestUtils.generateAccount();
		
		we.findElement(By.name("customer_firstname")).sendKeys(account.getFirstName());
		we.findElement(By.name("customer_lastname")).sendKeys(account.getLastName());
		we.findElement(By.name("passwd")).sendKeys(account.getPassword());
		we.findElement(By.name("firstname")).sendKeys(account.getFirstName());
		we.findElement(By.name("lastname")).sendKeys(account.getLastName());
		we.findElement(By.name("address1")).sendKeys(String.valueOf(account.getAddress().getPoBox()) + account.getAddress().getAddressName());
		we.findElement(By.name("city")).sendKeys(account.getCity());
		
		Select dropState = new Select(we.findElement(By.name("id_state")));
		dropState.selectByVisibleText(account.getState());
		
		we.findElement(By.name("postcode")).sendKeys(String.valueOf(account.getZipCode()));
		
		Select dropCountry = new Select(we.findElement(By.name("id_country")));
		dropCountry.selectByVisibleText(account.getCountry());
		
		we.findElement(By.name("phone_mobile")).sendKeys(account.getPhone().getMobile());
	    we.findElement(By.name("alias")).sendKeys(account.getAddress().getAliasAddress());
		
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
