package exchange.myfriendsbirthdays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MyFriendsBirthdaysApplication {
/*
    Создайте приложение для хранения дней рождений Ваших друзей.
Приложение должно хранить имя (более одного символа) и фамилию (более одного символа) друга,
а также его дату рождения (любая дата из прошлого, включая сегодняшнюю).
Создайте метод для добавления записи о дне рождения, метод получения всех хранимых записей,
метод получения сегодняшних именинников и методы поиска (именинники по дате, дата по имени и фамилии).
Если при поиске данные не найдены, то должно быть брошено исключение,
а контроллер должен обработать исключение и дать ответ 404. Выполните валидацию данных при создании записи.
В ответ на невалидные данные должен быть дан ответ с кодом 400.
 */

    public static void main(String[] args) {
        SpringApplication.run(MyFriendsBirthdaysApplication.class, args);
    }

}
