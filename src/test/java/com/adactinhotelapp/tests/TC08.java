package com.adactinhotelapp.tests;

import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.LoginPage;
import com.adactinhotelapp.pages.SearchHotelPage;
import com.adactinhotelapp.pages.SelectHotelPage;
import com.adactinhotelapp.utils.ExcelUtils;

public class TC08 extends BaseTest {
	@Test(dataProvider = "getTestData")
	public void validateSearchHotelTest(HashMap<String, String> dataMap) throws InterruptedException 
	{
		LoginPage lp=new LoginPage(driver);
		lp.doLogin();
		Assert.assertEquals(lp.getTitle(), AppConstants.SEARCH_HOTEL_PAGE_TITLE);
		SearchHotelPage shp=new SearchHotelPage(driver);
		shp.locationDropdown(dataMap.get("Location"));
		shp.HotelDropdown(dataMap.get("Hotels"));
		shp.RoomtypeDropdown(dataMap.get("Room Type"));
		shp.RoomNosDropdown(dataMap.get("Number of Rooms"));
		shp.CheckInDate(dataMap.get("Checkindate"));
		shp.CheckOutDate(dataMap.get("Checkoutdate"));
		shp.adultsPerRoomDropdown(dataMap.get("Adults per Room"));
		shp.SearchButton();
		SelectHotelPage SelectHotel =new SelectHotelPage(driver);
		int PriceperNight = SelectHotel.PricePerNight();
		int Noofrooms = SelectHotel.NoofroomsOnSelectHotel();
		int Noofdays = SelectHotel.NoofdaysSelectHotel();
		int ExpectedTotalprice = (PriceperNight*Noofrooms*Noofdays);
		int ActualTotalprice =	SelectHotel.TotalPriceonSelectHotel();
		Assert.assertEquals(ActualTotalprice, ExpectedTotalprice);
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data=new Object[1][1];
		HashMap<String, String> testDataMap=ExcelUtils.getTestDataFromExcel("TC08");
		data[0][0]=testDataMap;
		return data;
		
	}
	

}
