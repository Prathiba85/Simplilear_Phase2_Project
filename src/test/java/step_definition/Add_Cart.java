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
		
		WebElement product = driver.findElement(By.xpath("//button[text()='Add to cart'][1]"));
		product.click();
		
	   
	}

	@When("I click add to cart")
	public void i_click_add_to_cart() {
		WebElement shopping_cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
		shopping_cart.click();
	    
	}

	@Then("I should be able to see the product")
	public void i_should_be_able_to_see_the_product() {
		WebElement added_product =driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		String product_name = added_product.getText();
	   
	}
	
	@Then("I should be able to see the product as {string}")
	public void i_should_be_able_to_see_the_product_as(String Expproduct) {
		WebElement added_product =driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
		String actual_product_name = added_product.getText();
		
		Assert.assertEquals(actual_product_name, Expproduct);  
	}


}
