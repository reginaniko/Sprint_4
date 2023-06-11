package ApplicationTests;

import Base.BaseTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class CreateOrderTest extends BaseTest {
    private final String firstName;
    private final String lastName;
    private final String address;
    private final String stationName;
    private final String phoneNumber;
    private final String date;
    private final String duration;
    private final String color;
    private final String comment;

    public CreateOrderTest(String firstName, String lastName, String address, String stationName, String phoneNumber, String date, String duration, String color, String comment){
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.stationName = stationName;
        this.phoneNumber = phoneNumber;
        this.date = date;
        this.duration = duration;
        this.color = color;
        this.comment = comment;
    }

    @Parameterized.Parameters
    public static Object[][] getTestData(){
        return new Object[][]{
                {"Анна", "Попова", "Строителей 35", "Киевская", "+79112223344", "Сегодня", "сутки", "grey", "Привет, курьер!"},
                {"Имануил", "Кант", "Кенигсберг 123", "Театральная", "+78115434455", "Завтра", "двое суток", "black", "Характер — это способность, действовать согласно принципам."},
        };
    }

    //заполнить необходимые поля и оформить заказ
    @Test
    public void createOrderPositiveFlow() {
        objOrderPage.makeOrder(firstName, lastName, address, stationName, phoneNumber, date, duration, color, comment);
    }
}
