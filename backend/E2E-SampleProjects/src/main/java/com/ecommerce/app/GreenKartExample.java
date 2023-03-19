package com.ecommerce.app;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GreenKartExample {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/BrowserDrivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		String[] veggies = { "Cucumber", "Tomato", "Beans" };
		addToCart(driver, veggies);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")).click();
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

	}

	public static void addToCart(WebDriver driver, String[] veggies) {
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));
		int j = 0;
		for (int i = 0; i < product.size(); i++) {
			/*
			 * Once we get vegetable name we need to format to actual vegetable
			 * name: Cucumber - 1 Kg ---> Cucumber
			 */
			String[] vegetableName = product.get(i).getText()
					.split("-"); /*
									 * Since we are splitting the name with
									 * reference to - it will create an array
									 * containing [Cucumber,1kg]
									 */
			String formatedName = vegetableName[0].trim();
			/* Convert array into array list for easy search */
			/* To check item is present or not */
			List veggiesList = Arrays.asList(veggies);
			if (veggiesList.contains(formatedName)) {
				j++;
				// driver.findElements(By.xpath("//button[text()='ADD TO
				// CART']")).get(i).click();
				/*
				 * | v The path is inconsistant ==> we can go for parent child
				 * traverse
				 */
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();

				if (j == veggies.length) {
					break;
				}
			}
		}

	}
}
