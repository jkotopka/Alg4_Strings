package org.kotopka;

public class LSD {

    public static void sort(String[] a, int w) {
        // sort a[] on w characters
        int n = a.length;
        int R = 256; // extended ASCII radix
        String[] aux = new String[n];

        for (int d = w - 1; d >= 0 ; d--) {
            int[] count = new int[R + 1];

            // compute freq. counts
            for (int i = 0; i < n; i++) {
                count[a[i].charAt(d) + 1]++;
            }

            // transform counts to indices
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // distribute
            for (int i = 0; i < n; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];

//                char current = a[i].charAt(d);
//                int index = count[current];
//                aux[index] = a[i];
//                index++;
            }

            // copy back
            for (int i = 0; i < n; i++) {
                a[i] = aux[i];
            }
        }
    }

    public static void sortExpandedExplanation(String[] a, int w) {
        // sort a[] on w characters
        int n = a.length;
        int R = 256; // extended ASCII radix
        String[] aux = new String[n];

        for (int d = w - 1; d >= 0; d--) {
            int[] count = new  int[R + 1];

            // compute freq. counts
            for (String s : a) {
                char current = s.charAt(d);
                count[current + 1]++;
            }

            // transform counts to indices
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }

            // distribute
            for (int i = 0; i < n; i++) {
                char current = a[i].charAt(d);
                aux[count[current]++] = a[i];
            }

            // copy back
            System.arraycopy(aux, 0, a, 0, n);

        }
    }

    public static void main(String[] args) {
        String[] licensePlates = {
                "4PGC938",
                "2IYE230",
                "3CI0720",
                "1ICK750",
                "10HV845",
                "4JZY524",
                "1ICK750",
                "3CI0720",
                "10HV845",
                "10HV845",
                "2RLA629",
                "2RLA629",
                "3ATW723"
        };

        System.out.println("Unsorted:");
        for (String s : licensePlates) {
            System.out.println(s);
        }

        sortExpandedExplanation(licensePlates, 7);

        System.out.println("\nSorted:");
        for (String s : licensePlates) {
            System.out.println(s);
        }
    }

}
