package SortTest02;

import java.util.Arrays;

public class kuai {
    public static void main(String[] args) {
        int[] a = {10, 8, 1, 2, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int min = left - 1;
        for (int i = left; i < right; i++) {
            if (arr[i] <= arr[right]) {
                min++;
                util.swag(arr, min, i);
            }
        }
        util.swag(arr, min + 1, right);
        quickSort(arr, 0, min);
        quickSort(arr, min + 2, right);
    }
}
