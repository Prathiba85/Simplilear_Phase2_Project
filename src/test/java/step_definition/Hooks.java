package step_definition;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {
	public static WebDriver driver;

	@Before
	public void Setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(1000, TimeUnit.MILLISECONDS);
		driver.manage().window().maximize();
	}

	@After
	public void teardown() {
		// System.out.println("Scenario status ======>"+scenario.getSteps());
		// byte[] screenshot = ((TakesScreenshot)
		// driver).getScreenshotAs(OutputType.BYTES);
		// scenario.attach(screenshot, "image/png",scenario.getName());

		driver.quit();
	}

}
