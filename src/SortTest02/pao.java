package SortTest02;

import java.util.Arrays;

public class pao {
    public static void main(String[] args) {
        int[] a = {10, 8, 1, 2, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    util.swag(arr, j, j + 1);
                }
            }
        }
    }
}
