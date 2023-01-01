package org.example.playlistservice.controller;

import org.example.playlistservice.dto.PlaylistRequestDTO;
import lombok.RequiredArgsConstructor;
import org.example.playlistservice.service.PlaylistService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/playlist")
public class PlaylistController {

    private final PlaylistService playlistService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPlaylist(@RequestBody PlaylistRequestDTO playlistRequestDTO){
        playlistService.createPlayList(playlistRequestDTO);
        return "Playlist created successfully";
    }

}
