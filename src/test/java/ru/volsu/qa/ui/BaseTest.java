package ru.volsu.qa.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.*;
import ru.volsu.qa.config.AppConfig;
import ru.volsu.qa.listeners.FailuresListener;

@Listeners({FailuresListener.class})
@ContextConfiguration( classes = AppConfig.class )
public class BaseTest extends AbstractTestNGSpringContextTests{

    @Autowired
    protected WebDriver webdriver;

    @Autowired
    private AppConfig config;

    @BeforeMethod
    public void openBaseUrl() {
        webdriver.get(config.getBaseUrl());
    }

    @AfterSuite
    public void closeBrowser(){}
}
//public class BaseTest extends AbstractTestNGSpringContextTests {
//
//    protected ChromeDriver webdriver;
//
//    @BeforeMethod
//    public void initBrowser() {
//        String path = System.getProperty("user.dir");
//        System.setProperty("webdriver.chrome.driver", path + "/resources/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--start-maximized");
//        webdriver = new ChromeDriver(options);
//
//        webdriver.get("http://automationpractice.com/");
//    }
//
//    @AfterMethod
//    public void closeBrowser(){
//        webdriver.quit();
//    }
//}
