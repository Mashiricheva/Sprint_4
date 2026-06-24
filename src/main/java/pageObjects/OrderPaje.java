package pageObjects;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.model.TestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderPaje {
    // Кнопка заказа вверху
    private final By orderButtonHead = By.xpath(".//div[@class='Header_Nav__AGCXC']/button[@class='Button_Button__ra12g']");
    // Кнопка заказать внизу
    private final By orderButtonDown = By.xpath(".//div[@class='Home_FinishButton__1_cWm']/button[@class='Button_Button__ra12g Button_Middle__1CSJM']");
    //Поле Имя
    private final  By name = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Имя']");
    //Поле Фамилия
    private final By lastName =By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Фамилия']");
    //Поле Адресс
    private final By adress = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле Станция метро
    private final By stationMetro = By.xpath(".//div[@class='select-search__value']/input[@placeholder='* Станция метро']");
    // Поле Номер телефона
    private final By phoneNumder = By.xpath(".//div[@class='Input_InputContainer__3NykH']/input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка далее
    private final By nextButton = By.className("Button_Button__ra12g Button_Middle__1CSJM");


    private WebDriver driver;


    public OrderPaje(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

    //Нажимаем на верхнюю кнопку заказать
    public void enterOrderButtonHead () {
        driver.findElement(orderButtonHead).click();
    }
    // Нажимаем на нижнюю кноаку заказать
    public void enterOrderButtonDown () {
        driver.findElement(orderButtonDown).click();
    }
    // Вводм имя
    public OrderPaje setName (String userName) {
        driver.findElement(name).sendKeys(userName);
        return this;
    }
    //Вводим фамилию
    public OrderPaje setLastName(String userLastName) {
        driver.findElement(lastName).sendKeys(userLastName); //
        return this;
    }
    //Вводим адресс
    public OrderPaje setAdress (String userAdress ){
        driver.findElement(adress).sendKeys(userAdress);
        return this;
    }
    //Вводим станцию метро
    public OrderPaje setStationMetro (String userStationMetro) {
        driver.findElement(stationMetro).click();
        driver.findElement(stationMetro).sendKeys(userStationMetro);
        driver.findElement(stationMetro).sendKeys(Keys.DOWN, Keys.ENTER);
        return this;
    }
    //Вводим номер телефона
    public OrderPaje setPhoneNumber (String userPhoneNumber) {
        driver.findElement(phoneNumder).sendKeys(userPhoneNumber);
        return this;
    }
    // Нажимаем на кнопку Далее
    public OrderPaje clickNextButton () {
        driver.findElement(nextButton).click();
        return this;
    }
}
