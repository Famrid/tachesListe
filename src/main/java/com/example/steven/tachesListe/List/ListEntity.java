package com.example.steven.tachesListe.List;

import com.example.steven.tachesListe.Task.TaskEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "list")
public class ListEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(targetEntity = TaskEntity.class, mappedBy = "listEntity", orphanRemoval = true, cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<TaskEntity> taskList = new ArrayList<>();

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
