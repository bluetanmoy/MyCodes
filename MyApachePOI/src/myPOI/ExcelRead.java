package myPOI;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.String;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.model.ThemesTable.ThemeElement;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public void readExcel(String filePath, String sheetName) throws IOException{
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		Workbook mWB = null;
		String ext = FilenameUtils.getExtension(filePath);
		if(ext.equals("xlsx")){
		mWB = new XSSFWorkbook(fis);
		System.out.println("the file format is XLSX");
		}
		else if (ext.equals("xls")) {
		mWB = new HSSFWorkbook(fis);
		System.out.println("the file format is XLS");
		}
		Sheet mS = mWB.getSheet(sheetName);
		
		for(int i = 0; i <= mS.getLastRowNum(); i ++){
			Row r = mS.getRow(i);
			for(int j = 0; j < r.getLastCellNum(); j++){
				r.getCell(j).setCellType(r.getCell(j).CELL_TYPE_STRING);
				//no matter whats the type of cell value is, it will be converted to String
				System.out.print(r.getCell(j).getStringCellValue()+"||"+" ");
				//notice its not println() but print();
			}
		System.out.println();
		}
	}
	
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ExcelRead obj = new ExcelRead();
		String filePath = "C:\\temp\\ExportExcel_xls.xls";
		//for xlsx file String filePath = "C:\\temp\\ExportExcel.xls";
		obj.readExcel(filePath, "Sheet1");
	}

}
