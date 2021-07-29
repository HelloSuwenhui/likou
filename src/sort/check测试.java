package sort;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;

public class check测试 {
    public static void main(String[] args) {
        check();
    }

    private static void check() {
        Random random = new Random();
        int length = 10000;//数组长度
        int times = 1000;//次数
        long time = 0;//时间
        boolean result = true;
        for (int i = 0; i < times; i++) {
            int[] arr = new int[length];
            int randomInt;
            for (int j = 0; j < arr.length; j++) {
                randomInt = random.nextInt();
                arr[j] = randomInt;
            }
            int[] arr2 = new int[arr.length];
            System.arraycopy(arr, 0, arr2, 0, arr.length);

            Arrays.sort(arr);
            long start = System.currentTimeMillis();
//            选择.选择(arr2);
//            冒泡.冒泡(arr2);
//            插入.插入(arr2);
//            二分插入.二分插入(arr2);
//            快速.快速(arr2, 0, arr2.length - 1);
//            归并.归并(arr2, 0, arr2.length-1);
//            堆.堆排序(arr2);
//            希尔.希尔(arr2);
            long end = System.currentTimeMillis();
            time += (end - start);
            for (int j = 0; j < arr.length; j++) {
                if (arr[j] != arr2[j]) {
                    result = false;
                    System.out.println(Arrays.toString(arr));
                    System.out.println(Arrays.toString(arr2));
                    System.out.println(result);
                    return;
                }
            }
        }
        System.out.println(result);
        System.out.println(time);
    }
}
