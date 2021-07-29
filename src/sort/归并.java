package sort;

import java.util.Arrays;

public class 归并 {
    public static void main(String[] args) {
    int[] ints = {5, 1, 5, 3, 5, 6, 8, 9, 0, 244, 54, 67, 3, 867, 454, 3453, 43, 23452352, 2342, 23452, 677567};

        归并(ints, 0, ints.length - 1);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] 归并(int[] ints, int min, int max) {
        if (ints.length < 2) {
            return ints;
        }
        int middle = (min + max) / 2;
        if (min < max) {
            //排序
            归并(ints, min, middle);
            归并(ints, middle + 1, max);
            合并(ints, min, middle, max);
        }
        return ints;
    }

    private static void 合并(int[] ints, int min, int mid, int max) {
        int i = min, j = mid + 1, k = 0;
        int[] temp = new int[max - min + 1];
        while (i <= mid && j <= max) {
            if (ints[i] < ints[j]) {
                //左小
                temp[k++] = ints[i++];
            } else {
                //右小
                temp[k++] = ints[j++];
            }
        }
        while (j <= max) {
            temp[k++] = ints[j++];
        }
        while (i <= mid) {
            temp[k++] = ints[i++];
        }
        for (int z = 0; z < temp.length; z++) {
            ints[min + z] = temp[z];
        }
    }


}
