package mk.ukim.finki.wp.lab.web;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import mk.ukim.finki.wp.lab.model.Song;
import mk.ukim.finki.wp.lab.repository.impl.InMemorySongRepository;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import java.io.IOException;

@WebServlet(urlPatterns = "/songDetails",name = "songDetails Servlet")
public class songDetails extends HttpServlet {

    private final SpringTemplateEngine springTemplateEngine;
    private final InMemorySongRepository songRepository;

    public songDetails(SpringTemplateEngine springTemplateEngine, InMemorySongRepository songRepository) {
        this.springTemplateEngine = springTemplateEngine;
        this.songRepository = songRepository;
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String trackId = req.getParameter("trackId");
        System.out.println("Details:"+trackId);
        IWebExchange iWebExchange = JakartaServletWebApplication.buildApplication(req.getServletContext()).buildExchange(req, resp);
        WebContext context = new WebContext(iWebExchange);
        Song song = songRepository.findByTrackId(trackId);
        context.setVariable("song",song);
        springTemplateEngine.process("songDetails.html",context,resp.getWriter());

    }
}
