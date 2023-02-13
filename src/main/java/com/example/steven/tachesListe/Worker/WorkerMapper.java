package com.example.steven.tachesListe.Worker;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface WorkerMapper {
    WorkerDTO toDto(WorkerEntity entity);
    WorkerEntity toEntity(WorkerDTO workerDTO);
}
