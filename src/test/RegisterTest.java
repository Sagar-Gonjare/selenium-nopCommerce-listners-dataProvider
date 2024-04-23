package test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import common.BaseSeleniumTest;
import common.IInvolkedMethodListnerImpl;
import page.RegisterPage;

@Listeners(IInvolkedMethodListnerImpl.class)
public class RegisterTest extends BaseSeleniumTest{

	
	@DataProvider(name="registerData")
	public String [][] getRegisterData() {
		
		String [][] registerData= {
				{"Sagar", "Gonjare", "sagargonjare20@gmail.com", "dnyanayog ", "12345678", "12345678"},
				{"Sagar", "Gonjare", "sagargonjare2@gmail.com", "dnyanayog ", "12345678", "12345678"},
				{"Sagar", "Gonjare", "sagargonjare@gmail.com", "dnyanayog ", "12345678", "12345678"},

				
		};
		return registerData;
		
	}
	
	//@Test(dataProvider="registerData")
	@Test(dataProvider="CSVDataProvider")
	public void registerSuccess(String strFirstName,String strLastName,String strEmail
			,String strCompanyName,String strPassWord,String strConfirmPassWord) throws InterruptedException {
		
		
		RegisterPage rp = new RegisterPage();
		rp.register(strFirstName,strLastName,strEmail,strCompanyName,
				strPassWord,strConfirmPassWord);
		
		Thread.sleep(5000);

	
	
	}
}
