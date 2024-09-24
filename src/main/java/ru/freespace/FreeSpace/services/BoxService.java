package ru.freespace.FreeSpace.services;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.freespace.FreeSpace.models.Box;
import ru.freespace.FreeSpace.repositories.BoxRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoxService {
    private final BoxRepository boxRepository;

    public List<Box> listBox() {
        return boxRepository.findAll();
    }

    public void saveBox(Box box) {
        boxRepository.save(box);
    }

    public Box getBoxById(Long id) {
        return boxRepository.findById(id).orElse(null);
    }
}
