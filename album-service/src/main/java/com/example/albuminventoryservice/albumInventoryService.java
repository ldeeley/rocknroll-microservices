package com.example.albuminventoryservice;

import com.example.albuminventoryservice.model.Album;
import com.example.albuminventoryservice.repository.AlbumRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class albumInventoryService {

    public static void main(String[] args) {
        SpringApplication.run(albumInventoryService.class, args);
    }

//    @Bean
//    public CommandLineRunner loadData(AlbumRepository albumRepository){
//        return args-> {
//            Album album1 = new Album();
//            album1.setAlbumId(1);
//            album1.setBand("The Beatles");
//            album1.setTitle("Abbey Road");
//            album1.setStock(5);
//
//            Album album2 = new Album();
//            album2.setAlbumId(2);
//            album2.setTitle("David Bowie");
//            album2.setBand("Life on Mars?");
//            album2.setStock(0);
//
//            albumRepository.save(album1);
//            albumRepository.save(album2);
//        };
//    }

}
