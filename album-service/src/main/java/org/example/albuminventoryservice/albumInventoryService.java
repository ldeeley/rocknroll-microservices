package org.example.albuminventoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.modelmapper.ModelMapper;

@EnableDiscoveryClient
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
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }
}
