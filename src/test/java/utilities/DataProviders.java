package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	//DataProvider 1
	@DataProvider(name="logindata")
	public String [][] getData() throws IOException{
		
		String path=".\\testData\\OpenCartTestdata.xlsx"; //taking xl file from testData
		
		ExcelUtility xlutils=new ExcelUtility(path); //creating object for XLutility
		int totalrows=xlutils.getRowCount("Sheet1");
		int totalcols=xlutils.getCellCount("Sheet1", 1);
		
		String logindata[][]=new String[totalrows][totalcols]; //creating two dimension array which can store values
		
		for(int i=1; i<=totalrows; i++) //1 //read the data from xl storing in to two dimensional array
		{
			for(int j=0; j<totalcols; j++) //0  i is row j is col
			{
				logindata[i-1][j] = xlutils.getCellData("Sheet1", i, j); //1, 0
			}	
		}
		
		return logindata; //returning two dimensional array
	}
	
	//DataProvider 2
	//DataProvider 3
}
