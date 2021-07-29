package sort;

import java.util.Arrays;

public class 插入 {
    public static void main(String[] args) {
        int[] ints = {5, 1, 5, 3, 5, 6, 8, 9, 0, 244, 54, 67, 3, 867, 454, 3453, 43, 23452352, 2342, 23452, 677567};
        插入(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void 插入(int[] ints) {
        for (int i = 0; i < ints.length-1; i++) {
            int j = i + 1;
            int temp = ints[j];
            while (j > 0 && temp < ints[j - 1]) {
                //交换位置
                ints[j] = ints[j - 1];
                j--;
            }
            ints[j] = temp;
        }
    }
}
