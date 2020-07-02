package ru.volsu.qa.ui.pageobject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Component;
import ru.volsu.qa.models.Account;

@Component
public class AccountCreationForm extends BasePage {

    private static final Logger log = LogManager.getLogger(AccountCreationForm.class);

    private final By formContainer = By.id("account-creation_form");

    private final By errorMessage = By.cssSelector(".alert.alert-danger");

    public boolean isFormDisplayed() {
        this.waitForElementDisplayed(formContainer);
        return true;
    }

    public String getErrorMessage() {
        this.waitForElementDisplayed( errorMessage );
        return webDriver.findElement( errorMessage ).getText();
    }

    private By genderManInput = By.id("id_gender1");
    private By genderWomanInput = By.id("id_gender2");
    private By customFirstnameInput = By.id("customer_firstname");
    private By customLastnameInput = By.id("customer_lastname");
    private By passwordInput = By.id("passwd");
    private By daysSelect = By.id("days");
    private By monthsSelect = By.id("months");
    private By yearsSelect = By.id("years");
    private By address1Input = By.id("address1");
    private By cityInput = By.id("city");
    private By stateSelect = By.id("id_state");
    private By postCodeInput = By.id("postcode");
    private By countySelect = By.id("id_country");
    private By phoneMobilInput = By.id("phone_mobile");
    private By registerButton = By.id("submitAccount");

    public void fillForm(Account account) {
        this.waitForElementDisplayed( formContainer );

        webDriver.findElement( genderManInput ).click();

        webDriver.findElement( customFirstnameInput ).sendKeys( account.getFirstName() );

        webDriver.findElement( customLastnameInput ).sendKeys( account.getLastName());

        webDriver.findElement( passwordInput ).sendKeys( account.getPassword());

        Select select = new Select(webDriver.findElement( daysSelect ));
        select.selectByValue(account.getDayBirth());

        select = new Select(webDriver.findElement( monthsSelect ));
        select.selectByValue(account.getMonthBirth());

        select = new Select(webDriver.findElement( yearsSelect ));
        select.selectByValue(account.getYearBirth());

        webDriver.findElement( address1Input ).sendKeys( account.getAddress());

        webDriver.findElement( cityInput ).sendKeys( account.getCity());

        select = new Select(webDriver.findElement( stateSelect ));
        select.selectByVisibleText(account.getState());

        webDriver.findElement( postCodeInput ).sendKeys( account.getZip());

        webDriver.findElement( phoneMobilInput ).sendKeys( account.getPhone());

        webDriver.findElement( registerButton ).click();

    }
}

//@Component
//public class AccountCreationForm extends BasePage {
//
//    private By formContainer = By.id("account-creation_form");
//
//    public AccountCreationForm(WebDriver webDriver) {
//        super( webDriver );
//    }
//
//    public boolean isFormDisplayed() {
//        this.waitForElementDisplayed(formContainer);
//        return true;
//    }
//
//    private By errorMessage = By.cssSelector(".alert.alert-danger");
//
//    public String getErrorMessage() {
//        this.waitForElementDisplayed( errorMessage );
//        return webDriver.findElement( errorMessage ).getText();
//    }
//
//    private By genderManInput = By.id("id_gender1");
//    private By genderWomanInput = By.id("id_gender2");
//    private By customFirstnameInput = By.id("customer_firstname");
//    private By customLastnameInput = By.id("customer_lastname");
//    private By passwordInput = By.id("passwd");
//    private By daysSelect = By.id("days");
//    private By monthsSelect = By.id("months");
//    private By yearsSelect = By.id("years");
//    private By address1Input = By.id("address1");
//    private By cityInput = By.id("city");
//    private By stateSelect = By.id("id_state");
//    private By postCodeInput = By.id("postcode");
//    private By countySelect = By.id("id_country");
//    private By phoneMobilInput = By.id("phone_mobile");
//    private By registerButton = By.id("submitAccount");
//
//    public void fillForm(Account account) {
//        this.waitForElementDisplayed( formContainer );
//
//        webDriver.findElement( genderManInput ).click();
//
//        webDriver.findElement( customFirstnameInput ).sendKeys( account.getFirstName() );
//
//        webDriver.findElement( customLastnameInput ).sendKeys( account.getLastName());
//
//        webDriver.findElement( passwordInput ).sendKeys( account.getPassword());
//
//        Select select = new Select(webDriver.findElement( daysSelect ));
//        select.selectByValue(account.getDayBirth());
//
//        select = new Select(webDriver.findElement( monthsSelect ));
//        select.selectByValue(account.getMonthBirth());
//
//        select = new Select(webDriver.findElement( yearsSelect ));
//        select.selectByValue(account.getYearBirth());
//
//        webDriver.findElement( address1Input ).sendKeys( account.getAddress());
//
//        webDriver.findElement( cityInput ).sendKeys( account.getCity());
//
//        select = new Select(webDriver.findElement( stateSelect ));
//        select.selectByVisibleText(account.getState());
//
//        webDriver.findElement( postCodeInput ).sendKeys( account.getZip());
//
//        webDriver.findElement( phoneMobilInput ).sendKeys( account.getPhone());
//
//        webDriver.findElement( registerButton ).click();
//
//    }
//}
