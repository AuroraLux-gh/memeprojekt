package de.lux.meme.app;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.time.LocalDate;

@Entity
@Getter @Setter @NoArgsConstructor
public class memes {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;

    @Lob
    private byte[] pic;
    private LocalDate date;
    private int height;
    private int length;
    private int size;
    private int category;
    private int tag;
}
