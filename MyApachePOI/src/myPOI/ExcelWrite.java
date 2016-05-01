package myPOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelWrite {

	public void writeExcel(String filePath, String sheetName) throws IOException{
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook mWB = null;
		String ext = FilenameUtils.getExtension(filePath);
		if (ext.equals("xls")) {
			mWB = new HSSFWorkbook(fis);
			System.out.println("this is a xls file");
		}
		else if (ext.equals("xlsx")) {
			mWB = new XSSFWorkbook(filePath);
			System.out.println("this is a xlsx file");
		}
		
		Sheet mS = mWB.getSheet(sheetName);
		mS.getRow(0).createCell(6).setCellValue("Status");

		for(int i = 0; i < mS.getLastRowNum(); i++){
		Row r = mS.getRow(i+1);	
		if (r.getCell(5).getStringCellValue().equals("paid")) {
			r.createCell(6).setCellValue("pass");
			}
		else if (r.getCell(5).getStringCellValue().equals("unpaid")) {
			r.createCell(6).setCellValue("fail");
			}
		}	
		
		FileOutputStream fos = new FileOutputStream(file);
		mWB.write(fos);
		mWB.close();
	}
	public static void main(String[] args) throws IOException {
		String filePath = "C:\\temp\\ExportExcel_xls.xls";
		ExcelWrite obj = new ExcelWrite();
		obj.writeExcel(filePath, "Sheet1");
	}

}
