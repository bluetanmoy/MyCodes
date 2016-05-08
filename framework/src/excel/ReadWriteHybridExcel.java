package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadWriteHybridExcel {
public static void main(String[] args) throws IOException {
		File file = new File("C:\\framework\\hybridExcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("locators");
	
		
		int rowNum = sheet.getLastRowNum()+1;
        int colNum = sheet.getRow(0).getLastCellNum();
        String[][] data = new String[rowNum][colNum]; 
         
        for (int i=0; i<rowNum; i++){
            //get the row
            XSSFRow row = sheet.getRow(i);
                for (int j=0; j<colNum; j++){
                    //this gets the cell and sets it as blank if it's empty.
                    XSSFCell cell = row.getCell(j, Row.CREATE_NULL_AS_BLANK);
                    String value = String.valueOf(cell);                             
                   // System.out.println("Value: " + value);
                    data[i][j] = value;
                }            
           }
        System.out.println(data[1][0]);
	}

}
