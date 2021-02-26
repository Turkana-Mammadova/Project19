package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class PageEmployee extends Base {
    String created="Employee successfully created";
    String updated="Employee successfully updated";
    String deleted="Employee successfully deleted";
    public PageEmployee() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[data-placeholder=\"Username\"]")
    public   WebElement usernamE;

    @FindBy(css = "input[data-placeholder=\"Password\"]")
    public WebElement Password;

    @FindBy(css = "button[aria-label=\"LOGIN\"]")
    public WebElement loginbutton;

    @FindBy(css = ".group-items > :nth-child(5)")
    public  WebElement humanresmenu;

    @FindBy(css = ".group-items > :nth-child(5)>div>:nth-child(2) >a>span")
    public WebElement employeemenu;

    @FindBy(css = "a[aria-label=\"dismiss cookie message\"]")
    public WebElement cookie;

    @FindBy(css = "ms-text-field[formcontrolname='firstName']>input")
    public WebElement firstname;

    @FindBy(css = "ms-text-field[formcontrolname=\"lastName\"]>input")
    public WebElement lastname;

    @FindBy(css = "input[formcontrolname=\"employeeId\"]")
    public WebElement employeeID;

    @FindBy(css = "mat-card >div:nth-child(2)>:nth-child(1)")
    public WebElement doctype;

    @FindBy(css = "mat-option:nth-child(1)")
    public WebElement docelement1;

    @FindBy(css = "mat-option:nth-child(2)")
    public WebElement docelement2;

    @FindBy(css = "mat-option:nth-child(3)")
    public WebElement docelement3;

    @FindBy(css = "input[formcontrolname=\"documentNumber\"]")
    public WebElement docnumber;

    @FindBy(css = "ms-save-button > button")
    public WebElement save;

    @FindBy(css = "#toast-container")
    public WebElement popup;

    @FindBy(css = "button[type='submit']")
    public WebElement submit ;

    @FindBy(css = "ms-delete-button > button")
    public WebElement delete;

    @FindBy(css = "ms-table-toolbar ms-add-button")
    public WebElement firstplus;

    @FindBy(css = "span.username")
    public WebElement accountname;

    public void enterUsername(String username) { sendKeysToElement(usernamE, username); }
    public void enterPassword(String password){
        sendKeysToElement(Password, password);
    }

    public void fillInformation(String Name, String Lastname, String EmplID, String Docelement, String Docnumber){

    sendKeysToElement(firstname,Name);
    sendKeysToElement(lastname,Lastname);
    sendKeysToElement(employeeID,EmplID);
    clickOnElement(doctype);
    switch (Docelement) {
        case "Personal ID":       clickOnElement(docelement1);break;
        case "Passport":          clickOnElement(docelement2);break;
        case "Birth Certificate": clickOnElement(docelement3);break; }
    sendKeysToElement(docnumber, Docnumber);
}

    public void assertionMessageforEmployee (String message){
    switch (message) {
        case "created":
            textToBePresent(popup,created);
            Assert.assertEquals(textToBeString(popup,created), created);
            textToBeinvisible(popup);break;
        case "updated":
             textToBePresent(popup,updated);
             Assert.assertEquals(textToBeString(popup,updated), updated);
             textToBeinvisible(popup);break;
        case "deleted":
            textToBePresent(popup,deleted);
            Assert.assertEquals(textToBeString(popup,deleted), deleted);
            textToBeinvisible(popup);break;
    }
}

}
