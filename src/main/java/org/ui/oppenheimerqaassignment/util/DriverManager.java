package org.ui.oppenheimerqaassignment.util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.getDriver;
import static com.maxsoft.testngtestresultsanalyzer.DriverHolder.setDriver;

public class DriverManager {
    public static void spinUpDriver() {
        WebDriverManager.chromedriver().setup();
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_setting_values.notifications", 2);
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);

        setDriver(new ChromeDriver(new ChromeOptions()
                .setExperimentalOption("prefs", prefs)
                .addArguments("start-maximized")
                .addArguments("disable-infobars")
                .addArguments("--disable-extensions")
                .addArguments("--disable-notifications")
                .addArguments("--remote-allow-origins=*")));

        getDriver().manage().window().maximize();
        getDriver().get("http://localhost:8080/");
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

}
