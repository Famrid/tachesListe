package com.example.steven.tachesListe.Task;

import com.example.steven.tachesListe.List.ListJPARepositery;
import com.example.steven.tachesListe.Worker.WorkerEntity;
import com.example.steven.tachesListe.Worker.WorkerJPARepositery;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TaskService {
    private TaskJPARepositery taskJPARepositery;
    private ListJPARepositery listJPARepositery;
    private WorkerJPARepositery workerJPARepositery;

    public TaskService(TaskJPARepositery taskJPARepositery, ListJPARepositery listJPARepositery, WorkerJPARepositery workerJPARepositery) {
        this.taskJPARepositery = taskJPARepositery;
        this.listJPARepositery = listJPARepositery;
        this.workerJPARepositery = workerJPARepositery;
    }

    public TaskEntity createTask(TaskEntity entity) {
        entity = this.taskJPARepositery.save(entity);
        return entity;
    }

    public void deleteTask(TaskEntity entity) {
        this.taskJPARepositery.delete(entity);
    }

    public List<TaskEntity> taskPerEntityAndStatus(Integer id, Boolean status) {
        if(this.listJPARepositery.findById(id).isPresent()) {
            return taskJPARepositery.findTasksByListAndStatus(this.listJPARepositery.findById(id).get(), status);
        }
            return null;
    }

    public TaskEntity assignTaskToWorker(Integer id, Integer workerId) {
        if(this.taskJPARepositery.findById(id).isPresent() && this.workerJPARepositery.findById(workerId).isPresent()) {
            TaskEntity task = this.taskJPARepositery.findById(id).get();
            WorkerEntity worker = this.workerJPARepositery.findById(workerId).get();
            task.setWorkerEntity(worker);
            this.taskJPARepositery.save(task);
            return task;
        }
        return null;
    }

    public TaskEntity removeTaskToWorker(Integer id) {
        if(this.taskJPARepositery.findById(id).isPresent()) {
            TaskEntity task = this.taskJPARepositery.findById(id).get();
            task.setWorkerEntity(null);
            this.taskJPARepositery.save(task);
            return task;
        }
        return null;
    }

    public TaskEntity patchDescriptionAndTitle(TaskDTO taskDTO, Integer id) {
        if(this.taskJPARepositery.findById(id).isPresent()) {
            TaskEntity task = this.taskJPARepositery.findById(id).get();
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            this.taskJPARepositery.save(task);
            return task;
        } else {
            return null;
        }
    }

    public TaskEntity patchStatusTask(TaskDTO taskDTO, Integer id) {
        if(this.taskJPARepositery.findById(id).isPresent()) {
            TaskEntity task = this.taskJPARepositery.findById(id).get();
            task.setStatus(taskDTO.getStatus());
            this.taskJPARepositery.save(task);
            return task;
        } else {
            return null;
        }

    }
}
