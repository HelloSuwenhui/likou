package sort;

import java.util.Arrays;

public class 冒泡 {
    public static void main(String[] args) {
        int[] ints = {5, 1, 5, 3, 5, 6, 8, 9, 0, 244, 54, 67, 3, 867, 454, 3453, 43, 23452352, 2342, 23452, 677567};
        冒泡(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void 冒泡(int[] ints) {
        //右边界
        int right = ints.length - 1;
        for (int i = 0; i < ints.length; i++) {
            int tempRight = right;
            for (int j = 0; j < right; j++) {
                if (ints[j] > ints[j + 1]) {
                    //交换位置
                    int temp = ints[j];
                    ints[j] = ints[j + 1];
                    ints[j + 1] = temp;
                    tempRight = j + 1;
                }
            }
            //设置右边界
            right = tempRight;
        }
        if (right == 0) {
            return;
        }
    }
}
