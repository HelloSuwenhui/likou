import java.util.Arrays;
import java.util.PriorityQueue;

public class Test {
    public static void main(String[] args) {
        int a = 5;
        System.out.println(1 << a);
        PriorityQueue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        heap.add(4);
        heap.add(0);
        heap.add(14);
        heap.add(343);
        heap.add(55);
        heap.add(12);
        Object[] objects = heap.toArray();
        System.out.println(Arrays.toString(objects));

        while (!heap.isEmpty()) {
            System.out.println(heap.poll());
        }

    }
}
