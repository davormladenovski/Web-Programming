package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import mk.ukim.finki.wp.lab.model.Artist;
import mk.ukim.finki.wp.lab.repository.impl.InMemoryArtistRepository;
import mk.ukim.finki.wp.lab.repository.impl.InMemorySongRepository;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/artistDetails", name = "ArtistDetailsServlet")
public class artistDetailsServlet extends HttpServlet {

    public final SpringTemplateEngine springTemplateEngine;

    public final InMemoryArtistRepository artistRepository;
    public final InMemorySongRepository songRepository;


    public artistDetailsServlet(SpringTemplateEngine springTemplateEngine, InMemoryArtistRepository artistRepository, InMemorySongRepository songRepository) {
        this.springTemplateEngine = springTemplateEngine;
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String artistId = req.getParameter("artistId");
        System.out.println("artistID:"+artistId);
        IWebExchange iWebExchange = JakartaServletWebApplication.buildApplication(req.getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        Artist artist = artistRepository.findById(Long.parseLong(artistId)).orElseThrow();
        context.setVariable("artist",artist);
        springTemplateEngine.process("artistDetails.html",context,resp.getWriter());
    }
}
