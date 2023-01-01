package org.example.user.service;

import org.example.user.exception.UserGroupNotFoundException;
import org.example.user.exception.UserNotFoundException;
import org.example.user.repository.UserRepository;
import org.example.usergroup.repository.UserGroupRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.modelmapper.ModelMapper;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class BannedUsersClientTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserGroupRepository userGroupRepository;

    @Mock
    private BannedUsersClient bannedUsersClient;

    @Mock
    private ModelMapper modelMapper;

    @InjectMocks
    UserServiceImpl userService;




    @DisplayName("Testing to see if the User is banned")
    @Test
    @Tag("user_service")
    void isBannedUser() {

        BannedUsersClient bannedUsersClient = new BannedUsersClient();

        assertTrue(bannedUsersClient.isBannedUser("Lester"));
        assertTrue(bannedUsersClient.isBannedUser("LESTER"));
        assertTrue(bannedUsersClient.isBannedUser("lESTER"));
        assertTrue(bannedUsersClient.isBannedUser("lester"));
        assertFalse(bannedUsersClient.isBannedUser(" lester"));
         assertFalse(bannedUsersClient.isBannedUser(" lester "));
         assertFalse(bannedUsersClient.isBannedUser("lester "));

    }

    @Test
    void testUserExceptionError() throws UserNotFoundException, UserGroupNotFoundException {
        Mockito.when(userRepository.findById(98)).thenReturn(Optional.empty());

        assertThrows(UserNotFoundException.class,()-> userService.findUserById(98));

    }

}