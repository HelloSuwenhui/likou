package sort;

import java.util.Arrays;

//跳着插入
public class 希尔 {
    public static void main(String[] args) {
        int[] ints = {5, 1, 5, 3, 5, 6, 8, 9, 0, 244, 54, 67, 3, 867, 454, 3453, 43, 23452352, 2342, 23452, 677567};
        希尔(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void 希尔(int[] ints) {
        //gap 间隔
        for (int gap = ints.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap ; i < ints.length; i++) {
                int j = i;
                int temp = ints[j];
                while (j - gap >= 0 && temp < ints[j - gap]) {
                    //交换位置
                    ints[j] = ints[j - gap];
                    j = j - gap;
                }
                ints[j] = temp;
            }
        }
    }
}
