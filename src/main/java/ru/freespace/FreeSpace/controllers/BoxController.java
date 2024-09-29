package ru.freespace.FreeSpace.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import ru.freespace.FreeSpace.models.Box;
import ru.freespace.FreeSpace.models.File;
import ru.freespace.FreeSpace.services.BoxService;
import ru.freespace.FreeSpace.services.FileService;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class BoxController {
    private final BoxService boxService;
    private final FileService fileService;

    @GetMapping("/")
    public String boxes(Principal principal, Model model) {
        model.addAttribute("boxes", boxService.listBox());
        model.addAttribute("user", boxService.getUserByPrincipal(principal));
        return "boxes";
    }

    @PostMapping("/box/create")
    public String createBox(Box box) {
        boxService.saveBox(box);
        return "redirect:/";
    }

    @GetMapping("/box/{id}")
    public String boxInfo(@PathVariable Long id, Model model) {
        model.addAttribute("box", boxService.getBoxById(id));
        return "box-info";
    }

    @GetMapping("/box/list_files/{id}")
    public String boxFilesV2(@PathVariable Long id, Model model) {
        Box box = boxService.getBoxById(id);
        model.addAttribute("box", box);
        return "box-files";
    }

    @PostMapping("/box/{id}/create-file")
    private String createFile(@PathVariable Long id, @RequestParam("file") MultipartFile multipartFile) throws IOException {
        File file = fileService.toFileEntity(multipartFile);
        Box box = boxService.getBoxById(id);
        box.addFileToBox(file);
        boxService.saveBox(box);
        return "redirect:/box/" + id;
    }

}
