package org.example.user.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class BannedUsersClient {

    public boolean isBannedUser(String username){
        return username.equalsIgnoreCase("Lester");
    }

}
