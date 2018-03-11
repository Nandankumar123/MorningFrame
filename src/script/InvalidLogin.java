package script;

import org.testng.annotations.Test;

import generic.BaseTest;
import generic.Excel;
import page.LoginPage;

public class InvalidLogin extends BaseTest {
	@Test(priority=2,groups= {"login"})
	public void testInvalidLogin() throws InterruptedException {
		int rc=Excel.getRowCount(XL_PATH, "InvalidLogin");
		for(int i=1;i<=rc;i++) {
		String un=Excel.getValue(XL_PATH,"InvalidLogin",i,0);
		String pw=Excel.getValue(XL_PATH,"InvalidLogin",i,1);
		String expectedMSG=Excel.getValue(XL_PATH,"InvalidLogin",i,2);
		LoginPage l=new LoginPage(driver);
		//Enter invalid user name
		l.setUserName(un);
		//Enter invalid password
		l.setPassword(pw);
		//Click login
		l.clickLogin();
		Thread.sleep(1000);
		//Verify err msg
		l.verifyErrMsg(expectedMSG);
		Thread.sleep(2000);
		}
	}
}
