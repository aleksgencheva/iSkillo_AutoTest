package iSkillo_pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ModifyProfilePage extends BasePage{

    @FindBy(xpath = "//i[@class='fas fa-user-edit ng-star-inserted']")
    WebElement modifyBtn;

    @FindBy(xpath = "//h4[text()='Modify Your Profile']")
    WebElement modifyPopUp;

    @FindBy(xpath = "//textarea[@class='form-control ng-pristine ng-valid ng-touched']")
    WebElement infoField;

    @FindBy(xpath = "//textarea[@formcontrolname='publicInfo']")
    WebElement infoText;

    @FindBy(xpath = "//button[@class='btn btn-primary']")
    WebElement saveBtn;

    public ModifyProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    //Navigate and click 'modify' button.
    public void clickModifyBtn(){
        clickElement(modifyBtn);
    }

    //Validate if to modify window is shown.
    public void modifyWindow(){
        Assert.assertEquals(modifyPopUp.getText(), "Modify Your Profile", "Incorrect text displayed or pop-op now shown");
    }

    //Delete previous added public info.
    public void deleteInfo(){
        infoText.clear();
    }

    //Insert new public text info.
    public void insertText(){
        infoText.sendKeys("Hello everyone!");
    }

    //Click 'save' button.
    public void clickSave(){
        clickElement(saveBtn);
    }
}
