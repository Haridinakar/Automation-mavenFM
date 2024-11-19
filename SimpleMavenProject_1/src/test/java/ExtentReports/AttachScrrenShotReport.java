package ExtentReports;

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

public class AttachScrrenShotReport {
	@Test
	public void screenShot() {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/");

		TakesScreenshot ts = (TakesScreenshot) driver;
		String screenshotAs = ts.getScreenshotAs(OutputType.BASE64);

		String Time = LocalDate.now().toString().replace(":", "-");
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/ExtentReport" + Time + ".html");
		ExtentReports ExeReport = new ExtentReports();
		ExeReport.attachReporter(spark);
		ExtentTest test = ExeReport.createTest("screenShot");
		test.log(Status.PASS, "ScreenShot Added into extent Report");
		test.addScreenCaptureFromBase64String(screenshotAs);
		ExeReport.flush();

	}

}
