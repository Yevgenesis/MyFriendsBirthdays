package exchange.myfriendsbirthdays.model.entity;


import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
@Data
public class Friend {
    private static long counter = 0;
    private long id;
    private String firstName;
    private String lastName;
    private LocalDate birthDay;

    public Friend(String firstName, String lastName, LocalDate birthDay) {
        this.id = ++counter;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDay = birthDay;
    }
}
