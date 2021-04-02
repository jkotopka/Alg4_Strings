package org.kotopka;

public class Student {
    String name;
    int section;

    public Student(String name, int section) {
        this.name = name;
        this.section = section;
    }

    public String getName() { return name; }
    public int key() { return section; }

    public static Student build(String name, int section) {
        return new Student(name, section);
    }

    public String toString() {
        return String.format("%-12s%2d", name, section);
    }

}
