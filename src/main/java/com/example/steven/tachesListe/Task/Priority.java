package com.example.steven.tachesListe.Task;

public enum Priority {
    BASSE(1),
    MOYENNE(2),
    HAUTE(3);

    private int value;

    Priority(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static Priority fromValue(int value) {
        for (Priority priority : Priority.values()) {
            if (priority.getValue() == value) {
                return priority;
            }
        }
        throw new IllegalArgumentException("Invalid Priority value");
    }
}
