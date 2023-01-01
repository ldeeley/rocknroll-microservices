package org.example.user.repository;

import org.example.user.BaseTestContainer;
import org.example.user.model.User;
import org.example.user.service.BannedUsersClient;
import org.example.user.service.UserServiceImpl;
import org.example.user.utils.Utils;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

//@DataJpaTest
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class UserRepositoryTest  extends BaseTestContainer {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BannedUsersClient bannedUsersClient;

    @Autowired
    private ModelMapper modelMapper;

    @Test
    @DisplayName("Save a User to the database")
    void saveNewUserToDatabase(){

        User testUser = Utils.CreateUser("testUser");
        User savedUser = userRepository.save(testUser);
        assertThat(savedUser).usingRecursiveComparison().ignoringFields("userId").isEqualTo(testUser);

    }

//    @Test
//    void saveNewUserViaServiceLayer(){
//
//        APIUserRequestDTO testUser = Utils.CreateAPIUserRequestDTO("Coco");
//        userService.createUser(testUser);
//        assert(userRepository.findByNameContaining("Coco").;
//
//
//
//    }

//    @Test
//    void testAddUserGroupToUser(){
//        UserGroup premium = new UserGroup(1,"Premium",new HashSet<>());
//        userGroupRepository.saveAll(List.of(premium));
//        User testUser = User.builder()
//                .name("Cocobopper")
//                .mobile("07809886999")
//                .email("jessie@email.com")
//                .userGroupSet(new HashSet<>())
//                .build();
//        userRepository.save(testUser);
//
//        UserGroup userGroup = userGroupRepository.findById(1).get();
//        testUser.addUserGroup(userGroup);
//        User savedUser = userRepository.save(testUser);
//        System.out.println(savedUser);
//        assertThat(testUser.getUserGroupSet()).hasSize(1);
//
//    }

//    @Test
//    void testAddUserGroupsToExistingUser(){
////        User testUser = User.builder()
////                .userId(1)
////                .name("Cocobopper")
////                .mobile("07809886999")
////                .email("jessie@email.com")
////                .userGroupSet(new HashSet<>())
////                .build();
////        userRepository.save(testUser);
////        UserGroup premium = new UserGroup(1,"Premium",new HashSet<>());
//        User testUser = userRepository.findById(1).get();
////        userGroupRepository.saveAll(List.of(premium));
//        UserGroup userGroup = userGroupRepository.findById(1).get();
//        testUser.addUserGroup(userGroup);
//        userGroup.addUser(testUser);
//        userRepository.save(testUser);
//        userGroupRepository.save(userGroup);
//        assertThat(testUser.getUserGroupSet()).hasSize(1);
//
//    }
//
//    @Test
//    void shouldReturnAllUsers(){
////        User testUser = User.builder()
////                .name("Jessiebopper")
////                .mobile("07809886999")
////                .email("jessie@email.com")
////                .build();
////        userRepository.save(testUser);
//
//        List<User> result = new ArrayList<>(userRepository.findAll());
//        assertEquals(1,result.size(),"that's it only one element");
//    }
//
//    @Test
//    void addUserToGroup(){
//        User testUser = User.builder()
//                .name("Jessiebopper")
//                .mobile("07809886999")
//                .email("jessie@email.com")
//                .build();
//        userRepository.save(testUser);
//    }
}