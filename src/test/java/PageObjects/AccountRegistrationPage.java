package PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {
	public AccountRegistrationPage(WebDriver driver) {
        super(driver);

    }
    @FindBy(xpath="//input[@id='input-firstname']")
    WebElement textFirstname;

    @FindBy(xpath="//input[@id='input-lastname']")
    WebElement textLastname;

    @FindBy(xpath="//input[@id='input-email']")
    WebElement textEmail;

    @FindBy(xpath="//input[@id='input-telephone']")
    WebElement textTelephone;

    @FindBy(xpath="//input[@id='input-password']")
    WebElement textPassword;

    @FindBy(xpath="//input[@id='input-confirm']")
    WebElement textConfirmPassword;

    @FindBy(xpath="//input[@name='agree']")
    WebElement chkPolicy;

    @FindBy(xpath="//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConformation;

    public void setFirstName(String fName) {
        textFirstname.sendKeys(fName);
    }
    public void setLastName(String lName) {
        textLastname.sendKeys(lName);
    }
    public void setEmail(String email) {
        textEmail.sendKeys(email);
    }
    public void setTelephone(String telephone) {
        textTelephone.sendKeys(telephone);

    }
    public void setPassword(String password) {
        textPassword.sendKeys(password);
    }
    public void setConfirmPassword(String password) {
        textConfirmPassword.sendKeys(password);
    }
    public void setPrivacyPolicy() {
        chkPolicy.click();
    }
    public void clickContinue() {
        btnContinue.click();
    }
    public String getMsgConformation() {
        try {
            return (msgConformation.getText());
        }catch (Exception e){
            return (e.getMessage());
        }
    }
}
	
