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
import coreFramework.helper.WaitHelper;

public class WesternGenrePage {

	public WesternGenrePage(WebDriver driver) {
		LocalBrowserInitialzation.driver = driver;
		PageFactory.initElements(LocalBrowserInitialzation.driver, this);

	}

	@FindAll(@FindBy(how = How.CSS, using = "div[class='inline-block ratings-imdb-rating']"))
	private List<WebElement> rating;

	@FindAll(@FindBy(how = How.CSS, using = "p[class='sort-num_votes-visible']"))
	private List<WebElement> numberOfVotesAndGrossInList;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Number of Votes')]")
	private WebElement numberOfVotesText;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'US Box Office')]")
	private WebElement usBoxOfficeText;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Runtime')]")
	private WebElement runtimeText;
	
	@FindAll(@FindBy(how = How.CSS, using = "span[class='runtime']"))
	private List<WebElement> runTimeList;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Year')]")
	private WebElement yearText;
	
	@FindAll(@FindBy(how = How.CSS, using = "span[class='lister-item-year text-muted unbold']"))
	private List<WebElement> yearList;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Release Date')]")
	private WebElement releaseDateText;
	
	@FindAll(@FindBy(how = How.CSS, using = "span[class='lister-item-index unbold text-primary']"))
	private List<WebElement> listOfMovieTitles;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Your Rating')]")
	private WebElement yourRatingText;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Popularity')]")
	private WebElement popularityText;

	@FindBy(how = How.XPATH, using = "//a[contains(text(),'A-Z')]")
	private WebElement aToZText;
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Date of Your Rating')]")
	private WebElement dateOfYourRatingText;
	
	
	
	
	
	
	
	
	
	
	public List<String> getListOfRatingInWesternGenre() {
		int i;
		List<String> ratingsList = new ArrayList<>();
		for (i = 0; i <= rating.size() - 1; i++) {
			ratingsList.add(this.rating.get(i).getText());

		}

		return (ratingsList);

	}

	public List<String> sortValues(List<String> value) {
		Collections.sort(value, Collections.reverseOrder());
		return (value);

	}
	
	public List<String> getListOfNumberOfVotesInWesternGenre() {
		int i;
		List<String> numberOfVotesList = new ArrayList<>();
		for (i = 0; i <= this.numberOfVotesAndGrossInList.size() - 1; i++) {
			numberOfVotesList.add(this.numberOfVotesAndGrossInList.get(i).getText().replaceAll("\\s", "").substring(6).split("G")[0]);

		}

		return (numberOfVotesList);

	}
	
	public List<String> getListOfGrossInWesternGenre() {
		int i;
		List<String> numberOfVotesList = new ArrayList<>();
		for (i = 0; i <= 7; i++) {
			numberOfVotesList.add(this.numberOfVotesAndGrossInList.get(i).getText().substring(this.numberOfVotesAndGrossInList.get(i).getText().indexOf("$")));

		}

		return (numberOfVotesList);

	}
	
	public List<Integer> getListOfRunTime() {
		int i;
		List<Integer> listOfRunTime = new ArrayList<>();
		for (i = 0; i <= runTimeList.size() - 1; i++) {
			listOfRunTime.add(Integer.parseInt(this.runTimeList.get(i).getText().replaceAll("\\s.*", "")));

		}

		return (listOfRunTime);

	}
	
	public List<Integer> getListOfYear() {
		int i;
		List<Integer> listOfYear = new ArrayList<>();
		for (i = 0; i <= yearList.size() - 1; i++) {
			listOfYear.add(Integer.parseInt(this.yearList.get(i).getText().substring(1, 5)));

		}

		return (listOfYear);

	}
	

	public WesternGenrePage clickOnNumberOfVotes() {
		WaitHelper.isClickable(this.numberOfVotesText, LocalBrowserInitialzation.driver);
		this.numberOfVotesText.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}
	
	public WesternGenrePage clickOnusBoxOfficeText() {
		WaitHelper.isClickable(this.usBoxOfficeText, LocalBrowserInitialzation.driver);
		this.usBoxOfficeText.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}
	
	public WesternGenrePage clickOnRuntime() {
		WaitHelper.isClickable(this.runtimeText, LocalBrowserInitialzation.driver);
		this.runtimeText.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}
	
	public WesternGenrePage clickOnYearText() {
		WaitHelper.isClickable(this.yearText, LocalBrowserInitialzation.driver);
		this.yearText.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}
	
	public WesternGenrePage clickOnReleaseDateText() {
		WaitHelper.isvisible(this.releaseDateText, LocalBrowserInitialzation.driver);
		this.releaseDateText.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}
	
	public WesternGenrePage clickOnYourRatingText() {
		WaitHelper.isClickable(this.yourRatingText, LocalBrowserInitialzation.driver);
		this.yourRatingText.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}
	
	public WesternGenrePage clickOnPopularityText() {
		WaitHelper.isClickable(this.popularityText, LocalBrowserInitialzation.driver);
		this.popularityText.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}
	
	public WesternGenrePage clickOnAToZText() {
		WaitHelper.isClickable(this.aToZText, LocalBrowserInitialzation.driver);
		this.aToZText.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}
	
	public WesternGenrePage clickOnDate0fYourRatingText() {
		WaitHelper.isClickable(this.dateOfYourRatingText, LocalBrowserInitialzation.driver);
		this.dateOfYourRatingText.click();
		return new WesternGenrePage(LocalBrowserInitialzation.driver);

	}
	
	
	
	
	
	
	public List<String> sortValuesDecending(List<String> value) {
		Collections.sort(value);
		return (value);

	}
	
	public List<Integer> sortValuesDecendingInInteger(List<Integer> value) {
		Collections.sort(value);
		return (value);

	}

	public int countTheNumberOfMoviesUnderWesternGenre() {
		return this.listOfMovieTitles.size();
		// return new TopRatedMoviesPage(LocalBrowserInitialzation.driver);

	}
	
	

}
