package org.ui.oppenheimerqaassignment.tests;

import com.maxsoft.testngtestresultsanalyzer.TestAnalyzeReportListener;
import org.ui.oppenheimerqaassignment.common.PageProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.getDriver;
import static org.ui.oppenheimerqaassignment.util.DriverManager.spinUpDriver;

@Listeners(TestAnalyzeReportListener.class)
public class BaseTest {

    @BeforeMethod
    public void setUp() {
        spinUpDriver();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
    }

    public PageProvider pages() {
        return new PageProvider(getDriver());
    }

}