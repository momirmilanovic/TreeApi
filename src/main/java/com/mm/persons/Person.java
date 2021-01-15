package com.mm.persons;

public class Person {
    private String name;
    private int pid;

    public Person(String name, int pid) {
        this.name = name;
        this.pid = pid;
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                '}';
    }

    public int getPid() {
        return this.pid;
    }
}
