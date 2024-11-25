package mk.ukim.finki.wp.lab.service;



import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.SameSongsIDException;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findById(long id);

    Song deleteById(long id);

    Song findByTrackId(String id);
    Song deleteByTrackId(String id);

    Song addSong(Song song) throws SameSongsIDException;

    Song editSong(long id, Song updatedSong) throws SameSongsIDException;

}
