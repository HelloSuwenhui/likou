package SortTest02;

import java.util.Arrays;

public class cha {
    public static void main(String[] args) {
        int[] a = {10, 8, 1, 2, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int temp = arr[j];
            while (j - 1 >= 0 && arr[j - 1] > temp) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = temp;
        }

    }
}
