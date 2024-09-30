package ru.freespace.FreeSpace.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "boxes")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Box {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "box")
    private List<File> files = new ArrayList<>();
    private LocalDateTime dateOfCreated;
    @ManyToOne(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn
    private User user;

    @PrePersist
    private void init() {
        dateOfCreated = LocalDateTime.now();
        File index = new File();
        index.setName("index");
        index.setOriginalFileName("index.html");
        index.setContentType("text/html");
        index.setSize(0L);
        index.setMainPage(true);
        addFileToBox(index);
    }

    public void addFileToBox(File file) {
        file.setBox(this);
        files.add(file);
    }

}
