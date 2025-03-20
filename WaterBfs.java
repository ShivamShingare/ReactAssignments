import java.util.*;

public class WaterBfs {

    static boolean check_possible(int x, int y, int X, int Y) {
        return x >= 0 && x <= X && y >= 0 && y <= Y;
    }

    public static void automatic(int X, int Y, int Z) {
        Queue<int[]> queue = new LinkedList<>();
        Map<String, String> parentMap = new HashMap<>();

        queue.add(new int[]{0, 0}); 
        parentMap.put("0,0", null);

        System.out.println("BFS Traversal Tree:");
        System.out.println("(Current State -> Next State)");

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];

            // Print current state
            String currentState = stateToString(x, y);

            if (x == Z || y == Z) {
                System.out.println("Goal reached!");
                printSteps(x, y, parentMap);
                return;
            }

            for (int[] next : getNextStates(x, y, X, Y)) {
                String nextKey = stateToString(next[0], next[1]);
                if (!parentMap.containsKey(nextKey)) {
                    parentMap.put(nextKey, currentState); 
                    queue.add(next); 

                    // Print BFS tree node
                    System.out.println(currentState + " -> " + nextKey);
                }
            }
        }

        System.out.println("No solution found.");
    }

    private static List<int[]> getNextStates(int x, int y, int X, int Y) {
        List<int[]> states = new ArrayList<>();
        states.add(new int[]{X, y}); 
        states.add(new int[]{x, Y}); 
        states.add(new int[]{0, y}); 
        states.add(new int[]{x, 0}); 
        states.add(new int[]{x - Math.min(x, Y - y), y + Math.min(x, Y - y)}); 
        states.add(new int[]{x + Math.min(y, X - x), y - Math.min(y, X - x)}); 
        return states;
    }

    private static void printSteps(int goalX, int goalY, Map<String, String> parentMap) {
        Stack<String> steps = new Stack<>();
        String currentState = stateToString(goalX, goalY);

        while (currentState != null) {
            steps.push(currentState);
            currentState = parentMap.get(currentState);
        }

        while (!steps.isEmpty()) {
            String[] parts = steps.pop().split(",");
            int x = Integer.parseInt(parts[0]);
            int y = Integer.parseInt(parts[1]);
            System.out.println("Jug 1 = " + x + ", Jug 2 = " + y);
        }
    }

    private static String stateToString(int x, int y) {
        return x + "," + y;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Jug 1 capacity:");
        int X = sc.nextInt();
        System.out.println("Jug 2 capacity:");
        int Y = sc.nextInt();
        System.out.println("Enter final amount:");
        int Z = sc.nextInt();

        // Directly call BFS solution
        automatic(X, Y, Z);

        sc.close();
    }
}