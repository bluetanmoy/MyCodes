package executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Properties;



import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

public class DriverScript {

	public static Properties OR;
	public static ActionKeywords actionKeywords;
	public static String sActionKeyword;
	public static String sPageObject;
	public static Method method[];
	
	public DriverScript()throws NoSuchMethodException, SecurityException{
		actionKeywords = new ActionKeywords();
		method = actionKeywords.getClass().getMethods();
	}
	
	
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		ExcelUtils.setExcelFile(Constants.Path_TestData, Constants.Sheet_TestSteps);
		FileInputStream fiS = new FileInputStream(Constants.Path_OR);
		OR = new Properties(System.getProperties());
		OR.load(fiS);
		
		for(int iRow =1; iRow<=9; iRow++){
			sActionKeyword = ExcelUtils.getCellData(iRow, Constants.Col_ActionKeyword);
			sPageObject = ExcelUtils.getCellData(iRow, Constants.Col_PageObject);
			execute_Actions();
		}
		
		
	}


	private static void execute_Actions() throws Exception {
		// TODO Auto-generated method stub
		for (int i=0; i<method.length; i++){
			if(method[i].getName().equals(sActionKeyword)){
				method[i].invoke(actionKeywords, sPageObject);
			}
			
		}
	}

}
