
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers 
{
	static void Prime(int number)
	{
		
		
		// Create an ArrayList of type Integer
	    List<Integer> prime = new ArrayList();
	    int num = 3;
	    for ( int i = 2 ; i <=number ;  )
	      {
	    	  boolean isPrime = true;
	         for ( int j = 2 ; j <= Math.sqrt(num) ; j++ )
	         {
	            if ( num%j == 0 )
	            {
	                isPrime = false;
	                break;
	            }
	         }
	         
	         // if num is prime,  add the num in the list
	         if (isPrime)
	         {
	            prime.add(num);
	            i++;
	         }
	         num++;
	      }         
		
	     System.out.println("First " +number+" prime numbers are:");   
	     
	     //Displaying first n prime numbers 
	      for(int i=0; i<prime.size(); i++)
	      {
	    	  System.out.println(prime.get(i));
	      }
		
		
		
		

	}
	
	public static void main(String[] args) 
	{
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the value of number ");
		String str = sc.next();
				
		try
		{
			
			int number= Integer.parseInt(str); //Convert str into int 
			
			// if number is less than 0
			if(number<=0)
			{
				
				System.out.println("Number should be greater than zero");
				System.exit(0);
			}
			
			//if number is greater than 100
			if(number>100)
			{
				System.out.println("Please enter the number less than or equal to 100");
				System.exit(0);
			}
			
			Prime(number);
			
		}
		catch(NumberFormatException e)
		{
			System.out.println("Number is not valid ");
		}
		
		
	}

}
