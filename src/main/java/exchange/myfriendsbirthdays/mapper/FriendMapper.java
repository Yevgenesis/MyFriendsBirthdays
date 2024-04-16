package exchange.myfriendsbirthdays.mapper;

import exchange.myfriendsbirthdays.dto.FriendDTO;
import exchange.myfriendsbirthdays.model.entity.Friend;
import org.springframework.stereotype.Service;



@Service
public class FriendMapper {

    public Friend dtoTofriend(FriendDTO friendDTO) {
        return new Friend(friendDTO.getFirstName(),
                friendDTO.getLastName(),
                friendDTO.getBirthDay());
    }
}
