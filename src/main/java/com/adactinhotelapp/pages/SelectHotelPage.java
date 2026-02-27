package com.adactinhotelapp.pages;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.utils.ElementUtils;

public class SelectHotelPage extends BasePage {
	private WebDriver driver;
	private ElementUtils elementUtils;
	
	//elements
	@FindBy(id = "location_0")
	private WebElement locationOnSelectHotel;
	
	@FindBy(id = "arr_date_0")
	private WebElement CheckindateOnSelectHotel;
	
	@FindBy(id = "dep_date_0")
	private WebElement CheckOutdateOnSelectHotel;
	
	@FindBy(id = "rooms_0")
	private WebElement NoofroomsOnSelectHotel;
	
	
	public SelectHotelPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		elementUtils=new ElementUtils(driver);
	}
	
	//action methods
	public String locationOnSelectHotel() 
	{
	 wait.until(ExpectedConditions.visibilityOf(locationOnSelectHotel));
	 return locationOnSelectHotel.getAttribute("value").trim();
	}
	
	public String CheckindateOnSelectHotel() 
	{
	 wait.until(ExpectedConditions.visibilityOf( CheckindateOnSelectHotel));
	 return  CheckindateOnSelectHotel.getAttribute("value").trim();
	}
	
	public String CheckOutdateOnSelectHotel() 
	{
	 wait.until(ExpectedConditions.visibilityOf(CheckOutdateOnSelectHotel));
	 return CheckOutdateOnSelectHotel.getAttribute("value").trim();
	}
	
	
	 public int NoofroomsOnSelectHotel() 
	 {
		 wait.until(ExpectedConditions.visibilityOf(NoofroomsOnSelectHotel));
	        String text = NoofroomsOnSelectHotel.getAttribute("value").trim();
	        String number = text.split(" ")[0];
	        return Integer.parseInt(number);
	    }
}
