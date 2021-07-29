public class N皇后 {
    public static void main(String[] args) {
        //回溯
        for (int i = 1; i < 11; i++) {
            int num1 = getNum(i);
            System.out.println(i + "---->" + num1);
        }
        System.out.println("位运算-------------------------------");
        //位运算
        for (int i = 1; i < 11; i++) {
            int num1 = getNum2(i);
            System.out.println(i + "---->" + num1);
        }

    }

    private static int getNum2(int i) {
        int limit = (1 << i) - 1;
        return getNum2(limit, 0, 0, 0);
    }

    private static int getNum2(int limit, int hang, int left, int right) {
        if (hang == limit) {
            //摆好了
            return 1;
        }
        //可以摆放的位置
        int canPut = limit & (~(hang | left | right));
        int result = 0;
        while (canPut != 0) {
            //有位置可以摆放
            //摆放在最右的位置
            int putLastRight = (~canPut + 1) & canPut;
//            canPut -= putLastRight;
//            canPut = canPut & (~putLastRight);
            canPut = canPut ^ putLastRight;
            int num2 = getNum2(limit, (putLastRight | hang), (putLastRight | left) << 1, (putLastRight | right) >>> 1);
            result += num2;
        }
        return result;
    }

    private static int getNum(int n) {
        //        数组 记录每行皇后的排放位置
        int[] yibaifan = new int[n];
        return getNum(yibaifan, 0);
    }

    private static int getNum(int[] yibaifan, int hangshu) {
        if (hangshu == yibaifan.length) {
            //摆完最后一行
            return 1;
        }
        int result = 0;
        for (int i = 0; i < yibaifan.length; i++) {
            //循环排放尝试
            //将皇后排在i位置
            yibaifan[hangshu] = i;
            //如果不冲突
            if (isVaild(yibaifan, hangshu)) {
                int num = getNum(yibaifan, hangshu + 1);
                result += num;
            }
        }
        return result;
    }

    private static boolean isVaild(int[] yibaifan, int hangshu) {
        for (int j = 0; j < hangshu; j++) {
            if (yibaifan[j] == yibaifan[hangshu] || Math.abs(hangshu - j) == Math.abs(yibaifan[hangshu] - yibaifan[j])) {
                //是同一列或者斜
                return false;
            }
        }
        return true;
    }
}
