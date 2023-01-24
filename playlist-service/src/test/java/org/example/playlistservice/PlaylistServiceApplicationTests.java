package org.example.playlistservice;

import org.example.playlistservice.controller.PlaylistController;
import org.example.playlistservice.service.PlaylistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.util.AssertionErrors.assertTrue;

@WebMvcTest(PlaylistController.class)
class PlaylistServiceApplicationTests {

    @Test
    void contextLoads() {

    }

}
