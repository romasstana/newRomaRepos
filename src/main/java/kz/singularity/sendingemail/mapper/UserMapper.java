package kz.singularity.sendingemail.mapper;

import kz.singularity.sendingemail.entity.Users;
import kz.singularity.sendingemail.payload.RequestDto;
import kz.singularity.sendingemail.payload.UserDetailsDto;

public class UserMapper {

    public static Users mapToUser(Users user, RequestDto requestDto){
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        return user;
    }

    public static UserDetailsDto mapToUserDetails(UserDetailsDto userDetailsDto, Users user){
        userDetailsDto.setFirstName(user.getFirstName());
        userDetailsDto.setLastName(user.getLastName());
        userDetailsDto.setEmail(user.getEmail());
        return userDetailsDto;
    }
}
