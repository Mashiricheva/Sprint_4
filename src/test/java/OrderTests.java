import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import page.objects.FactoryDriver;
import page.objects.OrderPaje;
import page.objects.RentPaje;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;


public class OrderTests {
    @Rule
    public FactoryDriver factoryDriver = new FactoryDriver();
    // Заказ самоката черного цвета через верхнюю кнопку

    @Test
    public void createOrderHeaderButtonBlackScooter() {
        WebDriver driver = factoryDriver.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPaje orderPaje = new OrderPaje(driver);
        orderPaje.enterOrderButtonHead();
        fillOrderForm(orderPaje, "Федор", "Рыжов", "Пушкина 10", "Сокольники", "88888888888");
        orderPaje.closeCookieBanner();
        orderPaje.clickNextButton();

        RentPaje rentPaje = new RentPaje(driver);
        fillRentForm(rentPaje, "26.06.2026", true, "Привезите в первой половине дня");
        rentPaje.clickOrderFinal();
        rentPaje.clickOrderFinish();
        // Тест должен падать в хроме
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        if (browserName.equals("chrome")) {
            fail("Не удалось оформить заказ! " +
                    "Кнопка подтверждения заказа не кликается. " +
                    "Заказ не может быть завершен в браузере Chrome.");
        } else {
            assertTrue("Окно успешного оформления заказа не появилось",
                    rentPaje.isWindowDisplayed());
        }

    }
    // Заказ самоката серого цвета через верхнюю кнопку
    @Test
    public void createOrderHeaderButtonGreyScooter() {
        WebDriver driver = factoryDriver.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPaje orderPaje = new OrderPaje(driver);
        orderPaje.enterOrderButtonHead();
        fillOrderForm(orderPaje, "Лиза", "Милова", "Колотушкина 5", "Лубянка", "78974848466");
        orderPaje.closeCookieBanner();
        orderPaje.clickNextButton();

        RentPaje rentPaje = new RentPaje(driver);
        fillRentForm(rentPaje, "30.06.2026", false, "Самокат нужен ночью");
        rentPaje.clickOrderFinal();
        rentPaje.clickOrderFinish();
        // Тест должен падать в хроме
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        if (browserName.equals("chrome")) {
            fail("Не удалось оформить заказ! " +
                    "Кнопка подтверждения заказа не кликается. " +
                    "Заказ не может быть завершен в браузере Chrome.");
        } else {
            assertTrue("Окно успешного оформления заказа не появилось",
                    rentPaje.isWindowDisplayed());
        }
    }
// Заказ самоката черного цвета через нижнюю кнопку
    @Test
    public void createOrderDownButtonBlackScooter() {
        WebDriver driver = factoryDriver.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPaje orderPaje = new OrderPaje(driver);
        orderPaje.enterOrderButtonDown();
        fillOrderForm(orderPaje, "Миша", "Рыжов", "Пушкина 19", "Рижская", "78974847777");
        orderPaje.closeCookieBanner();
        orderPaje.clickNextButton();

        RentPaje rentPaje = new RentPaje(driver);
        fillRentForm(rentPaje, "26.06.2026", true, "Захватите мороженое");
        rentPaje.clickOrderFinal();
        rentPaje.clickOrderFinish();
        // Тест должен падать в хроме
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        if (browserName.equals("chrome")) {
            fail("Не удалось оформить заказ! " +
                    "Кнопка подтверждения заказа не кликается. " +
                    "Заказ не может быть завершен в браузере Chrome.");
        } else {
            assertTrue("Окно успешного оформления заказа не появилось",
                    rentPaje.isWindowDisplayed());
        }
    }
    // Заказ самоката серого цвета через нижнюю кнопку
    @Test
    public void createOrderDownButtonGreyScooter() {
        WebDriver driver = factoryDriver.getDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        OrderPaje orderPaje = new OrderPaje(driver);
        orderPaje.enterOrderButtonDown();
        fillOrderForm(orderPaje, "Вика", "Миронова", "Поварская 19", "Рижская", "78974845689");
        orderPaje.closeCookieBanner();
        orderPaje.clickNextButton();

        RentPaje rentPaje = new RentPaje(driver);
        fillRentForm(rentPaje, "26.06.2026", false, "Используйте спф");
        rentPaje.clickOrderFinal();
        rentPaje.clickOrderFinish();
        // Тест должен падать в хроме
        String browserName = ((RemoteWebDriver) driver).getCapabilities().getBrowserName();
        if (browserName.equals("chrome")) {
            fail("Не удалось оформить заказ! " +
                    "Кнопка подтверждения заказа не кликается. " +
                    "Заказ не может быть завершен в браузере Chrome.");
        } else {
            assertTrue("Окно успешного оформления заказа не появилось",
                    rentPaje.isWindowDisplayed());
        }
    }
// Заполнение первой страницы формы заказа
    private void fillOrderForm(OrderPaje orderPaje, String name, String lastName,
                               String address, String metro, String phone) {
        orderPaje.setName(name);
        orderPaje.setLastName(lastName);
        orderPaje.setAdress(address);
        orderPaje.setStationMetro(metro);
        orderPaje.setPhoneNumber(phone);
    }
// Заполнение второй страницы формы заказа
    private void fillRentForm(RentPaje rentPaje, String date, boolean isBlackColor, String comment) {
        rentPaje.setWhenBringScooter(date);
        rentPaje.setRentalPeriod();
        if (isBlackColor) {
            rentPaje.clickColourScooterBlack();
        } else {
            rentPaje.clickColourScooterGrey();
        }
        rentPaje.setComment(comment);
    }
}



