package mk.ukim.finki.wp.lab.web.controller;

import mk.ukim.finki.wp.lab.model.Album;
import mk.ukim.finki.wp.lab.service.AlbumService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/album")
public class AlbumController {

    public final AlbumService albumService;

    public AlbumController(AlbumService albumService) {
        this.albumService = albumService;
    }

    @PostMapping()
    public String getAlbumDetails(@RequestParam Long albumId, Model model) {
        Album album = albumService.findById(albumId);

        model.addAttribute("album", album);

        return "albumsDetails";
    }

}
