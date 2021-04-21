package pageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Loginpage {
	public WebDriver driver;
	By email=By.id("user_email");
	By pw=By.xpath("//*[@type='password']");
	By login=By.cssSelector("[type='submit']");
	public Loginpage(WebDriver driver) {
		this.driver=driver;
	}
	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPassword() {
		return driver.findElement(pw);
	}
	public WebElement getLogin() {
		return driver.findElement(login);
	}

}
