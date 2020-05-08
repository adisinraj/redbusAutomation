package com.redbus.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.formula.functions.Rows;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static void main(String[] args) {
		getExcelData();
	}

	public static void getExcelData() {

		String filepath = "/RedBusAutomation/src/test/resources/TestData.xlsx";
		try {
			XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filepath));
			for (Sheet sheet : workbook) {
				for (Row row : sheet) {
					for (Cell cells : row) {
						System.out.println(cells);
					}
				}
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
