package com.adactinhotelapp.tests;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.adactinhotelapp.base.BaseTest;
import com.adactinhotelapp.constants.AppConstants;
import com.adactinhotelapp.pages.LoginPage;
import com.adactinhotelapp.utils.ExcelUtils;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;

public class ValidateLoginUsingPOMUsingPF extends BaseTest {
	
	@Description("This is for validating Login using valid credentials")
	@Epic("ADA-1 Authentication")
	@Test()
	public void validateLoginTest()
	{
		LoginPage lp=new LoginPage(driver);
		// LoginPage lp=PageFactory.initElements(driver, LoginPage.class);
		lp.usernameTextbox(prop.getProperty("username"));
		lp.passwordTextbox(prop.getProperty("password"));
		lp.loginButton();
		Assert.assertEquals(lp.getTitle(), AppConstants.SEARCH_HOTEL_PAGE_TITLE);
	}
	


}
