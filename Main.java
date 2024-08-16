package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;


public class Main {

    private WebDriver driver;

    Main() {
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Hello world!");
        System.setProperty("webdriver.chrome.driver", "/Users/madhumundhra/Downloads/chromedriver-mac-arm64/chromedriver");
        Main m = new Main();
        //m.keypressExample();
        //m.autocomplete();
        //m.scrollPage();
        //m.switchToWindow();
        //m.switchToAlert();
        //m.executeJavaScript();
        //m.dragndrop();
        //m.radioButton();
        //m.dropDown();
        m.finalProject();
    }

    public void keypressExample() {
        driver.get("https://formy-project.herokuapp.com/keypress");
        WebElement element = driver.findElement(By.id("name"));
        element.click();
        element.sendKeys("Madhu Mundhra");
        driver.findElement(By.id("button")).click();
        driver.quit();
    }

    public void autocomplete() {
        driver.get("https://formy-project.herokuapp.com/autocomplete");
        WebElement element = driver.findElement(By.id("autocomplete"));
        element.click();
        //WebElement savedAddress = driver.findElement();
    }

    public void scrollPage() {
        driver.get("https://formy-project.herokuapp.com/scroll");
        WebElement element = driver.findElement(By.id("name"));
        Actions actions = new Actions(driver);
        actions.moveToElement(element);
        element.sendKeys("Madhu Mundhra");
        WebElement elementDate = driver.findElement(By.id("date"));
        elementDate.sendKeys("10/10/2020");
        driver.quit();
    }

    public void switchToWindow() {
        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement element = driver.findElement(By.id("new-tab-button"));
        element.click();
        String originalWindow = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handles : windowHandles) {
            driver.switchTo().window(handles);
        }
        driver.switchTo().window(originalWindow);
        driver.quit();
    }

    public void switchToAlert() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/switch-window");
        WebElement element = driver.findElement(By.id("alert-button"));
        element.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();
        driver.quit();
    }

    public void executeJavaScript() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/modal");
        WebElement element = driver.findElement(By.id("modal-button"));
        element.click();
        Thread.sleep(1000);
        WebElement closeButton = driver.findElement(By.id("close-button"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", closeButton);
        driver.quit();
    }

    public void dragndrop() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/dragdrop");
        WebElement img = driver.findElement(By.id("image"));
        WebElement box = driver.findElement(By.id("box"));
        Actions actions = new Actions(driver);
        actions.dragAndDrop(img, box).perform();
        Thread.sleep(1000);
        driver.quit();
    }

    public void radioButton() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/radiobutton");
        WebElement radioButton1 = driver.findElement(By.id("radio-button-1"));
        WebElement radioButton2 = driver.findElement(By.cssSelector("input[value='option2']"));
        WebElement radioButton3 = driver.findElement(By.xpath("/html/body/div/div[3]/input"));
        radioButton3.click();
        Thread.sleep(1000);


        driver.quit();
    }

    public void dropDown() throws InterruptedException {
        driver.get("https://formy-project.herokuapp.com/dropdown");
        WebElement radioButton1 = driver.findElement(By.id("dropdownMenuButton"));
        radioButton1.click();
        WebElement dropdowncomplete = driver.findElement(By.id("autocomplete"));
        dropdowncomplete.click();
        Thread.sleep(1000);


        driver.quit();
    }


    public void finalProject() {
        try {
            // Open the webpage
            driver.get("https://formy-project.herokuapp.com/form");

            // Fill out the form
            WebElement firstName = driver.findElement(By.id("first-name"));
            firstName.sendKeys("John");

            WebElement lastName = driver.findElement(By.id("last-name"));
            lastName.sendKeys("Doe");

            WebElement jobTitle = driver.findElement(By.id("job-title"));
            jobTitle.sendKeys("QA Engineer");

            // Select the radio button for highest level of education (e.g., College)
            WebElement radioButton = driver.findElement(By.id("radio-button-2"));
            radioButton.click();

            // Select the checkbox for sex (e.g., Male)
            WebElement checkBox = driver.findElement(By.id("checkbox-1"));
            checkBox.click();

            // Select years of experience (e.g., 5-9 years) from the drop-down
            WebElement dropDownMenu = driver.findElement(By.id("select-menu"));
            dropDownMenu.click();
            WebElement dropDownOption = driver.findElement(By.xpath("//option[@value='2']"));
            dropDownOption.click();

            // Select the date
            WebElement datepicker = driver.findElement(By.id("datepicker"));
            datepicker.sendKeys("08/15/2024");
            datepicker.sendKeys("\n"); // Press Enter to close the datepicker

            // Submit the form
            WebElement submitButton = driver.findElement(By.xpath("//a[text()='Submit']"));
            submitButton.click();

            // Wait for the confirmation page to load
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement alert = wait.until(ExpectedConditions.presenceOfElementLocated(By.className("alert")));

            // Verify that the form was submitted successfully
            String successMessage = alert.getText();


            if (successMessage.contains("The form was successfully submitted!")) {
                System.out.println("Test Passed: Form submission was successful.");
            } else {
                System.out.println("Test Failed: Form submission was not successful.");
            }
        } finally {
            // Close the browser
            driver.quit();
        }
    }

}
