public class 机器人 {
    public static void main(String[] args) {
        /**
         * 机器人在1到N的位置上，
         * 在1的位置只能跳到2，在N的位置只能跳到N-1，其他位置可以往左或者往右跳，
         * 从start的位置跳step步到end位置的不同跳法有多少种？
         */
        int num = getNumbefore(7, 3, 6, 13);
        System.out.println(num);
    }

    private static int getNumbefore(int n, int start, int end, int step) {
        int[][] map = new int[n][step];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < step; j++) {
                map[i][j] = -1;
            }
        }
        return getNum(n, start, end, step, map);
    }


    private static int getNum(int n, int start, int end, int step, int[][] map) {
        if (step == 0) {
            return start == end ? 1 : 0;
        }
        if (start == 1) {
            if (map[1][step - 1] == -1) {
                map[1][step - 1] = getNum(n, 2, end, step - 1, map);
            }
            return map[1][step - 1];
        } else if (start == n) {
            if (map[n - 2][step - 1] == -1) {
                map[n - 2][step - 1] = getNum(n, n - 1, end, step - 1, map);
            }
            return map[n - 2][step - 1];
        } else {
            if (map[start - 2][step - 1] == -1) {
                map[start - 2][step - 1] = getNum(n, start - 1, end, step - 1, map);
            }
            if (map[start][step - 1] == -1) {
                map[start][step - 1] = getNum(n, start + 1, end, step - 1, map);
            }
            return  map[start - 2][step - 1] +
                    map[start][step - 1];
        }
    }
}
