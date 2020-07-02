package ru.volsu.qa.config;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Getter
@Configuration
@ComponentScan( basePackages = "ru.volsu" )
@PropertySource("classpath:config.properties")
public class AppConfig {

    @Value("${baseUrl}")
    private String baseUrl;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    @Value("${baseTimeout}")
    private int baseTimeout;

    public void setBaseTimeout(int baseTimeout) {
        this.baseTimeout = baseTimeout;
    }

    public int getBaseTimeout() {
        return baseTimeout;
    }

    @Bean(name = "webDriver")
    public WebDriver webDriver() {
        String path = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", path + "/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}