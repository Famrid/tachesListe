package com.example.steven.tachesListe.Worker;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class WorkerService {
    private WorkerJPARepositery workerJPARepositery;

    public WorkerService(WorkerJPARepositery workerJPARepositery) {
        this.workerJPARepositery = workerJPARepositery;
    }

    public WorkerEntity createWorker(WorkerEntity entity) {
        return workerJPARepositery.save(entity);
    }

    public boolean deleteWorker(Integer id) {
        if(workerJPARepositery.findById(id).isPresent()) {
            workerJPARepositery.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
