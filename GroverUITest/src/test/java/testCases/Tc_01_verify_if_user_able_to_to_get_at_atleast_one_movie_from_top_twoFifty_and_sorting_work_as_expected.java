package testCases;

import java.util.Collections;
import java.util.List;

import org.junit.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.test.grover.base.TestBase;
import com.test.grover.pages.HomePage;
import com.test.grover.pages.TopRatedMoviesPage;
import com.test.utility.ConfigReader;

import coreFramework.base.LocalBrowserInitialzation;
import coreFramework.helper.AssertionHelper;


public class Tc_01_verify_if_user_able_to_to_get_at_atleast_one_movie_from_top_twoFifty_and_sorting_work_as_expected extends TestBase{
	
ConfigReader reader= new ConfigReader();
HomePage homePage;
TopRatedMoviesPage topRatedMoviesPage;






	
	@Test(priority=0)
	public void verify_if_user_able_to_get_at_atleast_one_movie_from_top_twoFifty() {
		homePage=new HomePage(LocalBrowserInitialzation.driver);
		int countOfMovies=homePage
				.clickOnMainMenu()
				.clickOnTopRatedMovies()
				.countTheNumberOfTopRatedMovies();
				AssertionHelper.softAssertToCompareIntegers(countOfMovies, 250, "Count_of_movies_are_not_matching");
		
}
	
	@Test(priority=1)
	public void verify_if_user_able_to_sort_by_ranking_in_top_rated_movies_page() {
		
		topRatedMoviesPage=new TopRatedMoviesPage(LocalBrowserInitialzation.driver);
		         topRatedMoviesPage  
				.clickOnDropdownsInTopRatedMoviesPage(0);  
		         Assert.assertEquals(topRatedMoviesPage.getTextOfImdbRating(),topRatedMoviesPage.sortValues(topRatedMoviesPage.getTextOfImdbRating()));
		         
		        	
}
	
	@Test(priority=2)
	public void verify_if_user_able_to_sort_by_ranking_in_top_imdb_rating_page() {
		
		topRatedMoviesPage=new TopRatedMoviesPage(LocalBrowserInitialzation.driver);
		         topRatedMoviesPage  
				.clickOnDropdownsInTopRatedMoviesPage(1);  
		         Assert.assertEquals(topRatedMoviesPage.getTextOfImdbRating(),topRatedMoviesPage.sortValues(topRatedMoviesPage.getTextOfImdbRating()));
		        	
}
	
	@Test(priority=3)
	public void verify_if_user_able_to_sort_by_date_in_top_imdb_releaseDate_page() {
		
		topRatedMoviesPage=new TopRatedMoviesPage(LocalBrowserInitialzation.driver);
		         topRatedMoviesPage  
				.clickOnDropdownsInTopRatedMoviesPage(2);  
		         Assert.assertEquals(topRatedMoviesPage.getListOfReleaseDate(),topRatedMoviesPage.sortValues(topRatedMoviesPage.getListOfReleaseDate()));
		        	
}
	
	@Test(priority=4)
	public void verify_if_user_able_to_sort_by_your_rating_in_top_imdb_rating_page() {
		
		topRatedMoviesPage=new TopRatedMoviesPage(LocalBrowserInitialzation.driver);
		         topRatedMoviesPage  
				.clickOnDropdownsInTopRatedMoviesPage(4);  
		         Assert.assertEquals(topRatedMoviesPage.getTextOfImdbRating(),topRatedMoviesPage.sortValues(topRatedMoviesPage.getTextOfImdbRating()));
		        	
}
}