package org.example.playlistservice.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="t_playlist_item")
public class PlayListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int albumId;
    private String albumArtLink;
    private String albumTitle;
    private String albumArtist;

}
