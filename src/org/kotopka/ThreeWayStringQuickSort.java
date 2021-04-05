package org.kotopka;

import java.util.Arrays;

public class ThreeWayStringQuickSort {

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else return -1;
    }

    public static void sort(String[] a) {
        sort(a, 0, a.length - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        if (hi <= lo) return;

        int lt = lo;
        int gt = hi;
        int v  = charAt(a[lo], d);  // pivot
        int i  = lo + 1;

        // 3-way partition
        while (i <= gt) {
            int t = charAt(a[i], d);

            if      (t < v) exch(a, lt++, i++);
            else if (t > v) exch(a, i, gt--);
            else i++;
        }

        // recursive sorts on less-than, equal, and greater-than partitions
        sort(a, lo, lt - 1, d);
        if (v >= 0) sort (a, lt, gt, d + 1); // d + 1 because we've already sorted the dth character
        sort(a, gt + 1, hi, d);
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] =  a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {
        String[] input = {
                "she",
                "sells",
                "seashells",
                "by",
                "the",
                "sea",
                "shore",
                "the",
                "shells",
                "she",
                "sells",
                "are",
                "surely",
                "seashells"
        };

        System.out.println("Unsorted:");
        Arrays.stream(input).forEach(System.out::println);

        sort(input);

        System.out.println("\nSorted:");
        Arrays.stream(input).forEach(System.out::println);
    }

}
