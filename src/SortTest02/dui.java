package SortTest02;

import java.util.Arrays;

public class dui {
    public static void main(String[] args) {
        int[] a = {1,10, 8, 1, 2, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {
        heapBuild(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            util.swag(arr, 0, i);
            heapify(arr, i - 1, 0);
        }
    }

    private static void heapBuild(int[] arr) {
        int mid = (arr.length - 1) / 2;
        for (int i = mid; i >= 0; i--) {
            heapify(arr, arr.length-1, i);
        }
    }

    private static void heapify(int[] arr, int length, int n) {
        int left = (n << 1) + 1;
        if (left <= length) {
            int larger = left;
            if (left + 1 <= length) {
                larger = (arr[left] >= arr[left + 1]) ? left : left + 1;
            }
            if (arr[larger] > arr[n]) {
                util.swag(arr, larger, n);
                heapify(arr, length, larger);
            }
        }
    }


}
