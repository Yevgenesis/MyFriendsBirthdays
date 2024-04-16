package exchange.myfriendsbirthdays.controller;

import exchange.myfriendsbirthdays.dto.FriendDTO;
import exchange.myfriendsbirthdays.mapper.FriendMapper;
import exchange.myfriendsbirthdays.model.entity.Friend;
import exchange.myfriendsbirthdays.service.FriendService;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Valid;
import jakarta.validation.ValidationException;
import jakarta.websocket.server.PathParam;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

@Validated
@RequiredArgsConstructor
@RestController
public class FriendController {

    private final FriendService friendService;
    private final FriendMapper friendMapper;


    // Метод для тестового заполнения репозитория

    @PostMapping("/addFriends")
    public List<Friend> addListFriend(@RequestBody List<Friend> friendList) {
        return friendService.addListFriend(friendList);
    }

    @GetMapping
    public List<Friend> getAllFriends() {
        return friendService.getAllFriends();

    }

    @PostMapping
    public Friend createFriend(@RequestBody @Valid FriendDTO friendDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println(bindingResult.getAllErrors());
        }
        Friend newFriend = friendMapper.dtoTofriend(friendDTO);
        return friendService.addFriend(newFriend);

    }

    @GetMapping("/getTodaysBirthdayFriend")
    public List<Friend> getFriendsTodaysBirthday() {
        return friendService.getFriendsTodaysBirthday();
    }

    @GetMapping("/{date}")
    public List<Friend> getFriendsTodaysBirthday(@PathVariable LocalDate date) {
        return friendService.getFriendsByDate(date);
    }

    @GetMapping("/friend")
    public List<Friend> getFriendsByFullName(@RequestParam(name = "fullName") String fullName) {

        return friendService.getFriendsByFullName(fullName);
    }
}
