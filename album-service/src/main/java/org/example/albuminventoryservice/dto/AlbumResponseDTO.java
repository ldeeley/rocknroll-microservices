package org.example.albuminventoryservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AlbumResponseDTO {

    private Integer albumId;
    private String title;
    private String band;
    private String artwork;
    private Integer stock;

}
