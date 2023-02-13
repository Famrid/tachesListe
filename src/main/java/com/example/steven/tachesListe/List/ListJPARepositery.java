package com.example.steven.tachesListe.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ListJPARepositery extends JpaRepository<ListEntity, Integer> {
}
