package excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.jar.Attributes.Name;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.util.TempFile;
import org.apache.poi.xssf.eventusermodel.XSSFReader;
import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFAnchor;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ReadWriteHybridExcel {
	
		public static void main(String[] args) throws IOException {
			System.out.println("hey");
			ReadHybridExcel();
			//String [][] temp = ReadHybridExcel();
			name();
			//System.out.println(temp[0][0]);
		}
		

		public static void name() throws IOException {
			//String [][] kobita = ReadHybridExcel();
			ReadHybridExcel();
			//System.out.println(kobita[0][2]);
		}
			
			
		
		
		public static String[][] ReadHybridExcel()throws IOException {
		File file = new File("C:\\framework\\hybridExcel.xlsx");
		FileInputStream fis = new FileInputStream(file);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("data");
		
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
        //return data[i][j];
        System.out.println(data[0][0]);
        return data;
              
		}
}
