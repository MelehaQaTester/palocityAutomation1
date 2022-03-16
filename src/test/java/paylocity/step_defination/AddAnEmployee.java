package paylocity.step_defination;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import paylocity.pages.TestBase;
import paylocity.utlities.ConfigurationReader;
import paylocity.utlities.Driver;


public class AddAnEmployee {

    String name = "Bela";
    String lastName = "Garnet";
    String dependentNumber = "2";
    int returnDepender=0;
    double BenfitPay=0;
    double netpay = 0;

    @Given("User input their credentials")

    public void user_input_their_credentials()  {

        WebElement username = Driver.getDriver().findElement(By.xpath("//input[@id ='Username']"));
        username.sendKeys(ConfigurationReader.getProperty("username"));
        WebElement password =  Driver.getDriver().findElement(By.xpath("//input[@id ='Password']"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        WebElement clickLogin = Driver.getDriver().findElement(By.xpath("//button[@type='submit']"));
        clickLogin.click();

    }
    @When("User is on the Benefits Dashboard Page")
    public void user_is_on_the_benefits_dashboard_page() {
      //  new WebDriverWait(Driver.getDriver(),15).until(ExpectedConditions.titleIs("Employees - Paylocity Benefits Dashboard"));
        String actual = Driver.getDriver().getTitle();
        String expected = "Employees - Paylocity Benefits Dashboard";
        Assert.assertEquals("Sorry the Title of this page does not matches",actual,expected);
    }
    @Then("Select Add employee")
    public void select_add_employee() {
        WebElement addEmployee = Driver.getDriver().findElement(By.xpath("//button[@id = 'add']"));
        addEmployee.click();

    }
    @When("I can enter employees details")
    public void i_can_enter_employees_details() {
        WebElement addingTheFirstName = Driver.getDriver().findElement(By.xpath("//input[@id='firstName']"));
        addingTheFirstName.sendKeys(name);
        WebElement addingLastName = Driver.getDriver().findElement(By.xpath("//input[@id='lastName']"));
        addingLastName.sendKeys(lastName);
        WebElement dependent = Driver.getDriver().findElement(By.xpath("//input[@id='dependants']"));
        dependent.sendKeys(dependentNumber);
    }
    @When("The employee detail should be saved")
    public void the_employee_detail_should_be_saved() {
        WebElement addEmployeeButton = Driver.getDriver().findElement(By.xpath("//button[@id='addEmployee']"));
        addEmployeeButton.click();
    }
    @When("I should see the employee in the table")
    public void i_should_see_the_employee_in_the_table() {
        WebElement lastname= Driver.getDriver().findElement(By.xpath("//table[@class='table table-striped']/tbody//tr/td[2]"));
        WebElement firstanme=  Driver.getDriver().findElement(By.xpath("//table[@class='table table-striped']/tbody//tr/td[3]"));
        returnDepender = Integer.parseInt(Driver.getDriver().findElement(By.xpath("//table[@class='table table-striped']/tbody//tr/td[4]")).getText());
        BenfitPay = Double.parseDouble(Driver.getDriver().findElement(By.xpath("//table[@class='table table-striped']/tbody//tr/td[7]")).getText());
        netpay = Double.parseDouble(Driver.getDriver().findElement(By.xpath("//table[@class='table table-striped']/tbody//tr/td[8]")).getText());
    }
    @When("the Benefit cost calculation")
    public void the_benefit_cost_calculation() {
        double net = TestBase.Calcultaion( returnDepender).netPay;
        double benfit = TestBase.Calcultaion(returnDepender).BenifitCost;
        Assert.assertEquals((int)net,(int) netpay);
        Assert.assertEquals((int)benfit,(int)BenfitPay);


        WebElement delted = Driver.getDriver().findElement(By.xpath("//table[@class='table table-striped']/tbody//tr//td[9]//i[2]"));
        delted.click();
        WebElement clickTheDeleted = Driver.getDriver().findElement(By.xpath("//button[@id = 'deleteEmployee']"));
        clickTheDeleted.click();


    }
}
