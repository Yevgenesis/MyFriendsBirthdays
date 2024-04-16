package exchange.myfriendsbirthdays.dto;


import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FriendDTO {
    @NonNull @Size(min = 2, message = "First name mast be 2 symbols minimum")
    private String firstName;
    @NonNull @Size(min = 2, message = "Last name mast be 2 symbols minimum")
    private String lastName;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Past(message = "Birthday date mast be in past")
    private LocalDate birthDay;
}
