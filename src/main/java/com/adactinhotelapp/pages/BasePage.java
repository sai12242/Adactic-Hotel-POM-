package com.adactinhotelapp.pages;

import java.io.File;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.adactinhotelapp.factory.DriverFactory;

public class BasePage extends DriverFactory  {
	protected WebDriver driver;
	protected Properties prop;
	protected DriverFactory df;
	protected WebDriverWait wait;
	public BasePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		df=new DriverFactory();
		prop=df.initProp();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public String getTitle()
	{
		return driver.getTitle();
		
	}
	
	

}
