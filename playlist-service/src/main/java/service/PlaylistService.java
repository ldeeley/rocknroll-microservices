package service;

import dto.PlaylistItemDTO;
import dto.PlaylistRequestDTO;
import lombok.RequiredArgsConstructor;
import model.PlayListItem;
import model.Playlist;
import org.springframework.stereotype.Service;
import repository.PlaylistRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlaylistService {

    private final PlaylistRepository playlistRepository;

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
        playListItem.setId(playlistItemDTO.getId());
        playListItem.setAlbumId(playlistItemDTO.getAlbumId());
        playListItem.setAlbumArtLink(playlistItemDTO.getAlbumArtLink());
        return playListItem;
    }

}
