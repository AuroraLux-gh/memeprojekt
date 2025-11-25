package de.lux.meme.app;

import org.springframework.data.repository.CrudRepository;

import de.lux.meme.app.memes;

public interface MemesRepository extends CrudRepository<memes, Integer> {
}
