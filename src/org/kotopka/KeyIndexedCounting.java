package org.kotopka;

public class KeyIndexedCounting {

    public static void sort(Student[] a, int R) {
        int n = a.length;
        Student[] aux = new Student[n];
        int[] count = new int[R + 1];

        // compute frequency of counts
        for (int i = 0; i < n; i++) {
            count[a[i].key() + 1]++;
        }

        // transform counts to indices
        for (int r = 0; r < R; r++) {
            count[r + 1] += count[r];
        }

        // distribute the records
        for (int i = 0; i < n; i++) {
            aux[count[a[i].key()]++] = a[i];
        }

        // copy back
        for (int i = 0; i < n; i++) {
            a[i] = aux[i];
        }
    }

    public static void main(String[] args) {
        Student[] students = {
                Student.build("Anderson", 2),
                Student.build("Brown", 3),
                Student.build("Davis", 3),
                Student.build("Garcia", 4),
                Student.build("Harris", 1),
                Student.build("Jackson", 3),
                Student.build("Johnson", 4),
                Student.build("Jones", 3),
                Student.build("Martin", 1),
                Student.build("Martinez", 2),
                Student.build("Miller", 2),
                Student.build("Moore", 1),
                Student.build("Robinson", 2),
                Student.build("Smith", 4),
                Student.build("Taylor", 3),
                Student.build("Thomas", 4),
                Student.build("Thompson", 4),
                Student.build("White", 2),
                Student.build("Williams", 3),
                Student.build("Wilson", 4)
        };

        System.out.println("Unsorted:");
        for (Student s : students) {
            System.out.println(s);
        }

        sort(students, 5);  // have to increase radix by 1

        System.out.println("\nSorted:");
        for(Student s : students) {
            System.out.println(s);
        }

    }

}
