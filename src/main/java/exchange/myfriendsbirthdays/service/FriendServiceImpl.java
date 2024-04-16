package exchange.myfriendsbirthdays.service;

import exchange.myfriendsbirthdays.dto.FriendDTO;
import exchange.myfriendsbirthdays.model.entity.Friend;
//import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
@RequiredArgsConstructor
@Service
public class FriendServiceImpl implements FriendService {


    private final List<Friend> friends;


    public List<Friend> addListFriend(List<Friend> friendList) {
        for (Friend friend : friendList) {
            addFriend(friend);
        }
        return friends;
    }


    @Override
    public Friend addFriend( Friend friend) {
        friends.add(friend);
        return friend;
    }

    @Override
    public List<Friend> getAllFriends() {
        return friends;
    }

    @Override
    public List<Friend> getFriendsTodaysBirthday() {
        List<Friend> todayFriends = friends.stream()
                .filter(this::isBirthdayToday).toList();
        System.out.println(todayFriends);
        return todayFriends;
    }

    @Override
    public List<Friend> getFriendsByDate(LocalDate date) {
        List<Friend> todayFriends = friends.stream()
                .filter(friend -> friend.getBirthDay().equals(date)).toList();
        System.out.println(todayFriends);
        return todayFriends;
    }

    @Override
    public List<Friend> getFriendsByFullName(String fullName) {
        String[] splitName = fullName.split(" ");
        String firstName = splitName[0];
        String lastName = splitName[1];
        List<Friend> todayFriends = friends.stream()
                .filter(friend -> isEqualsFullName(friend, firstName,lastName)).toList();
        System.out.println(todayFriends);
        return todayFriends;
    }

    private boolean isEqualsFullName(Friend friend, String firstName, String lastName) {
        return friend.getFirstName().equals(firstName) && friend.getLastName().equals(lastName);
    }


    private boolean isBirthdayToday(Friend friend) {
        LocalDate today = LocalDate.now();
        int currentDay = today.getDayOfMonth();
        int currentMonth = today.getMonth().getValue();

        int friendDay = friend.getBirthDay().getDayOfMonth();
        int friendMonth = friend.getBirthDay().getMonth().getValue();

        return friendDay == currentDay && friendMonth == currentMonth;
    }
}
