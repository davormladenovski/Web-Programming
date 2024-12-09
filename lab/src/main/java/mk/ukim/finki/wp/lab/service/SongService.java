package mk.ukim.finki.wp.lab.service;



import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.SameSongsIDException;

import java.util.List;

public interface SongService {
    List<Song> listSongs();
    Artist addArtistToSong(Artist artist, Song song);
    Song findById(long id);

    void deleteById(long id);

    Song findByTrackId(String id);
    Song deleteByTrackId(String id);
    @Transactional
    void addSong(String trackId, String title, String genre, int releaseYear, long albumId) throws SameSongsIDException;

    Song editSong(long id, Song updatedSong) throws SameSongsIDException;

}
