package apiUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	
	public String readDataFromExcel(String sheetname, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		String data=wb.getSheet(sheetname).getRow(row).getCell(cell).toString();
		return data;
	}


    public void writeDataIntoExcel(String sheetname,int row,int cell, String value) throws EncryptedDocumentException, IOException {
    	FileInputStream fis=new FileInputStream("");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet(sheetname);
		sh.createRow(row).createCell(cell).setCellValue(value);
		FileOutputStream fos=new FileOutputStream("");
		wb.write(fos);
    }
    
}
