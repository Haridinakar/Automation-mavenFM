package ExtentReports;

import java.time.Duration;
import java.time.LocalDate;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class AmazonSSExtentreport {
	@Test
	public void amazon() {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.com/");

		TakesScreenshot ts = (TakesScreenshot) driver;
		String ScreenShot = ts.getScreenshotAs(OutputType.BASE64);

		String Time = LocalDate.now().toString().replace(":", "-");

		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/Amazon" + Time + ".html");
		ExtentReports exereport = new ExtentReports();
		exereport.attachReporter(spark);

		ExtentTest test = exereport.createTest("amazon");
		test.addScreenCaptureFromBase64String(ScreenShot);
		test.log(Status.PASS, "Amazon SS Capture");
		exereport.flush();
	}
}
