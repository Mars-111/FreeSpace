package ru.freespace.FreeSpace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.freespace.FreeSpace.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
}
