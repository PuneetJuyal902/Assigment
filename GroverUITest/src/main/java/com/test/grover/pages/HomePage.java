package com.test.grover.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import coreFramework.base.LocalBrowserInitialzation;
import coreFramework.helper.WaitHelper;

public class HomePage {

	public HomePage(WebDriver driver) {
		LocalBrowserInitialzation.driver = driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);

	}

	@FindBy(how = How.CSS, using = "label[id='imdbHeader-navDrawerOpen--desktop']")
	private WebElement mainMenu;
	
	@FindBy(how = How.CSS, using = "a[href='/chart/top/?ref_=nv_mv_250']")
	private WebElement topRatedMovies;

	public HomePage clickOnMainMenu() {
		WaitHelper.isClickable(this.mainMenu, LocalBrowserInitialzation.driver);
		this.mainMenu.click();
		return new HomePage(LocalBrowserInitialzation.driver);

	}
	
	public TopRatedMoviesPage clickOnTopRatedMovies() {
		WaitHelper.isClickable(this.topRatedMovies, LocalBrowserInitialzation.driver);
		this.topRatedMovies.click();
		return new TopRatedMoviesPage(LocalBrowserInitialzation.driver);

	}
}