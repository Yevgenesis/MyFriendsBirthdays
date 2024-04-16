package exchange.myfriendsbirthdays;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {



        List<Test> tests = new ArrayList<>();

        TestDTO testDTO = new TestDTO();
        testDTO.date = "20-12-1980";
        testDTO.name = "Misha";
//        String pattern = "dd-MM-yyyy";
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
//        LocalDate date = LocalDate.parse(testDTO.date, formatter);
//        Test test = new Test(testDTO.name,date);
//        tests.add(test);
        System.out.println(tests);
    }
}

@Data
@AllArgsConstructor
class Test{
    String name;
    LocalDate date;
}

class TestDTO{
    String name;
    String date;
}

