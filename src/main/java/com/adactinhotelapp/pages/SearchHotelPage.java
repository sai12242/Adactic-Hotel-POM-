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

public class SearchHotelPage extends BasePage {

	private WebDriver driver;
	private ElementUtils elementUtils;
	
	//elements or locators ==> WebElement(with PF) or By (w.o PF)
	
		//By locators 
	
	//private By locationDropdown=By.xpath("//select[@name='location']");
	@FindBy(xpath = "//select[@name='location']")
	private WebElement locationDropdown;
	
	@FindBy(xpath = "//select [@name = 'hotels']")
	private WebElement HotelDropdown;
	
	@FindBy(xpath = "//select [@name = 'room_type']")
	private WebElement RoomtypeDropdown;
	
	@FindBy(xpath = "//select [@name = 'room_nos']")
	private WebElement RoomNosDropdown;
	
	@FindBy(xpath = "//select [@name = 'adult_room']")
	private WebElement adultsPerRoomDropdown;
	
	@FindBy(xpath = "//input [@name = 'Submit']")
	private WebElement SearchButton;

	@FindBy(xpath = "//input [@name='datepick_in']")
	private WebElement CheckInDate;
	
	@FindBy(xpath = "//input [@name='datepick_out']")
	private WebElement CheckOutDate;
	
	@FindBy(xpath = "//span [@id = 'checkin_span']")
	private WebElement CheckInErrorMsg;
	
	@FindBy(xpath = "//span [@id = 'checkout_span']")
	private WebElement CheckOutErrorMsg;
	
	@FindBy(xpath = "//span [@id = 'checkin_span']")
	private WebElement CheckInErrorMsg2;
	
	@FindBy(id = "location_0")
	private WebElement locationOnSelectHotel;
	
	@FindBy(id = "arr_date_0")
	private WebElement CheckindateOnSelectHotel;
	
	@FindBy(id = "dep_date_0")
	private WebElement CheckOutdateOnSelectHotel;
	
	public SearchHotelPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		elementUtils=new ElementUtils(driver);
	}
	
	
	public void locationDropdown(String option)
	{
		//elementUtils.selectByVisibleText(locationDropdown, option);
	locationDropdown.sendKeys(option);
	}
	
	public void HotelDropdown(String option)
	{
		HotelDropdown.sendKeys(option);
	}
	
	public void RoomtypeDropdown(String option)
	{	
		RoomtypeDropdown.sendKeys(option);
	}
	
	public void RoomNosDropdown(String option)
	{
		RoomNosDropdown.sendKeys(option);
	}
	
	public void CheckInDate(String option)
	{
		CheckInDate.clear();
		CheckInDate.sendKeys(option);
	}
	
	public void CheckOutDate(String option)
	{
		CheckOutDate.clear();
		CheckOutDate.sendKeys(option);
	}
	
	public void adultsPerRoomDropdown(String option)
	{
		adultsPerRoomDropdown.sendKeys(option);
	}
	
	public void SearchButton()
	{
		SearchButton.click();
	}
	
	public String GetCheckInErrorMsg()
	{
	return CheckInErrorMsg.getText();
	}

	public String GetCheckOutErrorMsg()
	{
    return CheckOutErrorMsg.getText();
	}
	public String GetCheckInErrorMsg2()
	{
	return CheckInErrorMsg2.getText();
	}
	
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
	
	
	public void SearchHotel(HashMap<String, String> dataMap) {
		locationDropdown.sendKeys(dataMap.get("Location"));
		HotelDropdown.sendKeys(dataMap.get("Hotels"));
		RoomtypeDropdown.sendKeys(dataMap.get("Room Type"));
		RoomNosDropdown.sendKeys(dataMap.get("Number of Rooms"));
		CheckInDate.clear();
		CheckInDate.sendKeys(dataMap.get("Checkindate"));
		CheckOutDate.clear();
		CheckOutDate.sendKeys(dataMap.get("Checkoutdate"));
		adultsPerRoomDropdown.sendKeys(dataMap.get("Adults per Room"));
		SearchButton.click();
	}

}
