package step_definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

import org.junit.Assert;

public class LoginStepDefinition {
	WebDriver driver = Hooks.driver;

	@Given("I have launched the application")
	public void i_have_launched_the_application() throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		driver.get("https://www.saucedemo.com/");
		Thread.sleep(5000);

	}

	@When("I enter username as {string}")
	public void i_enter_username_as(String UserName) {
		// Write code here that turns the phrase above into concrete actions
		WebElement userName = driver.findElement(By.xpath("//input[@name='user-name']"));
		userName.sendKeys(UserName);
	}

	@When("I enter password as {string}")
	public void i_enter_password_as(String Password) {
		// Write code here that turns the phrase above into concrete actions
		WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
		password.sendKeys(Password);
	}

	@When("Click on login")
	public void click_on_login() {
		// Write code here that turns the phrase above into concrete actions
		WebElement loginBtn = driver.findElement(By.xpath("//input[@name='login-button']"));
		loginBtn.click();
	}

	@Then("I should be able to login successfully")
	public void i_should_be_able_to_login_successfully() {
		// Write code here that turns the phrase above into concrete actions

		String expected_url = "https://www.saucedemo.com/inventory.html";
		String actual_url = driver.getCurrentUrl();
		Assert.assertEquals(expected_url, actual_url);
		;

	}

	@Then("I should get error message {string}")
	public void i_should_get_error_message(String ExpError) throws InterruptedException {
		Thread.sleep(2000);
		WebElement error = driver.findElement(By.xpath("//*[@data-test='error']"));
		// System.out.println("Actual Error"+error.getText());
		// System.out.println("Expected Error"+ExpError);
		Thread.sleep(3000);
		String ActError = error.getText();
		Assert.assertEquals(ActError, ExpError);
	}

}
