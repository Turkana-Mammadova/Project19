package Runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"src/main/resources/Features/proje19Exam.feature"},
        glue = {"StepDefinitions","Runners","Hook"},
        plugin = {"pretty", "html:target/report/index.html"}
)
public class EntranceExamTestsRunner extends AbstractTestNGCucumberTests {

}

