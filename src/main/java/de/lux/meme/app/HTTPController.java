package de.lux.meme.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.sql.Blob;
import java.time.LocalDate;

@Controller
@RestController
@RequestMapping(path="/demo")
public class HTTPController {
    @Autowired
    private MemesRepository memesRepository;

    @PostMapping(path="/add", consumes = "multipart/form-data")
    public @ResponseBody String addNewMeme (@RequestParam MultipartFile pic, @RequestParam LocalDate date, @RequestParam int height, @RequestParam int length, @RequestParam int size, @RequestParam int category, @RequestParam int tag) throws IOException {
        memes m = new memes();
        m.setPic(pic.getBytes());
        m.setDate(date);
        m.setHeight(height);
        m.setLength(length);
        m.setSize(size);
        m.setCategory(category);
        m.setTag(tag);
        memesRepository.save(m);
        return "Saved";
    }

    @GetMapping(path="/all")
    public @ResponseBody Iterable<memes> getAllMemes() {
        return memesRepository.findAll();
    }
}
