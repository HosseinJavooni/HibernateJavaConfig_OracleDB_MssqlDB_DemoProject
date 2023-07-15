package org.example.model;

public enum Rule {
    MANAGER(10),
    CLERK(20),
    WORKER(30);
    private int value;

    Rule(int value){
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
