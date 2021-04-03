package org.kotopka;

public class MSD {

    private static final int R = 256;             // radix
    private static final int CUTOFF = 15;   // cutoff for small subarrays
    private static String[] aux;

    private static int charAt(String s, int d) {
        if (d < s.length()) return s.charAt(d);
        else                return -1;
    }

    public static void sort(String[] a) {
        int n = a.length;
        aux = new String[n];
        sort(a, 0, n - 1, 0);
    }

    private static void sort(String[] a, int lo, int hi, int d) {
        // sort from a[lo] to a[hi], starting at the dth character

        // insertion sort cutoff
        if(hi <= lo + CUTOFF) {
            insertionSort(a, lo, hi, d);
            return;
        }

        int[] count = new int[R + 2];

        // compute freq. counts
        for (int i = lo; i <= hi ; i++) {
            count[charAt(a[i], d)]++;
        }

        // transform counts to indices
        for (int r = 0; r < R + 1; r++) {
            count[r + 1] += count[r];
        }

        // distribute
        for (int i = lo; i <= hi; i++) {
            int countIndex = charAt(a[i], d) + 1;

            aux[count[countIndex]++] = a[i];
        }

        // copy back
        for (int i = lo; i <= hi; i++) {
            a[i] = aux[i - lo];
        }

        // recursively sort for each character value, excluding -1
        for (int r = 0; r < R; r++) {
            sort(a, lo + count[r], lo + count[r + 1] - 1, d);
        }
    }

    private static void insertionSort(String a[], int lo, int hi, int d) {
        for (int i = lo; i <= hi ; i++) {
            for (int j = i; j > lo && less(a[j], a[j - 1], d) ; j--) {
                exch(a, j, j - 1);
            }
        }
    }

    private static boolean less(String v, String w, int d) {
        for (int i = d; i < Math.min(v.length(), w.length()); i++) {
            if      (v.charAt(i) < w.charAt(i)) return true;
            else if (v.charAt(i) > w.charAt(i)) return false;
        }
        return v.length() < w.length();
    }

    private static void exch(String[] a, int i, int j) {
        String temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static void main(String[] args) {

    }

}