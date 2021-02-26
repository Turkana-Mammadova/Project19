package StepDefinitions;

import Pages.Base;
import Pages.PageEmployee;
import Pages.PageExam;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebElement;
import java.util.List;

public class Proje19Exam extends Base {

    PageExam exam = new PageExam();
    PageEmployee employee = new PageEmployee();

    @And("I navigate to Entrance Exam menu")
    public void iNavigateToEntranceExamMenu() {
        clickOnElement(exam.entrexamfirst);
        clickOnElement(exam.entrexamsetup);
        clickOnElement(exam.entrexamsecond);
    }

    @And("I click plus button for creating new Entrance Exam")
    public void iClickPlusButtonForCreatingNewEntranceExam() {
        clickOnElement(employee.firstplus);
    }


    @Then("I should get {string} message")
    public void iShouldGetMessage(String message) {
        exam.assertionMessageforExam(message);
    }

    @Given("I fill informatin {string} , {string}, {string}")
    public void iFillInformatin(String name, String academicperiod, String gradelevel) {
        clickOnElement(exam.secondplus);
        exam.fillInformationForExam(name, academicperiod, gradelevel);
    }

    @And("I click save button on exam")
    public void iClickSaveButtonOnExam() {
        clickOnElement(employee.save);
    }

    @Given("I update informatin {string} , {string}, {string}")
    public void iUpdateInformatin(String name, String academicperiod, String gradelevel) {
        exam.fillInformationForExam(name, academicperiod, gradelevel);
    }

    @Given("I navigate to Entrance Examinations menu")
    public void iNavigateToEntranceExaminationsMenu() {
        try {
            clickOnElement(exam.backarrow);
        } catch (Exception e) {
            System.out.println("We are already on Entrance Examinations menu ");
        }


    }

    @When("I delete informatin {string} , {string}, {string}")
    public void iDeleteInformatin(String name, String academicperiod, String gradelevel) throws InterruptedException {
//        waitFor(ExpectedConditions.elementToBeClickable(employee.firstplus), "Can`t move Examinations menu");
//        driver.manage().timeouts().implicitlyWait (5, TimeUnit.SECONDS);

        Thread.sleep(1500);
        List<WebElement> rows = exam.rowgroup;
        boolean found = false;
        for (WebElement row : rows) {
            if (row.getText().contains(name) && row.getText().contains(academicperiod)) {
                found = true;
                row.findElement(exam.delete).click();
            }
        }
        clickOnElement(employee.submit);
    }


}

