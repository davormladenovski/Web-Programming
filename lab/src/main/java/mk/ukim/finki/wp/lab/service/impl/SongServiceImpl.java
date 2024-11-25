package mk.ukim.finki.wp.lab.service.impl;


import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.SameSongsIDException;
import mk.ukim.finki.wp.lab.repository.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    public final SongRepository songRepository;

    public SongServiceImpl(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        return songRepository.addArtistToSong(artist,song);
    }

    @Override
    public Song findById(long id) {
        return songRepository.findById(id);
    }

    @Override
    public Song deleteById(long id) {
        return songRepository.deleteById(id);
    }

    @Override
    public Song findByTrackId(String id) {
        return songRepository.findByTrackId(id);
    }

    @Override
    public Song deleteByTrackId(String id) {
        return songRepository.deleteByTrackId(id);
    }

    @Override
    public Song addSong(Song song) throws SameSongsIDException {
        return songRepository.addSong(song);
    }

    @Override
    public Song editSong(long id, Song updatedSong) throws SameSongsIDException {
        return songRepository.editSong(id,updatedSong);
    }
}
