public class 套圆环 {
    public static void main(String[] args) {
        套("右柱子", "左柱子", "中柱子", 10);
    }

    private static void 套(String from, String to, String other, int n) {
        if (n == 1) {
            System.out.println("把第" + n + "个圆环从" + from + "拿到" + to);
            return;
        }
        套(from, other, to, n - 1);
        System.out.println("把第" + n + "个圆环从" + from + "拿到" + to);
        套(other, to, from, n - 1);
    }
}
