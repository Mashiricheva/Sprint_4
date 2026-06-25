package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainPaje {
    //Сколько это стоит? И как оплатить?
    private final By howMuchItCost = By.xpath("//*[@id='accordion__heading-0']");
    // Ответ при нажатии
    private final By howMuchItCostAnswer = By.id("accordion__panel-0");

    //Хочу сразу несколько самокатов! Так можно?
    private final By wantSeveralScooters = By.id("accordion__heading-1");
    // Ответ при нажатии
    private final By wantSeveralScootersAnswer = By.id("accordion__panel-1");

    // Как расчитывается время аренды?
    private final By howRentalTimeCalculated = By.id("accordion__heading-2");
    // Ответ при нажатии
    private final By howRentalTimeCalculatedAnswer = By.id("accordion__panel-2");

    // Можно ли заказать самокат прямо сегодня?
    private final By possibleOrderScooterToday = By.id("accordion__heading-3");
    // Ответ при нажатии
    private final By possibleOrderScooterTodayAnswer = By.id("accordion__panel-3");

    // Можно ли продлить заказ или вернуть самокат раньше?
    private final By extendOrderOrReturnEarlier = By.id("accordion__heading-4");
    // Ответ при нажатии
    private final By extendOrderOrReturnEarlierAnswer = By.id("accordion__panel-4");

    // Вы привозите зарядку вместе с самокатом?
    private final By bringChargerWithScooter = By.id("accordion__heading-5");
    // Ответ при нажатии
    private final By bringChargerWithScooterAnswer = By.id("accordion__panel-5");

    // Можно ли отменить заказ?
    private final By canCancelOrder = By.id("accordion__heading-6");
    // Ответ при нажатии
    private final By canCancelOrderAnswer = By.id("accordion__panel-6");

    // Я живу за МКАДом, привезете?
    private final By liveOutsideMkadBring = By.id("accordion__heading-7");
    // Ответ при нажатии
    private final By liveOutsideMkadBringAnswer = By.id("accordion__panel-7");

    private WebDriver driver;


    public MainPaje(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
    }

//Прокрутка до вопросов
    public void enterHowMuchItCost0() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Прокрутите до блока с вопросами
        WebElement accordionBlock = wait.until(
                ExpectedConditions.presenceOfElementLocated(By.className("accordion"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", accordionBlock);
    }

    public void enterHowMuchItCost () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accordion__heading-0")));
        wait.until(ExpectedConditions.elementToBeClickable(howMuchItCost));
        driver.findElement(howMuchItCost).click(); // Нажали на вопрос "Сколько это стоит? И как оплатить?"
    }
    public void textHowMushItCostAnswer () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(howMuchItCostAnswer));


        String actualHowMushItCostAnswer = driver.findElement(howMuchItCostAnswer).getText(); // Получили текст после нажатия на вопрос
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                actualHowMushItCostAnswer,
                "Сутки — 400 рублей. Оплата курьеру — наличными или картой."); // Сравнили текст
    }


    public void enterWantSeveralScooters () {
        driver.findElement(wantSeveralScooters).click(); // Нажали на вопрос "Хочу сразу несколько самокатов! Так можно?"
    }
    public void textWantSeveralScootersAnswer () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(wantSeveralScootersAnswer));
        String actualWantSeveralScootersAnswer = driver.findElement(wantSeveralScootersAnswer).getText(); // Получили текст после нажатия на вопрос
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                actualWantSeveralScootersAnswer,
                "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим."); // Сравнили текст
    }


    public void enterHowRentalTimeCalculated () {
        driver.findElement(howRentalTimeCalculated).click(); // Нажали на вопрос "Как расчитывается время аренды?"
    }
    public void texHowRentalTimeCalculatedAnswer () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(howRentalTimeCalculatedAnswer));
        String actualHowRentalTimeCalculatedAnswer = driver.findElement(howRentalTimeCalculatedAnswer).getText(); // Получили текст после нажатия на вопрос
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                actualHowRentalTimeCalculatedAnswer,
                "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30."); // Сравнили текст
    }


    public void enterPossibleOrderScooterToday () {
        driver.findElement(possibleOrderScooterToday).click(); // Нажали на вопрос "Можно ли заказать самокат прямо сегодня?"
    }
    public void textPossibleOrderScooterTodayAnswer () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(possibleOrderScooterTodayAnswer));
        String actualPossibleOrderScooterTodayAnswer = driver.findElement(possibleOrderScooterTodayAnswer).getText(); // Получили текст после нажатия на вопрос
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                actualPossibleOrderScooterTodayAnswer,
                "Только начиная с завтрашнего дня. Но скоро станем расторопнее."); // Сравнили текст
    }


    public void enterExtendOrderOrReturnEarlier () {
        driver.findElement(extendOrderOrReturnEarlier).click(); // Нажали на вопрос "Можно ли продлить заказ или вернуть самокат раньше?"
    }
    public void textExtendOrderOrReturnEarlierAnswer () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(extendOrderOrReturnEarlierAnswer));
        String actualExtendOrderOrReturnEarlierAnswer = driver.findElement(extendOrderOrReturnEarlierAnswer).getText(); // Получили текст после нажатия на вопрос
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                actualExtendOrderOrReturnEarlierAnswer,
                "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010."); // Сравнили текст
    }


    public void enterBringChargerWithScooter () {
        driver.findElement(bringChargerWithScooter).click(); // Нажали на вопрос "Вы привозите зарядку вместе с самокатом?"
    }
    public void textBringChargerWithScooterAnswer () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(bringChargerWithScooterAnswer));
        String actualBringChargerWithScooterAnswer = driver.findElement(bringChargerWithScooterAnswer).getText(); // Получили текст после нажатия на вопрос
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                actualBringChargerWithScooterAnswer,
                "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится."); // Сравнили текст
    }


    public void enterCanCancelOrder () {
        driver.findElement(canCancelOrder).click(); // Нажали на вопрос "Можно ли отменить заказ?"
    }
    //Прокручиваем
    public void scrollToElement7() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("accordion__heading-7")));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    public void textCanCancelOrderAnswer () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(canCancelOrderAnswer));
        String actualCanCancelOrderAnswer = driver.findElement(canCancelOrderAnswer).getText(); // Получили текст после нажатия на вопрос
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                actualCanCancelOrderAnswer,
                "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.");
    }


    public void enterLiveOutsideMkadBring () {
        driver.findElement(liveOutsideMkadBring).click(); // Нажали на вопрос "Я живу за МКАДом, привезете?"
    }
    public void textLiveOutsideMkadBringAnswer () {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(liveOutsideMkadBringAnswer));
        String actualLiveOutsideMkadBringAnswer = driver.findElement(liveOutsideMkadBringAnswer).getText();// Получили текст после нажатия на вопрос
        Assert.assertEquals("Текст элемента не совпадает с ожидаемым",
                actualLiveOutsideMkadBringAnswer,
                "Да, обязательно. Всем самокатов! И Москве, и Московской области.");

    }

}
