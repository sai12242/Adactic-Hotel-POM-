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
	
	@FindBy(id = "room_type_0")
	private WebElement RoomtypeOnSelectHotel;
	
	@FindBy(id = "no_days_0")
	private WebElement NoofdaysSelectHotel;
	
	@FindBy(id = "price_night_0")
	private WebElement PricePerNightonSelectHotel;
	
	@FindBy(id = "total_price_0")
	private WebElement TotalPriceonSelectHotel;
	
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
	 public String RoomtypeOnSelectHotel() 
		{
		 wait.until(ExpectedConditions.visibilityOf(RoomtypeOnSelectHotel));
		 return RoomtypeOnSelectHotel.getAttribute("value").trim();
		}
	 
	 public int NoofdaysSelectHotel() 
	 {
		 wait.until(ExpectedConditions.visibilityOf(NoofdaysSelectHotel));
	        String text = NoofdaysSelectHotel.getAttribute("value").trim();
	        String number = text.split(" ")[0];
	        return Integer.parseInt(number);
	  }
	 
	 public int PricePerNight() 
	 {
		 wait.until(ExpectedConditions.visibilityOf(PricePerNightonSelectHotel));
	        String text = PricePerNightonSelectHotel.getAttribute("value").trim();
	        String number = text.split(" ")[2];
	        return Integer.parseInt(number);
	  }
	 
	 public int TotalPriceonSelectHotel() 
	 {
		 wait.until(ExpectedConditions.visibilityOf(TotalPriceonSelectHotel));
	        String text = TotalPriceonSelectHotel.getAttribute("value").trim();
	        String number = text.split(" ")[2];
	        return Integer.parseInt(number);
	 }
	 
	 
	 
}
