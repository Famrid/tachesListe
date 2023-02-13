package com.example.steven.tachesListe.List;

import com.example.steven.tachesListe.Task.TaskDTO;
import com.example.steven.tachesListe.Task.TaskEntity;
import com.example.steven.tachesListe.Task.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/list")
public class ListController {
    private ListService listService;
    private TaskService taskService;

    public ListController(ListService listService, TaskService taskService) {
        this.listService = listService;
        this.taskService = taskService;
    }

    public ListEntity convertToEntity(ListDTO dto) {
        ListEntity entity = new ListEntity();
        entity.setName(dto.getTitle());
        return entity;
    }

    public ListDTO convertToDTO(ListEntity entity) {
        ListDTO dto = new ListDTO();
        dto.setTitle(entity.getName());
        return dto;
    }

    @PostMapping
    public ListDTO createList(@RequestBody ListDTO dto) {
        ListEntity entity = this.convertToEntity(dto);
        this.listService.createList(entity);
        return this.convertToDTO(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ListEntity> deleteList(@PathVariable("id") Integer id) {
        this.listService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
