package testcases;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.BaseTest;

public class AddToCartJava extends BaseTest {

	public static void main(String[] args) throws IOException {

		AddToCartJava addToCart = new AddToCartJava();

		addToCart.setUp();

		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("100+ Solutions in Java");
		driver.findElement(By.id("nav-search-submit-button")).click();

		// wait until the item found
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.cssSelector(".s-product-image-container a[href^='/100-Solution']")));

		addToCart.tearDown();

	}

}
