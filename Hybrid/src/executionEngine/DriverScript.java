package executionEngine;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.apache.xmlbeans.impl.xb.xsdschema.Public;
import org.omg.CORBA.PRIVATE_MEMBER;

import config.ActionKeywords;
import config.Constants;
import utility.ExcelUtils;

public class DriverScript {

	public static Properties OR;
	public static ActionKeywords actionKeywords = new ActionKeywords();
	public static String sActionKeyword;
	public static String sPageObject;
	public static Method method[] = actionKeywords.getClass().getMethods();

//	public DriverScript() throws NoSuchMethodException, SecurityException{
//		actionKeywords = new ActionKeywords();
//		method = actionKeywords.getClass().getMethods();
//	}

    public static void main(String[] args) throws Exception {
    	
    	
    	
    	String Path_DataEngine = Constants.Path_TestData;   
    	ExcelUtils.setExcelFile(Path_DataEngine, Constants.Sheet_TestSteps);

    	

    
		//Declaring String variable for storing Object Repository path
    	String Path_OR = Constants.Path_OR;
		//Creating file system object for Object Repository text/property file
		FileInputStream fs = new FileInputStream(Path_OR);
		//Creating an Object of properties
		OR= new Properties(System.getProperties());
		//Loading all the properties from Object Repository property file in to OR object
		OR.load(fs);
		
		for (int iRow=1;iRow<=9;iRow++){
    		sActionKeyword = ExcelUtils.getCellData(iRow, 4);
    		sPageObject = ExcelUtils.getCellData(iRow, 3);
    		System.out.println("action keyword is:"+" "+sActionKeyword+"     and     "+"page object is:"+" "+sPageObject);
    		execute_Actions();	
		}
		
    }


     private static void execute_Actions() throws Exception {
	 
		for(int i=0;i<method.length;i++){
			if(method[i].getName().equals(sActionKeyword)){
				//This is to execute the method or invoking the method
				//Passing 'Page Object' name and 'Action Keyword' as Arguments to this method
				method[i].invoke(actionKeywords,sPageObject);
				break;
				}
			}
		}
 }