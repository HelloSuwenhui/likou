package SortTest02;

import sortTest.选泡插快归堆希桶计基;

import java.util.Arrays;
import java.util.Random;

public class check测试3 {
    public static void main(String[] args) {
        check();
    }

    private static void check() {
        Random random = new Random();
        int length = 100;//数组长度
        int times = 100;//次数
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

//            xuan.sort(arr2);
//            pao.sort(arr2);
            xi.sort(arr2);
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
