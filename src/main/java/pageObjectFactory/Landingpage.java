package pageObjectFactory;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Landingpage {
	public WebDriver driver;
 By login=By.cssSelector("a[href*='sign_in']");
 By title=By.cssSelector("div.text-center");
 public Landingpage(WebDriver driver) {
	// TODO Auto-generated constructor stub
	 this.driver=driver;
}
public WebElement getLogin() {
	 return driver.findElement(login);
 }
public WebElement getTitle() {
	 return driver.findElement(title);
}
}
