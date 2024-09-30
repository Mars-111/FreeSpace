package ru.freespace.FreeSpace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.freespace.FreeSpace.models.File;
import ru.freespace.FreeSpace.services.FileService;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class FileController {
    private final FileService fileService;

    //В избранном оптимизация
    @GetMapping("/files/{id}")
    private ResponseEntity<?> getFile(@PathVariable Long id) {
        File file = fileService.getFileById(id);
        return ResponseEntity.ok()
                .header("fileName", file.getOriginalFileName())
                .contentType(MediaType.valueOf(file.getContentType()))
                .contentLength(file.getSize())
                .body(new InputStreamResource(new ByteArrayInputStream(file.getBytes())));
    }

    @GetMapping("/files/edit/{id}")
    private String editFile(@PathVariable Long id, Model model, Principal principal) {
        File file = fileService.getFileById(id);

        if (!principal.getName().equals(file.getBox().getUser().getEmail()))
            return "errors/no-permissions";

        model.addAttribute("file", file);
        if (file.getBytes() != null)
            model.addAttribute("content", new String(file.getBytes(), StandardCharsets.UTF_8));
        else
            model.addAttribute("content", "");

        return "file-edit";
    }

    @PostMapping("/files/edit/{id}/save_edit")
    private String saveEditFile(@PathVariable Long id, @RequestParam("content") String content, Principal principal) {
        File file = fileService.getFileById(id);
        if (!principal.getName().equals(file.getBox().getUser().getEmail()))
            return "errors/no-permissions";
        file.setBytes(content.getBytes());
        file.setSize((long)content.getBytes().length);
        fileService.saveFile(file);
        return "redirect:/box/" + file.getBox().getId().toString();
    }

}
