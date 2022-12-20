package com.example.albuminventoryservice.controller;

import com.example.albuminventoryservice.exception.AlbumNotFoundException;
import com.example.albuminventoryservice.service.AlbumServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/album")
public class AlbumController {

    private final AlbumServiceImpl albumServiceImpl;

    @GetMapping("/api/{album-code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("album-code") Integer albumCode ) throws AlbumNotFoundException {
        return albumServiceImpl.isAlbumInStock(albumCode);
    }

}
