package step_definition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import io.cucumber.java.en.*;

import org.junit.Assert;

public class Add_Cart {
	WebDriver driver = Hooks.driver;

	@When("I click Add to cart in {string}")
	public void i_click_Add_to_cart_in(String productname) {
		String xpath = "//div[@class='inventory_item_name' and text()='placeholder']";
		String dynamic_xpath_product = xpath.replaceAll("placeholder", productname);
		WebElement product = driver.findElement(By.xpath(dynamic_xpath_product));

	}

	@When("I click add to cart for product {string}")
	public void i_click_add_to_cart_for_product(String productname) throws InterruptedException {
		// Write code here that turns the phrase above into concrete actions
		Thread.sleep(3000);
		String xpath_toadd = "//div[@class='inventory_item_name' and text()='placeholder']/following::button[1]";
		String dynamic_xpath_toadd = xpath_toadd.replaceAll("placeholder", productname);

		WebElement shopping_cart = driver.findElement(By.xpath(dynamic_xpath_toadd));
		shopping_cart.click();
	}

	@Then("I should be able to see the product")
	public void i_should_be_able_to_see_the_product() {
		WebElement added_product = driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		String product_name = added_product.getText();

	}

	@Then("I should be able to see the product as {string}")
	public void i_should_be_able_to_see_the_product_as(String Expproduct) {
		String placeholder_xpath = "//div[@class='inventory_item_name' and text()='placeholder']";
		String dynamic_added_xpath = placeholder_xpath.replaceAll("placeholder", Expproduct);
		WebElement added_product = driver.findElement(By.xpath(dynamic_added_xpath));
		String actual_product_name = added_product.getText();

		Assert.assertEquals(actual_product_name, Expproduct);
	}

}
