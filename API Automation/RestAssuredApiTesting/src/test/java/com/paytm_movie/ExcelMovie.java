package com.paytm_movie;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// This code is used to store movie names in excel file

import static io.restassured.RestAssured.given;

	public class ExcelMovie {

	    public static Response doGetRequest(String endpoint) {
	        RestAssured.defaultParser = Parser.JSON;

	        return
	            given().headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
	                when().get(endpoint).
	                then().contentType(ContentType.JSON).extract().response();
	    }
	    
	    
	    public static void main(String[] args) throws Exception 
	    
	    {
	        Response response = doGetRequest("https://apiproxy.paytm.com/v2/movies/upcoming/");

	        List<String> listnames = response.jsonPath().getList("upcomingMovieData.movie_name");
	        
	        List<Integer> listcontent = response.jsonPath().getList("upcomingMovieData.isContentAvailable");
	        
	        List<String> movie = new ArrayList<String>();
	        
	        for(int i=0; i<listnames.size();i++)
	        {
	        	
	        	if(listcontent.get(i)==0)
	        	{	
	        		movie.add(listnames.get(i));
	        	}
	        }
	        
	        System.out.println(movie);
	       
	        
	        String[] columns={"MovieName"};
	        
	        
	        Workbook workbook = new XSSFWorkbook();
	        
	        //Create a sheet 
	        Sheet sheet = workbook.createSheet("Movie");
	        
	        Font headerFont = workbook.createFont();
	        headerFont.setBold(true);
	        headerFont.setFontHeightInPoints((short) 14);
	        headerFont.setColor(IndexedColors.RED.getIndex());
	        
	        CellStyle headerCellStyle = workbook.createCellStyle();
	        headerCellStyle.setFont(headerFont);

	       // Create a Row Header 
	        Row headerRow = sheet.createRow(0);
	        
	        for (int i = 0; i < columns.length; i++) {
	            Cell cell = headerRow.createCell(i);
	            cell.setCellValue(columns[i]);
	            cell.setCellStyle(headerCellStyle);
	          }
	        
	        
	        
	      // Create Other rows and cells to store MovieName
	        int rowNum = 1;
	        for (int i=0; i<movie.size(); i++) {
	          Row row = sheet.createRow(rowNum++);
	          row.createCell(0).setCellValue(movie.get(i));
	          
	        }
	        
	        
	        for (int i = 0; i < columns.length; i++) {
	            sheet.autoSizeColumn(i);
	          }

	        // Write the output to a file name "Movies.xlxs"
	        FileOutputStream fileOut = new FileOutputStream("Movies.xlsx");
	        workbook.write(fileOut);
	        fileOut.close();
	        
	        
	        
	        
	    }
	}


