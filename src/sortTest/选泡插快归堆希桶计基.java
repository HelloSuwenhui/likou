package sortTest;

import javax.lang.model.util.ElementScanner6;
import java.util.Arrays;

public class 选泡插快归堆希桶计基 {
    public static void main(String[] args) {
        int[] a = {10, 8, 1, 2, 9};
        希(a);
        System.out.println(Arrays.toString(a));
    }

    public static void 选(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[min] > arr[j]) min = j;
            }
            if (min != i) {
                util.swag(arr, i, min);
            }
        }
    }

    public static void 泡(int[] arr) {
        int right = arr.length - 1;
        for (int i = 0; i < arr.length - 1; i++, right--) {
            for (int j = 0; j < right; j++) {
                if (arr[j] > arr[j + 1]) util.swag(arr, j, j + 1);
            }
        }
    }

    public static void 插(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int temp = arr[j];
            while (j > 0 && temp < arr[j - 1]) {
                j--;
            }
            for (int k = i; k >= j; k--) {
                arr[k + 1] = arr[k];
            }
            arr[j] = temp;
        }
    }

    public static void 二分插(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int j = i + 1;
            int temp = arr[j];
            int left = 0;
            int right = i;


            while (left <= right) {
                int mid = (left + right) / 2;
                if (arr[mid] > temp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }

            int index = right + 1;
            for (int k = i; k >= index; k--) {
                arr[k + 1] = arr[k];
            }
            arr[index] = temp;


        }
    }

    public static void 归(int[] arr) {
        归并排序(arr, 0, arr.length - 1);
    }

    private static void 归并排序(int[] arr, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        归并排序(arr, left, mid);
        归并排序(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i];
                i++;
            } else {
                temp[k++] = arr[j];
                j++;
            }
        }
        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }
        if (temp.length >= 0) System.arraycopy(temp, 0, arr, left, temp.length);
    }

    public static void 堆(int[] arr) {
        heap_build(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            util.swag(arr, 0, i);
            heapify(arr, i, 0);
        }
    }

    private static void heap_build(int[] arr) {
        int mid = (arr.length - 1) / 2;
        for (int i = mid; i >= 0; i--) {
            heapify(arr, arr.length, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        if (c1 <= n - 1 && arr[c1] > arr[i]) {
            util.swag(arr, c1, i);
            heapify(arr, n, c1);
        }
        if (c2 <= n - 1 && arr[c2] > arr[i]) {
            util.swag(arr, c2, i);
            heapify(arr, n, c2);
        }
    }

    public static void 希(int[] arr) {
        int gap = (arr.length) / 2;
        while (gap > 0) {
            for (int i = gap - 1; i < arr.length - 1; i++) {
                int j = i + 1;
                int temp = arr[j];
                while (j - gap >= 0 && temp < arr[j - gap]) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = temp;
            }
            gap /= 2;
        }
    }
}
