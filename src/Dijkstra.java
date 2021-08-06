import java.util.*;
import java.util.stream.Collectors;

public class Dijkstra {
    public static void main(String[] args) {

        int[][] graph = new int[][]{
                {0, 1, 6, 7, -1},
                {-1, 0, 2, -1, 107},
                {-1, -1, 0, 2, 8},
                {-1, -1, -1, 0, 4},
                {-1, -1, -1, -1, 0}
        };
        Integer dijkstra2 = Dijkstra2(graph, 0, 5);
        System.out.println("-----------------------");
        System.out.println(dijkstra2);
        System.out.println("-----------------------");


        Integer dijkstra = Dijkstra(graph, 0, 5);
        System.out.println("-----------------------");
        System.out.println(dijkstra);

    }

    private static Integer Dijkstra2(int[][] graph, int from, int end) {
        //堆
        PriorityQueue<MyNode> nodes = new PriorityQueue<>(Comparator.comparingInt(MyNode::getCost));
        int[] visit = new int[graph.length];

        nodes.add(new MyNode(from, 0));

        while (!nodes.isEmpty()) {
            MyNode pollNode = nodes.poll();
            if (pollNode.getNode() == end) {
                return pollNode.getCost();
            }
            if (visit[pollNode.getNode()] == 0) {
                visit[pollNode.getNode()] = -1;
                for (int i = 0; i < graph.length; i++) {
                    if (graph[pollNode.getNode()][i] != -1 && visit[i] != -1) {
                        nodes.add(new MyNode(i, pollNode.getCost() + graph[pollNode.getNode()][i]));
                    }
                }
            }
        }
        return -1;
    }

//===========================================================================

    public static Integer Dijkstra(int[][] graph, int from, int end) {
        HashMap<Integer, Integer> distance = new HashMap<>();
        HashSet<Integer> selected = new HashSet<>();

        distance.put(from, 0);
        int chooseNode = 1;
        while (chooseNode >= 0) {
            chooseNode = getNoSelectNode(selected, distance);
            if (chooseNode != -1) {
                System.out.println(chooseNode);
                int[] ints = graph[chooseNode];
                for (int i = 0; i < graph.length; i++) {
                    if (ints[i] != -1) {
                        if (distance.get(i) != null) {
                            distance.put(i, Math.min(distance.get(chooseNode) + ints[i], distance.get(i)));
                        } else {
                            distance.put(i, distance.get(chooseNode) + ints[i]);
                        }
                    }
                }
                selected.add(chooseNode);
            }
        }

        return distance.get(end)==null?-1:distance.get(end);
    }

    private static int getNoSelectNode(HashSet<Integer> selected, HashMap<Integer, Integer> distance) {
        Set<Integer> integers = distance.keySet();
        List<Integer> chooseList = integers.stream().filter(i -> !selected.contains(i)).collect(Collectors.toList());
        if (chooseList.isEmpty()) {
            return -1;
        }
        int minDis = distance.get(chooseList.get(0));
        int choose = chooseList.get(0);
        for (Integer integer : chooseList) {
            Integer dis = distance.get(integer);
            if (dis < minDis) choose = integer;
        }
        return choose;
    }


}
