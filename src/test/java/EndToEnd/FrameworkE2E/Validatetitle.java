package EndToEnd.FrameworkE2E;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjectFactory.Landingpage;
import resources.Base;

public class Validatetitle extends Base {
	public static Logger log=LogManager.getLogger(Base.class.getClass());
	@BeforeTest

	public void initialize() throws IOException {
		driver = initializeDriver();
		log.info("Driver is Initialized");
		driver.get(prop.getProperty("url"));
		log.info("Navigate to url");
	}

	@Test
	public void validateTitle() throws IOException {

		Landingpage l = new Landingpage(driver);
		Assert.assertEquals(l.getTitle().getText(), "FEATURED COURSES");
		log.info("Title is validated");
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}
