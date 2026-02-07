package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.LoginPage;
import com.adactinhotelapp.pages.SearchHotelPage;
import com.adactinhotelapp.utils.ExcelUtils;

public class ValidateSearchHotelPagePOMUsingPF extends BaseTest{
	
	@Test(dataProvider = "getTestData")
	public void validateSearchHotelTest(HashMap<String, String> dataMap)
	{
		//LoginPage lp=new LoginPage(driver);
		LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.doLogin();
		Assert.assertEquals(lp.getTitle(), AppConstants.SEARCH_HOTEL_PAGE_TITLE);
		
		SearchHotelPage shp=new SearchHotelPage(driver);
		//SearchHotelPage shp=PageFactory.initElements(driver, SearchHotelPage.class);
		//shp.locationDropdown(dataMap.get("Location"));
		//shp.HotelDropdown(dataMap.get("Hotels"));
		//	shp.RoomtypeDropdown(dataMap.get("Room Type"));
		//	shp.RoomNosDropdown(dataMap.get("Number of Rooms"));
		//	shp.adultsPerRoomDropdown(dataMap.get("Adults per Room"));
		//	shp.SearchButton();
		shp.SearchHotel(dataMap);
	}
	
	@DataProvider
	public Object[][] getTestData()
	{
		Object[][] data=new Object[1][1];
		HashMap<String, String> testDataMap=ExcelUtils.getTestDataFromExcel("TC02");
		data[0][0]=testDataMap;
		return data;
		
	}
	

}
