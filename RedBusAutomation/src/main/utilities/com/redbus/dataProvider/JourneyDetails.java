package com.redbus.dataProvider;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class JourneyDetails {

	public static void main(String[] args) {
		System.out.println(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx");
	}
	@DataProvider(name = "JourneyDetails")
	public Object[][] provideJourneyDetails(){
		
		try {
		
			XSSFWorkbook workbook =  new XSSFWorkbook(new File(System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx"));
			
			
		} catch (InvalidFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
}
