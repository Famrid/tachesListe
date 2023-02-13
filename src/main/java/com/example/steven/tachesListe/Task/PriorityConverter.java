package com.example.steven.tachesListe.Task;

import javax.persistence.AttributeConverter;

public class PriorityConverter implements AttributeConverter<Priority, Integer> {
    @Override
    public Integer convertToDatabaseColumn(Priority priority) {
        return priority.getValue();
    }

    @Override
    public Priority convertToEntityAttribute(Integer value) {
        return Priority.fromValue(value);
    }
}
