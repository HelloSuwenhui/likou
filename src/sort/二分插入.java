package sort;

import java.util.Arrays;

public class 二分插入 {
    public static void main(String[] args) {
        int[] ints = {-1,-10,-20,-2,-5};
        二分插入(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void 二分插入(int[] ints) {
        for (int i = 0; i < ints.length - 1; i++) {
            int temp = ints[i + 1];
            int left = 0;
            int right = i;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (ints[mid] > temp) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            //交换的index
            int index = right + 1;
            for (int j = i; j >= index; j--) {
                ints[j + 1] = ints[j];
            }
            ints[index] = temp;
        }
    }
}
