package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class LoginPage  {
	@FindBy(id="username")
	private WebElement unTB;

	@FindBy(name="pwd")
	private WebElement pwTB;

	@FindBy(xpath="//div[.='Login ']")
	private WebElement loginBTN;

	@FindBy(xpath="//span[@class='errormsg']")
	private WebElement errorMsg;

	public LoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public void setUserName(String un) {
		unTB.sendKeys(un);
	}

	public void setPassword(String pw) {
		pwTB.sendKeys(pw);
	}

	public void clickLogin() {
		loginBTN.click();
	}

	public void verifyErrMsg(String eText) {
		String aText=errorMsg.getText();
		Assert.assertEquals(aText, eText);
	
	}

}
