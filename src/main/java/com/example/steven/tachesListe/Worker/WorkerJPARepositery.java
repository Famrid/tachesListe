package com.example.steven.tachesListe.Worker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerJPARepositery extends JpaRepository<WorkerEntity, Integer> {
}
