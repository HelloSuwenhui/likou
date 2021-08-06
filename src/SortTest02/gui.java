package SortTest02;

import java.util.Arrays;

public class gui {
    public static void main(String[] args) {
        int[] a = {10, 8, 1, 2, 9};
        sort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void sort(int[] arr) {
        guiSort(arr, 0, arr.length-1 );
    }

    private static void guiSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + (right - left) / 2;
        guiSort(arr, left, mid);
        guiSort(arr, mid + 1, right);
        meger(arr, left, right, mid);
    }

    private static void meger(int[] arr, int left, int right, int mid) {
        int[] temp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        for (int l = 0; l < temp.length; l++) {
            arr[left + l] = temp[l];
        }

    }
}
