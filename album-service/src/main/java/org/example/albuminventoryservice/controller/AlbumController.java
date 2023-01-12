package org.example.albuminventoryservice.controller;

import org.example.albuminventoryservice.dto.AlbumResponseDTO;
import org.example.albuminventoryservice.exception.AlbumNotFoundException;
import org.example.albuminventoryservice.service.AlbumServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/album")
public class AlbumController {

    private final AlbumServiceImpl albumServiceImpl;
    @Value("${my.greeting}")
    private String msg;

    @GetMapping("/{album-code}/instock")
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@PathVariable("album-code") Integer albumCode ) throws AlbumNotFoundException {
        return albumServiceImpl.isAlbumInStock(albumCode);
    }
    @GetMapping("/{album-code}")
    @ResponseStatus(HttpStatus.OK)
    public AlbumResponseDTO getAlbum(@PathVariable("album-code") Integer albumCode ) throws AlbumNotFoundException {
        return albumServiceImpl.getAlbum(albumCode);
    }

    @GetMapping("/msg")
    public void myMsg(){
        System.out.println(msg);
    }

}
