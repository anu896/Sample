package EndToEnd.FrameworkE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjectFactory.Landingpage;
import pageObjectFactory.Loginpage;
import resources.Base;

public class Homepage extends Base{
	public static Logger log=LogManager.getLogger(Base.class.getClass());
	@BeforeTest
	public void initialize() throws IOException {
		driver= initializeDriver();
		log.info("Driver is Initialized");
	
		
	}
	
	
	@Test(dataProvider="getData")
	public void basePageNavigation (String username,String password) throws IOException {
		driver.get(prop.getProperty("url"));
		log.info("Navigate to url");
		Landingpage l=new Landingpage(driver);
		l.getLogin().click();
		log.info("click on login page");
		Loginpage lp=new Loginpage(driver);
		lp.getEmail().sendKeys(username);
		lp.getPassword().sendKeys(password);
		lp.getLogin().click();
		log.info("Verify user and password is working");
	}
		@DataProvider
		public Object[][] getData() {
			Object[][] data=new Object[2][2];
			data[0][0]="nonrestricteduser@qw.com";
			data[0][1]="123456";
			data[1][0]="restricteduser@qw.com";
			data[1][1]="456788";
			return data;
		}
		
		@AfterTest
		public void tearDown() {
			driver.close();
		}
		
	
}
