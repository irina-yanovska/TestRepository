package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import base.BaseTest;

public class AddItemToCart extends BaseTest {

	@Test
	public static void addToCart() {
		driver.findElement(By.cssSelector("input#twotabsearchtextbox")).sendKeys("100+ Solutions in Java");
		driver.findElement(By.id("nav-search-submit-button")).click();

		//wait until the item found
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".s-product-image-container a[href^='/100-Solution']")));
		System.out.println("element found");
	}
}
