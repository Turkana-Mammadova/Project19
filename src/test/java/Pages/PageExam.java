package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class PageExam extends Base {
    public By delete=  By.cssSelector("ms-delete-button > button");
    String created = "Exam successfully created";
    String updated = "Exam successfully updated";
    String deleted = "Exam successfully deleted";

    public PageExam() {
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".group-items > :nth-child(3)")
    public WebElement entrexamfirst;

    @FindBy(css = ".group-items > :nth-child(3)>div>:nth-child(1) >a>span")
    public WebElement entrexamsetup;

    @FindBy(css = ".group-items > :nth-child(3)>div>:nth-child(1) >div>:nth-child(1)  span")
    public WebElement entrexamsecond;

    @FindBy(css = "[formgroupname='academicPeriod'] .mat-select-value")
    public WebElement academicperiod;

    @FindBy(css = "mat-option:nth-child(1)")
    public WebElement year19_20;

    @FindBy(css = "mat-option:nth-child(2)")
    public WebElement year18_19;

    @FindBy(css = "[formgroupname='gradeLevel'] .mat-select-value")
    public WebElement gradelevel;

    @FindBy(css = "mat-option:nth-child(21)")
    public WebElement grade6th;

    @FindBy(css = "mat-option:nth-child(2)")
    public WebElement gradebasqar;

    @FindBy(css = "mat-option:nth-child(27)")
    public WebElement grade10th;

    @FindBy(css = "mat-option:nth-child(3)")
    public WebElement gradetechno1;

    @FindBy(css = "ms-button[icon='plus']>button")
    public WebElement secondplus;

    @FindBy(css = "tbody[role='rowgroup'] tr")
    public List<WebElement> rowgroup;

    @FindBy(css = "div.px-16.px-mat-8 > button  svg")
    public WebElement backarrow;

    @FindBy(css = "input[type='text']")
    public WebElement examname;

    @FindBy(css = "#toast-container")
    public WebElement popup;


    public void assertionMessageforExam(String message) {
        switch (message) {
            case "created":
                textToBePresent(popup, created);
                Assert.assertEquals(textToBeString(popup, created), created);
                textToBeinvisible(popup);
                break;
            case "updated":
                textToBePresent(popup, updated);
                Assert.assertEquals(textToBeString(popup, updated), updated);
                textToBeinvisible(popup);
                break;
            case "deleted":
                textToBePresent(popup, deleted);
                Assert.assertEquals(textToBeString(popup, deleted), deleted);
                textToBeinvisible(popup);
                break;
        }
    }

    public void fillInformationForExam(String nameupdate, String academicperiodupdate, String gradelevelupdate){
        sendKeysToElement(examname,nameupdate);
        clickOnElement(academicperiod);
        switch (academicperiodupdate) {
            case "2018-2019": clickOnElement(year18_19); break;
            case "2019-2020": clickOnElement(year19_20); break;
        }
        clickOnElement(gradelevel);
        waitFor(ExpectedConditions.visibilityOf(gradetechno1));
        switch (gradelevelupdate) {
            case "BasqarTeam":clickOnElement(gradebasqar); break;
            case "Techno1":clickOnElement(gradetechno1);   break;
            case "6th grade":clickOnElement(grade6th);  break;
            case "10th grade":clickOnElement(grade10th);  break;
        }
    }
}
