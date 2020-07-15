package com.paytm_movie;
import org.testng.annotations.DataProvider;


public class RestUtils 
{
	@DataProvider(name="TestApi")
	public Object[][] getParameter()
	{
		return new Object[][]
		{
			//to pass the test case
			{200, "2020-10-23",
			"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/images/cinema/KGF-2-App-poster-608x800-a-ca543ffb-3083-4a4f-834a-240085bf3483.jpg",
			"O9UHTU","Kannada"},
			
			
			//to fail the test case
			{404,"2020-07-03",
			"https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/images/cinema/KGF-2-App-poster-608x800-a-ca543ffb-3083-4a4f-834a-240085bf3483.jpg",
				"O9UHTU","English"},
			
			//to pass the test case
			{404, "2020-11-06",
			 "https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/images/cinema/Black-Widow-App-poster-608x800-a7230289-a19e-4581-8f81-5ea3373fbc3f.pdf",
			 "O9TUKD" , "English"},
			
			// to fail the test case
			{200, "2020-07-17",
				 "https://s3-ap-southeast-1.amazonaws.com/assets.paytm.com/images/cinema/_Tenet-608x800-a51c65b2-db40-496e-8eb4-dff438f114b6.jpg",
			  "O9UC5X" , "English"}	 
			
			
				
			
			
			
		
		};
	}

}
