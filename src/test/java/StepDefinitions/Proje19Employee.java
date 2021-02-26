package StepDefinitions;
import Pages.PageEmployee;
import Pages.Base;
import Utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Proje19Employee extends Base {

    WebDriver driver = Driver.getDriver();
    PageEmployee employee=new PageEmployee();

    @Given("Navigate to {string}")
    public void navigateTo(String url) {
        driver.manage().window().maximize();
        driver.get(url);
    }

    @When("I login using username {word} and password {string}")
    public void iLoginUsingUsernameAndPassword(String username, String password)  {
        employee.enterUsername(username);
        employee.enterPassword(password);    }

    @Then("Click to the login button")
    public void clickToTheLoginButton() {
        clickOnElement(employee.loginbutton);
        clickOnElement(employee.cookie);
    }

    @Then("I sould login")
    public void iSouldLogin() {
        textToBePresent(employee.accountname,"D. Saurbekov");
        Assert.assertEquals(getTextOfElement(employee.accountname),"D. Saurbekov");
    }

    @And("I navigate to Employees menu")
    public void iNavigateToEmployeesMenu() {
        clickOnElement(employee.humanresmenu);
        clickOnElement(employee.employeemenu);
    }

    @And("I click plus button for creating new employee")
    public void iClickPlusButtonForCreatingNewEmployee() {
        clickOnElement(employee.firstplus);
    }

    @Given("I fill informatin First Name {string}, Last Name {string}, Employee ID {string}, Document Type {string} and Document Number {string}")
    public void iFillInformatinFirstNameLastNameEmployeeIDDocumentTypeAndDocumentNumber(String name, String lastname, String emplID, String docelement, String docnumber) {
      employee.fillInformation(name, lastname, emplID, docelement, docnumber);

    }

    @When("I click save button")
    public void iClickSaveButton() {
       clickOnElement(employee.save);
    }

    @Given("I update {string} , {string} , {string}, {string} , {string}")
    public void iUpdate(String firstname, String lastname, String employeeId, String docelement, String docnumber) {
        employee.fillInformation(firstname, lastname, employeeId, docelement, docnumber);
    }

    @When("I click delete button")
    public void iClickDeleteButton() {
       clickOnElement(employee.delete);
       clickOnElement(employee.submit);
    }

    @Then("I get {string} message")
    public void iGetMessage(String message) {
    employee.assertionMessageforEmployee(message);
}

}

