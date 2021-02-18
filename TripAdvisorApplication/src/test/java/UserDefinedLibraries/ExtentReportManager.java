package UserDefinedLibraries;

/* Class  : Extent Report
 * Author : Aishwariya
 * Date   : 24-04-2020
 * ID     : 851297
 */

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentReportManager {

	public static ExtentReports report;

	public static ExtentReports getReportInstance() {

		if (report == null) {

			// currentTimeMillis() to prevent overwriting of reports for pass and fail
			String reportName = System.currentTimeMillis() + ".html";
			ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./reports/extent" + reportName);
			report = new ExtentReports();
			report.attachReporter(htmlReporter);
		}

		return report;
	}

}