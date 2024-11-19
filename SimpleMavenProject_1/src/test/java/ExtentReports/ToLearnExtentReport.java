package ExtentReports;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ToLearnExtentReport {
	@Test
	public void report() {
//		STEP 1:Create obj of ExtentSparkReporter
		ExtentSparkReporter spark = new ExtentSparkReporter("./HTML_Reports/ExtentReport.html");

//		STEP 2:Create obj of ExtentReports
		ExtentReports ExeReport = new ExtentReports();

//		STEP 3:Attach obj of ExtentSparkReporter to ExtentReports
		ExeReport.attachReporter(spark);

//		STEP 4 :Create obj of ExtentTest
		ExtentTest test = ExeReport.createTest("report");

//		STEP 5 :Call log() to provide Status and Log Message
		test.log(Status.PASS, "LogMessage extent into extent Report");

//		STEP 6 :Call Flush() to write message into report
		ExeReport.flush();
	}
}
