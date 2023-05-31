package org.example.model;

public class Person {

    // Member Field
    int id; // 매개변수
    String name; // 매개변수

    // Constructor add => id, name
    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // toString method => id, name
    @Override
    public String toString() {
        // String formatting => int length 3, String name
        return String.format("%,03d %s", id, name);
    }
}
