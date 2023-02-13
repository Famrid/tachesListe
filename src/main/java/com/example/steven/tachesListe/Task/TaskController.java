package com.example.steven.tachesListe.Task;

import com.example.steven.tachesListe.List.ListEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/task")
public class TaskController {
    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    public TaskEntity convertToEntity(TaskDTO taskDTO) {
        ListEntity listEntity = new ListEntity();
        listEntity.setId(taskDTO.getList_id());
        TaskEntity task = new TaskEntity();
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setPriority(taskDTO.getPriority());
        task.setStatus(taskDTO.getStatus());
        task.setListEntity(listEntity);
        return task;
    }

    public TaskDTO convertToDTO(TaskEntity taskEntity) {
        TaskDTO dto = new TaskDTO();
        dto.setTitle(taskEntity.getTitle());
        dto.setDescription(taskEntity.getDescription());
        dto.setStatus(taskEntity.getStatus());
        dto.setPriority(taskEntity.getPriority());
        dto.setList_id(taskEntity.getListEntity().getId());
        if(Objects.nonNull(taskEntity.getWorkerEntity()))
        {
            dto.setWorker_id(taskEntity.getWorkerEntity().getId());
        }
        return dto;
    }

    @PostMapping
    public TaskDTO createTask(@RequestBody TaskDTO dto) {
        TaskEntity entity = this.convertToEntity(dto);
        entity = this.taskService.createTask(entity);
        return this.convertToDTO(entity);
    }

    @DeleteMapping
    public void deleteTask(@RequestBody TaskDTO dto) {
        TaskEntity entity = this.convertToEntity(dto);
        this.taskService.deleteTask(entity);
    }

    @GetMapping("/list/{id}/{bool}")
    public ResponseEntity<List<TaskEntity>> getTaskByList(@PathVariable("id") Integer id, @PathVariable("bool") Boolean bool) {
        if(Objects.isNull(this.taskService.taskPerEntityAndStatus(id, bool))){
            return ResponseEntity.notFound().build();
        } else {
            List<TaskEntity> listTaskEntity = this.taskService.taskPerEntityAndStatus(id, bool);
            return ResponseEntity.ok(listTaskEntity);
        }
    }

    @PatchMapping("/{id}/content")
    public ResponseEntity<TaskEntity> changeTaskTitleAndDescription(@PathVariable("id") Integer id, @RequestBody TaskDTO taskDTO) {
        TaskEntity task = this.taskService.patchDescriptionAndTitle(taskDTO, id);
        if(Objects.nonNull(task)) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/status")
    public ResponseEntity<TaskEntity> changeTaskStatus(@PathVariable("id") Integer id, @RequestBody TaskDTO taskDTO) {
        TaskEntity task = this.taskService.patchStatusTask(taskDTO, id);
        if(Objects.nonNull(task)) {
            return ResponseEntity.ok(task);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @PatchMapping("/{id}/worker/{workerId}/assign")
    public ResponseEntity<TaskEntity> assignTaskToWorker(@PathVariable("id") Integer id, @PathVariable("workerId") Integer workerId) {
        TaskEntity task = this.taskService.assignTaskToWorker(id, workerId);
        if(Objects.nonNull(task)) {
            return ResponseEntity.ok(task);
        } else {
            return  ResponseEntity.notFound().build();
        }
    }

    @PatchMapping("/{id}/worker/unassign")
    public ResponseEntity<TaskEntity> unassignWorkerToTask(@PathVariable("id") Integer id) {
        TaskEntity task = this.taskService.removeTaskToWorker(id);
        if(Objects.nonNull(task)) {
            return ResponseEntity.ok(task);
        } else {
            return  ResponseEntity.notFound().build();
        }
    }
}
