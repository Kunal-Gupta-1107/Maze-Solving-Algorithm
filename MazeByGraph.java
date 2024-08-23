import java.util.ArrayList;
import java.util.Arrays;

public class MazeByGraph {
    static int node = 16;
    static int[][] Graph = new int[node][node];

    static void findPath(int source, int destination, boolean[] visit, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> allPath) {
        visit[source] = true;
        path.add(source);

        if (source == destination) {
            allPath.add(new ArrayList<>(path));
        } else {
            for (int i = 0; i < node; i++) {
                if (Graph[source][i] == 1 && !visit[i]) {
                    findPath(i, destination, visit, path, allPath);
                }
            }
        }

        path.remove(path.size() - 1); 
        visit[source] = false;
    }

    static void countWays(int source, int destination) {
        boolean[] visit = new boolean[node];
        ArrayList<Integer> path = new ArrayList<>();
        ArrayList<ArrayList<Integer>> allPath = new ArrayList<>();

        findPath(source, destination, visit, path, allPath);

        if (allPath.isEmpty()) {
            System.out.println("No possible path found, the maze might be wrong.");
        } else {
            System.out.println("All possible paths from " + source + " to " + destination + ":");
            for (ArrayList<Integer> p : allPath) {
                System.out.println(p);
            }
        }
    }

    public static void main(String[] args) {
        Graph = new int[][] {
            {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 1, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 0, 0, 1},
            {0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 1},
            {0, 0, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0}
        };

        countWays(0, 15); 
    }
}
