package org.example.user.utils;

import org.example.user.dto.APIUserRequestDTO;
import org.example.user.dto.APIUserResponseDTO;
import org.example.user.model.User;
import org.example.usergroup.dto.APIUserGroupRequestDTO;
import org.example.usergroup.model.UserGroup;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    public static User CreateUser(){
        return User.builder().
                email("test99@test.com").
                name("tester99").
                mobile("9999999999").
                build();

    }


    public static User CreateUser(String userName){
        return User.builder().
                email("test99@test.com").
                name(userName).
                mobile("9999999999").
                build();

    }


    public static List<User> createUserList(){
        List<User> userList = new ArrayList<>();
        return List.of(CreateUser("Coco"),CreateUser("Gillianca"),CreateUser("littleElge"));

    }

    public static APIUserResponseDTO CreateAPIUserResponseDTO (Integer id){
        return APIUserResponseDTO.builder()
                .userId(99)
                .email("test99@test.com")
                .name("tester99")
                .mobile("9999999999")
                .build();

    }

    public static APIUserRequestDTO CreateAPIUserRequestDTO (String name){
        return APIUserRequestDTO.builder()
                .email("test99@test.com")
                .name(name)
                .mobile("9999999999")
                .build();

    }

    public static APIUserGroupRequestDTO CreateAPIUserGroupRequestDTO (String title){
        return APIUserGroupRequestDTO.builder()
                .title(title)
                .build();
    }


    public static UserGroup CreateUserGroup(Integer id){
        return UserGroup.builder().
                userGroupId(id).
                title("premium").
                build();

    }

    public static UserGroup CreateUserGroup(Integer id, String title){
        return UserGroup.builder().
                userGroupId(id).
                title(title).
                build();

    }

    public static List<UserGroup> createUserGroupList(){
        List<UserGroup> userGroupList = new ArrayList<>();
        return List.of(CreateUserGroup(1,"premium"),CreateUserGroup(2,"economy"),CreateUserGroup(3,"discount"));

    }

}
