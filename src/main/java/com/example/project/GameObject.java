package com.example.project;

public class GameObject {
    private static long idCounter = 0;
    private long id;

    GameObject() {
        this.id = idCounter++;
    }

    public long getId() {
        return id;
    }
}
