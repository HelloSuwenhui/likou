package SortTest02;

import java.util.Arrays;

public class xi {
    public static void main(String[] args) {
        int[] a = {10, 8, 1, 2, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {
        xiSort(arr, arr.length);
    }

    private static void xiSort(int[] arr, int n) {
        if (n == 1) return;
        n = n / 2;
        for (int i = n-1; i < arr.length-1; i++) {
            int j = i + 1;
            int temp = arr[j];
            while (j - n >= 0 && arr[j - n] > temp) {
                arr[j] = arr[j - n];
                j -= n;
            }
                arr[j] = temp;
        }
        xiSort(arr, n);
    }
}
