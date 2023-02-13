package com.example.steven.tachesListe.Worker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    private WorkerMapper workerMapper;
    private WorkerService workerService;

    public WorkerController(WorkerService workerService) {
        this.workerService = workerService;
    }

    @PostMapping
    public WorkerDTO createWorker(@RequestBody WorkerDTO dto) {
        WorkerEntity entity = workerMapper.toEntity(dto);
        entity = workerService.createWorker(entity);
        return workerMapper.toDto(entity);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<WorkerDTO> deleteWorkerById(@PathVariable("id") Integer id) {
        if(workerService.deleteWorker(id)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.status(410).build();
        }
    }
}
