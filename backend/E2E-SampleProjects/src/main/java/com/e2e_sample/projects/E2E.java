package com.e2e_sample.projects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2E {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:/Selenium/BrowserDrivers/ChromeDriver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_0")).click();
		
		/*To select from and to address*/
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='DEL']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();
		
		/*To check whether calender is disabled for One way*/
		if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5"))
		{
			System.out.println("Disabled");
			Assert.assertTrue(true);
		}
		else{
			Assert.assertTrue(false);
		}
		
		/*To select currency*/
		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select dropDown = new Select(staticDropdown);
		dropDown.selectByIndex(2);
		System.out.println(dropDown.getFirstSelectedOption().getText());
		
		/*To select checkbox*/
		driver.findElement(By.cssSelector("input[id ='ctl00_mainContent_chk_SeniorCitizenDiscount']")).click();
		
		/*To select passengers*/
		driver.findElement(By.id("divpaxinfo")).click();
//		driver.findElement(By.id("divpaxinfo")).getText();
		Thread.sleep(1000);
		for(int i=1;i<4;i++){
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		driver.findElement(By.id("btnclosepaxoption")).click();
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		
		/*To click on search button*/
		driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();

	}

}
