package com.example.steven.tachesListe.Task;

import com.example.steven.tachesListe.List.ListEntity;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskJPARepositery extends JpaRepository<TaskEntity, Integer> {
    List<TaskEntity> findByListEntityAndPriorityOrderByPriorityAsc(ListEntity listEntity, Priority priority, Sort sort);
    List<TaskEntity> findByListEntityOrderByPriorityAsc(@NonNull ListEntity listEntity, Sort sort);
    @Query("SELECT t from TaskEntity t WHERE t.listEntity = :list AND t.status = :status ORDER BY t.priority")
    List<TaskEntity> findTasksByListAndStatus(@Param("list") ListEntity list, @Param("status") Boolean status);
}
