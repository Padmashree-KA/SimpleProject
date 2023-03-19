package com.ecommerce.app;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleProducts {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/BrowserDrivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		
		int j=0;
		String[] veggies ={"Cucumber","Tomato","Beans"};
		
		List<WebElement> product = driver.findElements(By.cssSelector("h4.product-name"));

		for (int i = 0; i < product.size(); i++) {
			/*Once we get vegetable name we need to format to actual vegetable name: Cucumber - 1 Kg ---> Cucumber */
			String[] vegetableName = product.get(i).getText().split("-"); /*Since we are splitting the name with reference to - it will create an array containing [Cucumber,1kg]*/
			String formatedName =vegetableName[0].trim();
			/*Convert array into array list for easy search*/
			/*To check item is present or not*/
			List veggiesList = Arrays.asList(veggies);
			if (veggiesList.contains(formatedName) ) {
				j++;
//				driver.findElements(By.xpath("//button[text()='ADD TO CART']")).get(i).click();
				                                       /* |
				                                        v
				                             The path is inconsistant ==> we can go for parent child traverse*/
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				
				if(j==veggies.length){
					break;
				}
			}
		}

	}

}
