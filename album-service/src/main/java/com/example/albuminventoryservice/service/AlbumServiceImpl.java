package com.example.albuminventoryservice.service;

import com.example.albuminventoryservice.exception.AlbumNotFoundException;
import com.example.albuminventoryservice.model.Album;
import com.example.albuminventoryservice.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    @Transactional(readOnly = true)
    public boolean isAlbumInStock(Integer albumId) throws AlbumNotFoundException {
        try {
            log.info("AlbumServiceImpl::isAlbumInStock execution started.");
            Album album = albumRepository.findById(albumId).orElseThrow(() -> new AlbumNotFoundException("Album with id : " + albumId + " not found"));
            log.info("AlbumServiceImpl::isAlbumInStock execution ended.");
            return album.getStock()>0;
        } catch (Exception ex) {
            log.error("Exception occurred while reading user from database, Exception Message : {}",ex.getMessage());
            throw new AlbumNotFoundException("Album not found with id : " + albumId);
        }

    }


}
