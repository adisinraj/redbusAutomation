package com.redbus.util;


	import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


	public class FunctionsUtilities {
		
		public static final String PROJECT_PATH =null;
		static WebDriver driver = null;

		public static ArrayList<String> getColumnDataWithStringValues(String sheetName,String colName,String filepath) throws IOException
		{
	         FileInputStream fis=new FileInputStream(filepath);
	         @SuppressWarnings("resource")
			 XSSFWorkbook wb=new XSSFWorkbook(fis);
	         XSSFSheet sheet;
	         ArrayList<String> str=new ArrayList<String>();
	         int sheets=wb.getNumberOfSheets();
	         int ColumnIndex=0;
	         int i;
	         for(i=0;i<sheets;i++)
	         {
	        	 sheet=wb.getSheetAt(i);
	        	 
	        	 if(wb.getSheetName(i).equalsIgnoreCase(sheetName))
	        	 {
	        		Iterator<Row>  rows = sheet.iterator();
	        		Row firstrow=rows.next();
	        		
	        		Iterator<Cell> cell=firstrow.cellIterator();
	        		int index=0;
	        		while(cell.hasNext())
	        		{
	        			Cell value=cell.next();
	        			if(value.getStringCellValue().equalsIgnoreCase(colName))
	               	 	{
	        				ColumnIndex=index;
	               	 	}
	        			index++;
	        		}
	        		
	        		        	
	        		while(rows.hasNext())
	                {
	               	 Row r=rows.next();
	               	 str.add(r.getCell(ColumnIndex).getStringCellValue());
	                }           
	        		
	        	 }
	         }
	         
	         
	        return str;
	        
	         
	         
	    }
		public static ArrayList<Integer> getColumnDataWithNumericValues(String sheetName,String colName,String filepath) throws IOException
		{
	         FileInputStream fis=new FileInputStream(filepath);
	         @SuppressWarnings("resource")
			 XSSFWorkbook wb=new XSSFWorkbook(fis);
	         XSSFSheet sheet;
	         ArrayList<Integer> num=new ArrayList<Integer>();
	         int sheets=wb.getNumberOfSheets();
	         int ColumnIndex=0;
	         int i;
	         for(i=0;i<sheets;i++)
	         {
	        	 sheet=wb.getSheetAt(i);
	        	 
	        	 if(wb.getSheetName(i).equalsIgnoreCase(sheetName))
	        	 {
	        		Iterator<Row>  rows = sheet.iterator();
	        		Row firstrow=rows.next();
	        		
	        		Iterator<Cell> cell=firstrow.cellIterator();
	        		int index=0;
	        		while(cell.hasNext())
	        		{
	        			Cell value=cell.next();
	        			if(value.getStringCellValue().equalsIgnoreCase(colName))
	               	 	{
	        				ColumnIndex=index;
	               	 	}
	        			index++;
	        		}
	        		
	        		        	
	        		while(rows.hasNext())
	                {
	               	 Row r=rows.next();
	               	 int n=(int) r.getCell(ColumnIndex).getNumericCellValue();
	               	 num.add(n);
	               	}           
	        		
	        	 }
	         }
	         
	         
	       return num;
	         
	 
	    }
		
		
		
		
		public static ArrayList<String> getColumnDataWithStringValues(String sheetName,String colName) throws IOException
		{
	         FileInputStream fis=new FileInputStream(PROJECT_PATH + "/src/test/java/com/jim/testdata/TestData.xlsx");
	         @SuppressWarnings("resource")
			 XSSFWorkbook wb=new XSSFWorkbook(fis);
	         XSSFSheet sheet;
	         ArrayList<String> str=new ArrayList<String>();
	         int sheets=wb.getNumberOfSheets();
	         int ColumnIndex=0;
	         int i;
	         for(i=0;i<sheets;i++)
	         {
	        	 sheet=wb.getSheetAt(i);
	        	 
	        	 if(wb.getSheetName(i).equalsIgnoreCase(sheetName))
	        	 {
	        		Iterator<Row>  rows = sheet.iterator();
	        		Row firstrow=rows.next();
	        		
	        		Iterator<Cell> cell=firstrow.cellIterator();
	        		int index=0;
	        		while(cell.hasNext())
	        		{
	        			Cell value=cell.next();
	        			if(value.getStringCellValue().equalsIgnoreCase(colName))
	               	 	{
	        				ColumnIndex=index;
	               	 	}
	        			index++;
	        		}
	        		
	        		        	
	        		while(rows.hasNext())
	                {
	               	 Row r=rows.next();
	               	 str.add(r.getCell(ColumnIndex).getStringCellValue());
	                }           
	        		
	        	 }
	         }
	         
	         
	        return str;
	        
	         
	         
	    }
		public static ArrayList<Integer> getColumnDataWithNumericValues(String sheetName,String colName) throws IOException
		{
	         FileInputStream fis=new FileInputStream(PROJECT_PATH + "/src/test/java/com/jim/testdata/TestData.xlsx");
	         @SuppressWarnings("resource")
			 XSSFWorkbook wb=new XSSFWorkbook(fis);
	         XSSFSheet sheet;
	         ArrayList<Integer> num=new ArrayList<Integer>();
	         int sheets=wb.getNumberOfSheets();
	         int ColumnIndex=0;
	         int i;
	         for(i=0;i<sheets;i++)
	         {
	        	 sheet=wb.getSheetAt(i);
	        	 
	        	 if(wb.getSheetName(i).equalsIgnoreCase(sheetName))
	        	 {
	        		Iterator<Row>  rows = sheet.iterator();
	        		Row firstrow=rows.next();
	        		
	        		Iterator<Cell> cell=firstrow.cellIterator();
	        		int index=0;
	        		while(cell.hasNext())
	        		{
	        			Cell value=cell.next();
	        			if(value.getStringCellValue().equalsIgnoreCase(colName))
	               	 	{
	        				ColumnIndex=index;
	               	 	}
	        			index++;
	        		}
	        		
	        		        	
	        		while(rows.hasNext())
	                {
	               	 Row r=rows.next();
	               	 int n=(int) r.getCell(ColumnIndex).getNumericCellValue();
	               	 num.add(n);
	               	}           
	        		
	        	 }
	         }
	         
	         
	       return num;
	         
	 
	    }
		
		
		
		public static void mouseHoverJScript(WebElement HoverElement) {
			try {
				if (isElementPresent(HoverElement)) {
					
					String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
					((JavascriptExecutor) driver).executeScript(mouseOverScript,
							HoverElement);

				} else {
					System.out.println("Element was not visible to hover " + "\n");

				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element with " + HoverElement
						+ "is not attached to the page document"
						+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element " + HoverElement + " was not found in DOM"
						+ e.getStackTrace());
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Error occurred while hovering"
						+ e.getStackTrace());
			}
		}

		public static boolean isElementPresent(WebElement element) {
			boolean flag = false;
			try {
				if (element.isDisplayed()
						|| element.isEnabled())
					flag = true;
			} catch (NoSuchElementException e) {
				flag = false;
			} catch (StaleElementReferenceException e) {
				flag = false;
			}
			return flag;
		}
		
		public static void safeJavaScriptClick(WebElement element) throws Exception {
			try {
				if (element.isEnabled() && element.isDisplayed()) {
					System.out.println("Clicking on element with using java script click");

					((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
				} else {
					System.out.println("Unable to click on element");
				}
			} catch (StaleElementReferenceException e) {
				System.out.println("Element is not attached to the page document "+ e.getStackTrace());
			} catch (NoSuchElementException e) {
				System.out.println("Element was not found in DOM "+ e.getStackTrace());
			} catch (Exception e) {
				System.out.println("Unable to click on element "+ e.getStackTrace());
			}
		}
	}


