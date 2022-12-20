package com.example.albuminventoryservice.repository;

import com.example.albuminventoryservice.model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AlbumRepository extends JpaRepository<Album, Integer> {

    Optional<Object> findByAlbumId(Integer albumId);
}
