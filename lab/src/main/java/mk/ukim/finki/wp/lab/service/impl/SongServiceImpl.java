package mk.ukim.finki.wp.lab.service.impl;


import jakarta.transaction.Transactional;
import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.model.exceptions.SameSongsIDException;
import mk.ukim.finki.wp.lab.repository.jpa.AlbumRepository;
import mk.ukim.finki.wp.lab.repository.jpa.SongRepository;
import mk.ukim.finki.wp.lab.service.SongService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongServiceImpl implements SongService {

    public final SongRepository songRepository;
    public final AlbumRepository albumRepository;

    public SongServiceImpl(SongRepository songRepository, AlbumRepository albumRepository) {
        this.songRepository = songRepository;
        this.albumRepository = albumRepository;
    }

    @Override
    public List<Song> listSongs() {
        return songRepository.findAll();
    }

    @Override
    public Artist addArtistToSong(Artist artist, Song song) {
        song.getPerformers().add(artist);
        songRepository.save(song);
        return artist;
    }

    @Override
    public Song findById(long id) {
        return songRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(long id) {
        songRepository.deleteById(id);
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
    @Transactional
    public void addSong(String trackId, String title, String genre, int releaseYear, long albumId) throws SameSongsIDException {
        Album album = albumRepository.findById(albumId).orElse(null);

        if (album == null) {
            return;
        }

        if(songRepository.findByTrackId(trackId)!=null){
            throw new SameSongsIDException();
        }

        Song song = new Song(trackId, title, genre, releaseYear, album);
        album.getSongs().add(song);

        songRepository.save(song);

    }

    @Override
    public Song editSong(long id, Song updatedSong){
        updatedSong.setId(id);
        return songRepository.save(updatedSong);
    }
}
