package com.test.grover.pages;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import coreFramework.base.LocalBrowserInitialzation;
import coreFramework.helper.SelectDropDownHelper;
import coreFramework.helper.WaitHelper;

public class TopRatedMoviesPage {

	public TopRatedMoviesPage(WebDriver driver) {
		LocalBrowserInitialzation.driver = driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);

	}

	@FindBy(how = How.CSS, using = "select[id='lister-sort-by-options']")
	private WebElement sortByMenu;

	@FindAll(@FindBy(how = How.CSS, using = "td[class='titleColumn']"))
	private List<WebElement> countForTitles;

	@FindAll(@FindBy(how = How.CSS, using = "td[class='ratingColumn imdbRating']"))
	private List<WebElement> getimdbRating;
	
	@FindAll(@FindBy(how = How.CSS, using = "span[class='secondaryInfo']"))
	private List<WebElement> getreleaseDate;
	
	@FindBy(how = How.CSS, using = "a[href*='western']")
	private WebElement westernGenre;

	public TopRatedMoviesPage clickOnDropdownsInTopRatedMoviesPage(int value) {
		WaitHelper.isClickable(this.sortByMenu, LocalBrowserInitialzation.driver);
		SelectDropDownHelper.selectUsingIndex(this.sortByMenu, value);
		return new TopRatedMoviesPage(LocalBrowserInitialzation.driver);

	}

	public int countTheNumberOfTopRatedMovies() {
		return this.countForTitles.size();
		// return new TopRatedMoviesPage(LocalBrowserInitialzation.driver);

	}

	public List<String> getTextOfImdbRating() {
		int i;
		List<String> listOfImdbRating = new ArrayList<>();
		for (i = 0; i <= getimdbRating.size() - 1; i++) {
			listOfImdbRating.add(this.getimdbRating.get(i).getText());

		}

		return (listOfImdbRating);

	}

	public List<String> sortValues(List<String> value) {
		   Collections.sort(value, Collections.reverseOrder());

		return (value);

	}
	
	public List<String> getListOfReleaseDate() {
		int i;
		List<String> listOfReleaseDate = new ArrayList<>();
		for (i = 0; i <= getreleaseDate.size() - 1; i++) {
			listOfReleaseDate.add(this.getreleaseDate.get(i).getText());

		}

		return (listOfReleaseDate);

	}
	
	public WesternGenrePage clickOnWestern() {
		WaitHelper.isClickable(this.westernGenre, LocalBrowserInitialzation.driver);
		this.westernGenre.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}

}
