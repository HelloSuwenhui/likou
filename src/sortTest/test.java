package sortTest;

import java.sql.SQLOutput;
import java.util.Optional;

public class test {
    public static void main(String[] args) {
        /*
         题目：一个数如果恰好等于它的因子之和，这个数就称为"完数"。
         例如6=1＋2＋3.编程找出1000以内的所有完数。
         */
        boolean flag = true;
        for (int i = 1; i <= 1000; i++) {//取值1~1000内的值
            String s = i + " = ";
            int coun = 0;//赋值最后取整；
            for (int m = 1; m < i; m++) {//取因子的取值范围
                if (i % m == 0) {
                    if (flag) {
                        s += m;
                        flag = false;
                    } else {
                        s += " + " + m;
                    }
                    coun += m;
                }
            }
            if (i == coun) {
                System.out.println(s);
                int b = 6 & (~4);
                System.out.println(b);
            }
            //
        }
    }
}
