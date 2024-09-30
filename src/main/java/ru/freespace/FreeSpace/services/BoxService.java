package ru.freespace.FreeSpace.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.freespace.FreeSpace.models.Box;
import ru.freespace.FreeSpace.models.User;
import ru.freespace.FreeSpace.repositories.BoxRepository;
import ru.freespace.FreeSpace.repositories.UserRepository;

import java.security.Principal;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class BoxService {
    private final BoxRepository boxRepository;
    private final UserRepository userRepository;

    public List<Box> listBox() {
        return boxRepository.findAll();
    }

    public void saveBox(Box box, User user) {
        box.setUser(user);
        boxRepository.save(box);
    }

    public Box getBoxById(Long id) {
        return boxRepository.findById(id).orElse(null);
    }

    public User getUserByPrincipal(Principal principal) {
        if (principal == null) return null;
        return userRepository.findByEmail(principal.getName());
    }

}
