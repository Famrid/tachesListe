package com.example.steven.tachesListe.Worker;

import javax.persistence.Column;

public class WorkerDTO {
    private String name;
    private String surname;
    private String function;


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
}
