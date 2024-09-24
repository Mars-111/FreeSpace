package ru.freespace.FreeSpace.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.freespace.FreeSpace.models.Box;
import ru.freespace.FreeSpace.models.File;
import ru.freespace.FreeSpace.repositories.FileRepository;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;

    public List<File> listFilesByBox(Box box) {
        return fileRepository.findByBox(box);
    }

    public File toFileEntity(MultipartFile multipartFile) throws IOException {
        File file = new File();
        file.setName(multipartFile.getName());
        file.setOriginalFileName(multipartFile.getOriginalFilename());
        file.setContentType(multipartFile.getContentType());
        file.setSize(multipartFile.getSize());
        file.setBytes(multipartFile.getBytes());
        file.setMainPage(false);
        return file;
    }

    public File getFileById(Long id) {
        return fileRepository.findById(id).orElse(null);
    }

    public void saveFile(File file) {
        fileRepository.save(file);
    }
}
