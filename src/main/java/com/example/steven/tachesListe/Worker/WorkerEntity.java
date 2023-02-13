package com.example.steven.tachesListe.Worker;

import com.example.steven.tachesListe.Task.TaskEntity;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "worker")
public class WorkerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name="function", nullable = false)
    private String function;

    @OneToMany(targetEntity = TaskEntity.class, mappedBy = "workerEntity", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JsonBackReference
    private List<TaskEntity> listTaskEntity = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFunction() {
        return function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public List<TaskEntity> getListTaskEntity() {
        return listTaskEntity;
    }

    public void setListTaskEntity(List<TaskEntity> listTaskEntity) {
        this.listTaskEntity = listTaskEntity;
    }
}
