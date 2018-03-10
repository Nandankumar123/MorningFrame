package generic;
import java.util.concurrent.TimeUnit;

//declared as abstract class because it is incomplete without test method. 
//incomplete means it is not having test method
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class BaseTest implements IAutoConst {
	public WebDriver driver;
	static {
		System.setProperty(CHROME_KEY, CHROME_VALUE);
		System.setProperty(GECKO_KEY, GECKO_VALUE);
	}
	@BeforeMethod(alwaysRun=true)
	public void OpenApplication() {
	
		String appURL=AutoUtil.getProperty(CONFIG_PATH, "appURL");
		String sITO=AutoUtil.getProperty(CONFIG_PATH, "ITO");
		long ITO = Long.parseLong(sITO);
		driver=new ChromeDriver();
		driver.get(appURL); 
		driver.manage().timeouts().implicitlyWait(ITO, TimeUnit.SECONDS);
	}
	@AfterMethod (alwaysRun=true)
	public void closeApplication(ITestResult r) {
		String testName=r.getName();
		int status=r.getStatus();
		if(status==1) {
			Reporter.log(testName+ " is passed",true);
		}
		else {
			Reporter.log(testName+ " is failed",true);
			AutoUtil.getPhoto(driver, PHOTO_PATH, testName);
		}
		driver.quit();
	}	
}
