import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.model.TestClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.FactoryDriver;
import pageObjects.MainPaje;
import pageObjects.OrderPaje;
import pageObjects.RentPaje;

import java.time.Duration;

import static org.junit.Assert.assertTrue;

public class ScooterTests {

    @Rule
    public FactoryDriver factoryDriver = new FactoryDriver();

    @Test

    public void textQuestionsAboutImportant() {

        WebDriver driver = factoryDriver.getDriver();
        MainPaje mainPage = new MainPaje(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        mainPage.enterHowMuchItCost0();

        mainPage.enterHowMuchItCost();
        mainPage.textHowMushItCostAnswer();

        mainPage.enterWantSeveralScooters();
        mainPage.textWantSeveralScootersAnswer();

        mainPage.enterHowRentalTimeCalculated();
        mainPage.texHowRentalTimeCalculatedAnswer();

        mainPage.enterPossibleOrderScooterToday();
        mainPage.textPossibleOrderScooterTodayAnswer();

        mainPage.enterExtendOrderOrReturnEarlier();
        mainPage.textExtendOrderOrReturnEarlierAnswer();

        mainPage.enterBringChargerWithScooter();
        mainPage.textBringChargerWithScooterAnswer();

       mainPage.scrollToElement7();
        mainPage.enterCanCancelOrder();
        mainPage.textCanCancelOrderAnswer();

        mainPage.enterLiveOutsideMkadBring();
        mainPage.textLiveOutsideMkadBringAnswer();
        driver.quit();


    }
    @Test
    public void OrderScooterHeaderButton () {
        WebDriver driver = factoryDriver.getDriver();
        OrderPaje orderPaje = new OrderPaje(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        orderPaje.enterOrderButtonHead();
        orderPaje.setName("Федор");
        orderPaje.setLastName("Рыжов");
        orderPaje.setAdress("Пушкина 10");
        orderPaje.setStationMetro("Сокольники");
        orderPaje.setPhoneNumber("88888888888");
        orderPaje.closeCookieBanner();
        orderPaje.clickNextButton();

        RentPaje rentPaje = new RentPaje(driver);
        rentPaje.setWhenBringScooter("26.06.2026");
        rentPaje.setRentalPeriod();
        rentPaje.clickColourScooterBlack();
        rentPaje.setComment("Привезите в первой половине дня");
        rentPaje.clickOrderFinal();
        rentPaje.clickOrderFinish();
        assertTrue("Окно успешного оформления заказа не появилось", rentPaje.isWindowDisplayed());
        driver.quit();


    }


    @Test
    public void OrderScooterHeaderButton2 () {
        WebDriver driver = factoryDriver.getDriver();
        OrderPaje orderPaje = new OrderPaje(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        orderPaje.enterOrderButtonHead();
        orderPaje.setName("Лиза");
        orderPaje.setLastName("Милова");
        orderPaje.setAdress("Колотушкина 5");
        orderPaje.setStationMetro("Лубянка");
        orderPaje.setPhoneNumber("78974848466");
        orderPaje.closeCookieBanner();
        orderPaje.clickNextButton();

        RentPaje rentPaje = new RentPaje(driver);
        rentPaje.setWhenBringScooter("30.06.2026");
        rentPaje.setRentalPeriod();
        rentPaje.clickColourScooterGrey();
        rentPaje.setComment("Самокат нужен ночью");
        rentPaje.clickOrderFinal();
        rentPaje.clickOrderFinish();
        assertTrue("Окно успешного оформления заказа не появилось", rentPaje.isWindowDisplayed());
        driver.quit();
    }


    @Test
    public void OrderScooterDownButton () {
        WebDriver driver = factoryDriver.getDriver();
        OrderPaje orderPaje = new OrderPaje(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        orderPaje.enterOrderButtonDown();
        orderPaje.setName("Миша");
        orderPaje.setLastName("Рыжов");
        orderPaje.setAdress("Пушкина 19");
        orderPaje.setStationMetro("Рижская");
        orderPaje.setPhoneNumber("78974847777");
        orderPaje.closeCookieBanner();
        orderPaje.clickNextButton();


        RentPaje rentPaje = new RentPaje(driver);
        rentPaje.setWhenBringScooter("26.06.2026");
        rentPaje.setRentalPeriod();
        rentPaje.clickColourScooterBlack();
        rentPaje.setComment("Захватите мороженое");
        rentPaje.clickOrderFinal();
        rentPaje.clickOrderFinish();
        assertTrue("Окно успешного оформления заказа не появилось", rentPaje.isWindowDisplayed());
        driver.quit();
    }
    @Test
    public void OrderScooterDownButton2 () {
        WebDriver driver = factoryDriver.getDriver();
        OrderPaje orderPaje = new OrderPaje(driver);
        driver.get("https://qa-scooter.praktikum-services.ru/");
        orderPaje.enterOrderButtonDown();
        orderPaje.setName("Вика");
        orderPaje.setLastName("Миронова");
        orderPaje.setAdress("Поварская 19");
        orderPaje.setStationMetro("Рижская");
        orderPaje.setPhoneNumber("78974845689");
        orderPaje.closeCookieBanner();
        orderPaje.clickNextButton();


        RentPaje rentPaje = new RentPaje(driver);
        rentPaje.setWhenBringScooter("26.06.2026");
        rentPaje.setRentalPeriod();
        rentPaje.clickColourScooterGrey();
        rentPaje.setComment("Используйте спф");
        rentPaje.clickOrderFinal();
        rentPaje.clickOrderFinish();
        assertTrue("Окно успешного оформления заказа не появилось", rentPaje.isWindowDisplayed());
        driver.quit();
    }
    @Test
    //Проверяем загружается ли сайт
    public void checkPageLoad() {
        WebDriver driver = factoryDriver.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        System.out.println("URL: " + driver.getCurrentUrl());
        System.out.println("Title: " + driver.getTitle());
        System.out.println("Page source length: " + driver.getPageSource().length());

    }
}

