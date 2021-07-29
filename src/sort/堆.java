package sort;

import java.util.Arrays;

public class 堆 {
    public static void main(String[] args) {
        int[] ints = {5, 1, 5, 3, 5, 6, 8, 9, 0, 244, 54, 67, 3, 867, 454, 3453, 43, 23452352, 2342, 23452, 677567};
        堆排序(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void 堆排序(int[] ints) {
        //构造推
        heap_build(ints, ints.length);
        for (int i = ints.length - 1; i > 0; i--) {
            //交换 将最大值放到最后
            swap(ints, 0, i);
            //对root进行heapity
            heapity(ints, i, 0);
        }
    }

    private static void heap_build(int[] ints, int n) {
        int i = n / 2;
        for (; i >= 0; i--) {
            heapity(ints, n, i);
        }
    }

    private static void heapity(int[] ints, int n, int i) {
        if (i >= n) return;
        int c1 = i * 2 + 1;
        int c2 = i * 2 + 2;
        int max = i;
        if (c1 <= n-1 && ints[c1] > ints[max]) {
            max = c1;
        }
        if (c2 <= n-1 && ints[c2] > ints[max]) {
            max = c2;
        }
        if (max != i) {
            swap(ints, max, i);
            heapity(ints, n, max);
        }

    }

    private static void swap(int[] ints, int j, int i) {
        int temp = ints[i];
        ints[i] = ints[j];
        ints[j] = temp;
    }
}
