package com.example.steven.tachesListe.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class ListService {
    private ListJPARepositery listJPARepositery;

    public ListService(ListJPARepositery listJPARepositery) {
        this.listJPARepositery = listJPARepositery;
    }

    public ListEntity createList(ListEntity entity) {
        entity = this.listJPARepositery.save(entity);
        return entity;
    }

    public Optional<ListEntity> getById(Integer id) {
        return this.listJPARepositery.findById(id);
    }

    public void deleteById(Integer id) {
        this.listJPARepositery.deleteById(id);
    }

    public Boolean exist(Integer id) {
        if(this.listJPARepositery.findById(id).isPresent()) {
            return true;
        } else {
            return false;
        }
    }
}
