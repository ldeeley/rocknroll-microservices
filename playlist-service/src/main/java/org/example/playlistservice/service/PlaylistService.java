package org.example.playlistservice.service;

import org.example.albuminventoryservice.dto.AlbumResponseDTO;
import org.example.playlistservice.dto.PlaylistItemDTO;
import org.example.playlistservice.dto.PlaylistRequestDTO;
import lombok.RequiredArgsConstructor;
import org.example.playlistservice.model.PlayListItem;
import org.example.playlistservice.model.Playlist;
import org.example.playlistservice.repository.PlaylistRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

    private final WebClient.Builder webClientBuilder;

    public void createPlayList(PlaylistRequestDTO playlistRequestDTO){
        Playlist playlist = new Playlist();
        playlist.setPlaylistName(playlistRequestDTO.getPlayListName());
        List<PlayListItem> playListItemList = playlistRequestDTO.getPlaylistItemDTOList()
                .stream()
                .map(this::mapToDTO)
                .toList();
        playlist.setAlbumIdList(playListItemList);

        playlistRepository.save(playlist);

    }

    private PlayListItem mapToDTO(PlaylistItemDTO playlistItemDTO){
        PlayListItem playListItem = new PlayListItem();
        playListItem.setAlbumId(playlistItemDTO.getAlbumId());
        // get Album data for the playlistItem from the AlbumService
        // note the dependency on the AlbumResponseDTO.class - is this bad coupling ? ask Tom
        AlbumResponseDTO albumResponseDTO = webClientBuilder.build().get().uri("http://Album-Service/api/album/"+playListItem.getAlbumId())
                        .retrieve()
                        .bodyToMono(AlbumResponseDTO.class)
                        .block();
        playListItem.setAlbumTitle(albumResponseDTO.getTitle());
        playListItem.setAlbumArtist(albumResponseDTO.getBand());

        return playListItem;
    }

}
