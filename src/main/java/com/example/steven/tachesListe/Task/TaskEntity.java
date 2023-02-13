package com.example.steven.tachesListe.Task;

import com.example.steven.tachesListe.List.ListEntity;
import com.example.steven.tachesListe.Worker.WorkerEntity;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table(name="task")
public class TaskEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "priority", nullable = false)
    @Convert(converter = PriorityConverter.class)
    private Priority priority;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "list_id", referencedColumnName = "id", nullable = false)
    private ListEntity listEntity;

    @ManyToOne
    @JoinColumn(name = "worker_id", referencedColumnName = "id")
    private WorkerEntity workerEntity;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setListEntity(ListEntity listEntity) {
        this.listEntity = listEntity;
    }

    public void setWorkerEntity(WorkerEntity workerEntity) {
        this.workerEntity = workerEntity;
    }

    public Integer getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Priority getPriority() {
        return priority;
    }

    public Boolean getStatus() {
        return status;
    }

    public ListEntity getListEntity() {
        return listEntity;
    }

    public WorkerEntity getWorkerEntity() {
        return workerEntity;
    }
}
