package sort;

import java.util.Arrays;

public class 快速 {
    public static void main(String[] args) {
      int[] ints = {5, 1, 5, 3, 5, 6, 8, 9, 0, 244, 54, 67, 3, 867, 454, 3453, 43, 23452352, 2342, 23452, 677567};
//        int[] ints = {5, 1, 5, 3};
        快速(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    public static void 快速(int[] ints, int minIndex, int maxIndex) {
        if (minIndex < maxIndex) {
            int index = getIndex(ints, minIndex, maxIndex);
            快速(ints, minIndex, index-1);
            快速(ints, index + 1, maxIndex);
        }

    }

    private static int getIndex(int[] ints, int minIndex, int maxIndex) {
        int temp = ints[minIndex];
        while (minIndex < maxIndex) {
            while (minIndex < maxIndex && ints[maxIndex] >= temp) {
                maxIndex--;
            }
            ints[minIndex] = ints[maxIndex];
            while (minIndex < maxIndex && ints[minIndex] <= temp) {
                minIndex++;
            }
            ints[maxIndex] = ints[minIndex];
        }
        ints[minIndex] = temp;
        return minIndex;
    }
}
