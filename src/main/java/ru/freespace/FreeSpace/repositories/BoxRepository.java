package ru.freespace.FreeSpace.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.freespace.FreeSpace.models.Box;

public interface BoxRepository extends JpaRepository<Box, Long> {
}
