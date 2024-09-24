package ru.freespace.FreeSpace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.freespace.FreeSpace.models.Box;
import ru.freespace.FreeSpace.models.File;

import java.util.List;

public interface FileRepository extends JpaRepository<File, Long> {
    List<File> findByBox(Box box);
}
