package stepdefinitions;

import ExtentReport.ExtentManager;
import base.TestBase;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

    public static ExtentReports extent;
    public static ExtentTest _scenario;

    @Before
    public void setUp(Scenario scenario) {
        if (TestBase.getDriver() == null) {
            TestBase.setUp();
        }
        // Initialize ExtentReports
        if (extent == null) {
            extent = ExtentManager.getInstance();
        }

        // Create a test in ExtentReports
        _scenario = extent.createTest(scenario.getName());
    }
    @After
    public void tearDown(Scenario scenario) {
        // Capture screenshot if scenario failed
        if (scenario.isFailed()) {
            String scenarioName = scenario.getName().replaceAll(" ", "_");
            String screenshotPath = TestBase.captureScreenshot(scenarioName);

            _scenario.fail(
                    "Test Failed",
                    MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build()
            );
        }

        // Close WebDriver
        TestBase.tearDown();

        // Flush ExtentReports
        extent.flush();
    }

}