package com.shoppersStack.GenericUtility;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class File_utility {
FileInputStream fis;
	
	public String readPropertyData(String key) throws IOException  {
		fis = new FileInputStream(Framework_constants.propertyPath);
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
	
	public String readExcelData(String sheetNAme,int rowNum,int cellNum) throws EncryptedDocumentException, IOException {
		fis = new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		String value = wb.getSheet(sheetNAme).getRow(rowNum).getCell(cellNum).getStringCellValue();
		return value;
	}
}
