package org.example.albuminventoryservice.service;

import org.example.albuminventoryservice.dto.AlbumResponseDTO;
import org.example.albuminventoryservice.exception.AlbumNotFoundException;
import org.example.albuminventoryservice.model.Album;
import org.example.albuminventoryservice.repository.AlbumRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AlbumServiceImpl implements AlbumService {

    private final AlbumRepository albumRepository;

    private final ModelMapper modelMapper;

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
    @Transactional(readOnly = true)
    public AlbumResponseDTO getAlbum(Integer albumId) throws AlbumNotFoundException {
        try {
            log.info("AlbumServiceImpl::getAlbum execution started.");
            Album album = albumRepository.findById(albumId).orElseThrow(() -> new AlbumNotFoundException("Album with id : " + albumId + " not found"));
            log.info("AlbumServiceImpl::getAlbum execution ended.");
            return convertToDTO(album);
        } catch (Exception ex) {
            log.error("Exception occurred while reading album from database, Exception Message : {}",ex.getMessage());
            throw new AlbumNotFoundException("Album not found with id : " + albumId);
        }
    }

    private AlbumResponseDTO convertToDTO(Album album){
        return modelMapper.map(album,AlbumResponseDTO.class);
    }

}
