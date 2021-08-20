package testCases;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.test.grover.base.TestBase;
import com.test.grover.pages.HomePage;
import com.test.grover.pages.TopRatedMoviesPage;
import com.test.grover.pages.WesternGenrePage;
import com.test.utility.ConfigReader;

import coreFramework.base.LocalBrowserInitialzation;
import coreFramework.helper.AssertionHelper;

public class Tc_02_verify_if_sorting_working_as_expected_under_western_genre  extends TestBase{
	
	ConfigReader reader= new ConfigReader();
	HomePage homePage;
	
	WesternGenrePage westernGenrePage;
	
	@Test(priority=0)
	public void verify_if_user_able_to_sort_by_ratings_under_western_page() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		        homePage
				.clickOnMainMenu()
				.clickOnTopRatedMovies()
				.clickOnWestern();
		        Assert.assertEquals(westernGenrePage.getListOfRatingInWesternGenre(),westernGenrePage.sortValues(westernGenrePage.getListOfRatingInWesternGenre()));
				
	}
	
	@Test(priority=1)
	public void verify_if_user_able_to_sort_by_votes_under_western_page() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		         westernGenrePage
		        .clickOnNumberOfVotes();
		        Assert.assertEquals(westernGenrePage.getListOfNumberOfVotesInWesternGenre(),westernGenrePage.sortValuesDecending(westernGenrePage.getListOfNumberOfVotesInWesternGenre()));
				
	}
	
	@Test(priority=2)
	public void verify_if_user_able_to_sort_by_us_box_office_under_western_page() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		         westernGenrePage
		        .clickOnusBoxOfficeText();
		       Assert.assertEquals(westernGenrePage.getListOfGrossInWesternGenre(),westernGenrePage.sortValuesDecending(westernGenrePage.getListOfGrossInWesternGenre()));
				
	}
	
	@Test(priority=3)
	public void verify_if_user_able_to_sort_by_run_time_under_western_page() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		         westernGenrePage
		        .clickOnRuntime();
		      Assert.assertEquals(westernGenrePage.getListOfRunTime(),westernGenrePage.sortValuesDecendingInInteger(westernGenrePage.getListOfRunTime()));
				
	}
	
	@Test(priority=4)
	public void verify_if_user_able_to_sort_by_year_under_western_page() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		         westernGenrePage
		        .clickOnYearText();
		      Assert.assertEquals(westernGenrePage.getListOfYear(),westernGenrePage.sortValuesDecendingInInteger(westernGenrePage.getListOfYear()));
				
	}
	
	@Test(priority=5)
	public void verify_if_user_able_to_sort_by_release_date_under_western_page() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		         westernGenrePage
		        .clickOnReleaseDateText();
		      Assert.assertEquals(westernGenrePage.getListOfYear(),westernGenrePage.sortValuesDecendingInInteger(westernGenrePage.getListOfYear()));
				
	}
	
	@Test(priority=6)
	public void verify_if_user_able_to_sort_by__date_of_your_rating_under_western_page() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		         westernGenrePage
		        .clickOnDate0fYourRatingText();
		         AssertionHelper.softAssertToCompareIntegers(westernGenrePage.countTheNumberOfMoviesUnderWesternGenre(), 50, "Count_of_movies_under_western_genere_are_not_matching");
				
	}
	
	
	@Test(priority=7)
	public void verify_if_user_able_to_see_list_of_movies_when_your_rating_is_selected() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		         westernGenrePage
		       .clickOnYourRatingText();
		        AssertionHelper.softAssertToCompareIntegers(westernGenrePage.countTheNumberOfMoviesUnderWesternGenre(), 50, "Count_of_movies_under_western_genere_are_not_matching");
		 		   
		  
				
	}
	
	@Test(priority=8)
	public void verify_if_user_able_to_see_list_of_movies_when_popularity_is_selected() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		         westernGenrePage
		       .clickOnPopularityText();
		        AssertionHelper.softAssertToCompareIntegers(westernGenrePage.countTheNumberOfMoviesUnderWesternGenre(), 50, "Count_of_movies_under_western_genere_are_not_matching");
		 		   
		  
				
	}
	
	@Test(priority=9)
	public void verify_if_user_able_to_see_list_of_movies_when_a_to_z_is_selected() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		westernGenrePage=new WesternGenrePage(LocalBrowserInitialzation.driver);
		
		         westernGenrePage
		       .clickOnAToZText();
		        AssertionHelper.softAssertToCompareIntegers(westernGenrePage.countTheNumberOfMoviesUnderWesternGenre(), 50, "Count_of_movies_under_western_genere_are_not_matching");
		 		   
		  
				
	}
	
	
	
	
	

	
	
	
	





}
