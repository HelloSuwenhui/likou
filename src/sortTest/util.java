package sortTest;

import java.util.Arrays;

public class util {
    public static void main(String[] args) {
        int[] a = {1, 2};
        swag(a,1,0);
        System.out.println(Arrays.toString(a));
    }
    public static void swag(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
