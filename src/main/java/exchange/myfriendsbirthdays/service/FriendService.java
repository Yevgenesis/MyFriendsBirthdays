package exchange.myfriendsbirthdays.service;

import exchange.myfriendsbirthdays.dto.FriendDTO;
import exchange.myfriendsbirthdays.model.entity.Friend;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

public interface FriendService {

    public Friend addFriend(Friend friend);

    public List<Friend> addListFriend(List<Friend> friendList);

    public List<Friend> getAllFriends();

    public List<Friend> getFriendsTodaysBirthday();

    public List<Friend> getFriendsByDate(LocalDate date);

    public List<Friend> getFriendsByFullName(String fullName);

}
