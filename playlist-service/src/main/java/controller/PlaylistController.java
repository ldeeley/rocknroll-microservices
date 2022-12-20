package controller;

import dto.PlaylistRequestDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/playlist")
public class PlaylistController {

    @PostMapping
    public String createPlaylist(@RequestBody PlaylistRequestDTO playlistRequestDTO){
        return "Playlist Created";
    }

}
