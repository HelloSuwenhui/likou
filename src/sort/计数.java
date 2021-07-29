package sort;

import java.util.Arrays;

public class 计数 {
    public static void main(String[] args) {
        int[] ints = {5, 1, 5, 3, 5, 6, 8, 9, 1, 244, 54, 67, 3, 867, 454, 3453, 43, 20, 202, 645, 35};
        int[] ints2 = {5, 1, 5, 3, 5, 6, 8, 9, 1, 244, 54, 67, 3, 867, 454, 3453, 43, 20, 202, 645, 35};
        ints = 计数(ints, 1, 3453);
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints2);
        System.out.println(Arrays.toString(ints2));
    }

    public static int[] 计数(int[] ints, int min, int max) {
        int[] result = new int[ints.length];
        int[] arr = new int[max - min + 1];
        for (int i = 0; i < ints.length; i++) {
            arr[ints[i] - min]++;
        }
        //不稳定排序
        /*for (int i = 0, k = 0; i < arr.length; i++) {
            while (arr[i]-- != 0) {
                result[k++] = i + min;
            }
        }*/
        //稳定排序 存放-->从数量变成位置(第几个)
        for (int i = 1; i < arr.length; i++) {
            arr[i] = arr[i] + arr[i - 1];
        }
        for (int i = ints.length - 1; i >= 0; i--) {
            result[--arr[ints[i] - min]] = ints[i];
        }
        return result;
    }
}
