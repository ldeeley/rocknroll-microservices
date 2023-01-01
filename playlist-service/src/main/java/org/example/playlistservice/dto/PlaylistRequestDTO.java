package org.example.playlistservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlaylistRequestDTO {

    private String playListName;
    private List<PlaylistItemDTO> playlistItemDTOList;

}
