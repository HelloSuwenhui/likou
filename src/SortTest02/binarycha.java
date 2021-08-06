package SortTest02;

import java.util.Arrays;

public class binarycha {
    public static void main(String[] args) {
        int[] a = {10, 8, 1, 2, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int temp = arr[j];

            int changeindex = getIndex(arr, j, 0, j - 1);

            for (int k = j - 1; k >= changeindex; k--) {
                arr[k + 1] = arr[k];
            }
            arr[changeindex] = temp;
        }

    }

    private static int getIndex(int[] arr, int j, int left, int right) {
        if (left > right) {
            return right + 1;
        }
        int mid = left + (right - left) / 2;
        if (arr[mid] >= arr[j]) {
            return getIndex(arr, j, 0, mid - 1);
        } else {
            return getIndex(arr, j, mid + 1, right);
        }
    }
}
