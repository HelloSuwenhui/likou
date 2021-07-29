package sort;

import java.util.Arrays;

public class 基数 {
    public static void main(String[] args) {
        int[] ints = {5, 1, 5, 3, 5, 6, 8, 9, 1, 244, 54, 67, 3, 867, 454, 3453, 43, 20, 202, 645, 35};
        int[] ints2 = {5, 1, 5, 3, 5, 6, 8, 9, 1, 244, 54, 67, 3, 867, 454, 3453, 43, 20, 202, 645, 35};
        ints = 基数(ints, 3453);
        System.out.println(Arrays.toString(ints));
        Arrays.sort(ints2);
        System.out.println(Arrays.toString(ints2));
    }

    public static int[] 基数(int[] ints, int max) {
        int weishu = String.valueOf(max).length();
        int[] result = new int[ints.length];
        for (int i = 0; i < weishu; i++) {
            int[] count = new int[10];
            double pow = Math.pow(10, i);
            for (int j = 0; j < ints.length; j++) {
                int yushu = (ints[j] / new Double(pow).intValue()) % 10;
                count[yushu]++;
            }
            for (int j = 1; j < count.length; j++) {
                count[j] = count[j] + count[j - 1];
            }
            for (int j = ints.length - 1; j >= 0; j--) {
                int anInt = (ints[j] / new Double(pow).intValue()) % 10;
                result[--count[anInt]] = ints[j];
            }
            System.arraycopy(result, 0, ints, 0, result.length);
        }
        return result;
    }
}
