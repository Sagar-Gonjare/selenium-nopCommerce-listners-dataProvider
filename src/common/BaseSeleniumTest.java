package common;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.testng.annotations.DataProvider;

public class BaseSeleniumTest {
	
//	public static void main(String[] args) throws IOException {
//		csvDataProvider();
//	}
	
	@DataProvider(name = "registerData")
	public String[][] getRegisterData() {

		String[][] registerData = {
				{ "Sagar", "Gonjare", "sagargonjare2004@gmail.com", "dnyanayog ", "12345678", "12345678" },
				{ "Sagar", "Gonjare", "sagargonjare200@gmail.com", "dnyanayog ", "12345678", "12345678" },
				{ "Sagar", "Gonjare", "sagargonjare@20gmail.com", "dnyanayog ", "12345678", "12345678" },

		};
		return registerData;

	}
	
	@DataProvider(name="CSVDataProvider")
	public static String[][] csvDataProvider() throws IOException{
		
		
		
		File file = new File("C:\\Users\\SAGAR\\eclipse-workspace-selenium\\13AprilCSVAndFileDataProvider\\src\\common\\registerData");
		
		FileReader fr = new FileReader(file);
		
		BufferedReader br =new BufferedReader(fr);
		
		int numRows = 0;
        int numColumns = 0;

        String line;

        while ((line = br.readLine()) != null) {
            // Count the number of rows
            numRows++;

            // Split the line by comma to count the number of columns
            String[] columns = line.split(",");
            numColumns = Math.max(numColumns, columns.length);
        }
        br.close();
        
        br =new BufferedReader(new FileReader(file));
        
		String loginData[][] =new String[numRows][numColumns];
		
		int i=0;
		
		while((line=br.readLine())!=null) {
			String [] lineArray=line.split(",");
			loginData[i]=lineArray;
			i=i+1;
			System.out.println(" ");
		}
		
		System.out.println(loginData);
		return loginData;
	}
}
