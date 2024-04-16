package exchange.myfriendsbirthdays.controller;

import exchange.myfriendsbirthdays.dto.FriendDTO;
import exchange.myfriendsbirthdays.mapper.FriendMapper;
import exchange.myfriendsbirthdays.model.entity.Friend;
import exchange.myfriendsbirthdays.service.FriendService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Past;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("api/friends")
public class FriendController {

    private final FriendService friendService;
    private final FriendMapper friendMapper;


    // Этот метод для тестового заполнения репозитория
    // проверку по полям в нём не делал
    @PostMapping("/addList")
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
            log.info(bindingResult.getAllErrors().toString());
        }
        Friend newFriend = friendMapper.dtoTofriend(friendDTO);
        return friendService.addFriend(newFriend);

    }

    @GetMapping("/filter/happyBirthday")
    public List<Friend> getFriendsTodaysBirthday() {
        return friendService.getFriendsTodaysBirthday();
    }

    @GetMapping("/filter/ByDate")
    public List<Friend> getFriendsByDate(
            @Valid
            @RequestParam
            @Past(message = "Date mast be in past")
            LocalDate date) {
        return friendService.getFriendsByDate(date);
    }

    @GetMapping("/filter/ByFullName")
    public List<Friend> getFriendsByFullName(@RequestParam String fullName) {

        return friendService.getFriendsByFullName(fullName);
    }
}
