package sort;

import java.util.Arrays;

//最垃圾的排序
public class 选择 {
    public static void main(String[] args) {
       int[] ints = {5, 1, 5, 3, 5, 6, 8, 9, 0, 244, 54, 67, 3, 867, 454, 3453, 43, 23452352, 2342, 23452, 677567};
        选择(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void 选择(int[] ints) {
        for (int i = 0; i < ints.length; i++) {
            //设置最少值初始化下标
            int minIndex = i;
            for (int j = i+1; j < ints.length; j++) {
                if (ints[minIndex] > ints[j]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                //交换位置
                int temp = ints[minIndex];
                ints[minIndex] = ints[i];
                ints[i] = temp;
            }
        }
    }
}

