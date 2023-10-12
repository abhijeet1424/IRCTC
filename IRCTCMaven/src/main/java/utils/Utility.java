package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.ss.usermodel.Cell;

public class Utility {
	
	public static String getDataFromExcelSheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		String data="";
		String filepath="src\\test\\resources\\TestDataResource\\IRCTC_TicketBookingData.xlsx";
		InputStream file=new FileInputStream(filepath);
		Workbook workbook=WorkbookFactory.create(file);
		Sheet excelSheet=workbook.getSheet(sheet);
		Row excelRow=excelSheet.getRow(row);
		Cell excelCell=excelRow.getCell(cell);
		
		try
		{
			data=excelCell.getStringCellValue();
		} 
		
		catch (Exception e)
		{
			double value=excelCell.getNumericCellValue();
			data=value+"";
		}
		file.close();
		return data;
		
	}
	
	public static Date getDateFromExcelsheet(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
	{
		{
			Date date;
			String filepath="src\\test\\resources\\TestDataResource\\IRCTC_TicketBookingData.xlsx";
			InputStream file=new FileInputStream(filepath);
			Workbook workbook=WorkbookFactory.create(file);
			Sheet excelSheet=workbook.getSheet(sheet);
			Row excelRow=excelSheet.getRow(row);
			Cell excelCell=excelRow.getCell(cell);
			
			date= excelCell.getDateCellValue();
			System.out.println(date);
			file.close();
			return date;
			
		}
	}

}
