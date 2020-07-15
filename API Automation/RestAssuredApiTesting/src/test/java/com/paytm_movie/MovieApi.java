package com.paytm_movie;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.response.ResponseOptions;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.json.simple.JSONArray;

public class MovieApi extends RestUtils
{
	
	// Test Data is provided from RestUtil.java file
	
	@Test(dataProvider="TestApi") 
	public void requestParameter(int code,String date,String url, String movieCode, String language)
	{
		int status = code;
		String pattern = "yyyy-MM-dd";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

		String currentDate = simpleDateFormat.format(new Date());
		
		// to check if url contains .jpg extension and release date is not before today
		if(date.compareTo(currentDate)<1 || !url.contains(".jpg"))
		{
		   status= 404;
		}
		
		
	    given().when().
			get("https://apiproxy.paytm.com/v2/movies/upcoming").
		then().body("upcomingMovieData.releaseDate", Matchers.hasItem(date)).and().body("upcomingMovieData.moviePosterUrl", Matchers.hasItem(url)).and().
			body("upcomingMovieData.paytmMovieCode", Matchers.hasItem(movieCode)).and().body("upcomingMovieData.language", Matchers.hasItem(language)).assertThat().statusCode(code);
	    
		Assert.assertEquals(status, code);
	    		  
	    		  
	    		 
	}
	
	
	
	
	 
	 
	
	
	
	
}
