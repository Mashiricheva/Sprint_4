package page.objects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentPaje {
    //Поле Когда привезти самокат
    private final By whenBringScooter = By.xpath(".//div[@class='react-datepicker__input-container']/input");
    //Поле Срок аренды
    private final By rentalPeriod = By.className("Dropdown-placeholder");
    // Список даты аренды
    private final By rentalTime = By.xpath(".//div[@class='Dropdown-menu']/div[text()=\"трое суток\"]");
    //Поле цвет самоката
    private final By colourScooter = By.className("Order_Title__3EKne");
    // Цвет самоката черный жемчуг
    private final By checkBoxColourScooterBlack = By.xpath(".//input[@id='black']");
    //Цвет самоката Серая безисходность
    private final By checkBoxColourScooterGrey = By.xpath(".//input[@id='grey']");
    // Поле комментария
    private final By comment= By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка заказать
    private final By orderFinal= By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()=\"Заказать\"]");
    // Кнопка подтверждения заказа
    private final By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()=\"Да\"]");
    // Окно бронирования
    private final By orderFinish = By.className("Order_ModalHeader__3FDaJ");
    // Проверяем что окно появилось
    public boolean isWindowDisplayed () {
        return driver.findElement(orderFinish).isDisplayed();
    }



    private WebDriver driver;


    public RentPaje(WebDriver driver) {
        this.driver = driver;
    }
    //Вводим когда привезти самокат
    public  RentPaje setWhenBringScooter (String date) {
        driver.findElement(whenBringScooter).sendKeys(date);
        driver.findElement(whenBringScooter).sendKeys(Keys.ENTER);
        return this;

    }
    // Вводим срок аренды
    public RentPaje setRentalPeriod () {
        driver.findElement(rentalPeriod).click();
        driver.findElement(rentalTime).click();
        return this;
    }
    // Выбираем цвет черный жемчун
    public RentPaje clickColourScooterBlack() {
        driver.findElement(checkBoxColourScooterBlack).click();
        return this;
    }
    // Выбираем цвет серая безысходность
    public RentPaje clickColourScooterGrey () {
        driver.findElement(checkBoxColourScooterGrey).click();
        return this;
    }
    //Вводим комментарий
    public RentPaje setComment(String userComment) {
        driver.findElement(comment).sendKeys(userComment);
        return this;
    }
    // Нажимаем кнопку заказать
    public RentPaje clickOrderFinal(){
        driver.findElement(orderFinal).click();
        return this;
    }
    // Подтверждаем оформление заказа
    public RentPaje clickOrderFinish () {
        driver.findElement(orderFinish).click();
        return this;
    }

}
