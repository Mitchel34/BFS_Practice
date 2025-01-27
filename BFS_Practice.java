import java.util.*;

class Node {
    private String name;
    private int priority; // Could represent cost, heuristic, or both

    public Node(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Node{" +
                "name='" + name + '\'' +
                ", priority=" + priority +
                '}';
    }
}

public class BFS_Practice {

    public static void main(String[] args) {
        // Create some sample nodes
        Node start = new Node("Start", 5);
        Node a = new Node("A", 3);
        Node b = new Node("B", 2);
        Node goal = new Node("Goal", 1);

        // PriorityQueue with a custom comparator that sorts by Node's priority (ascending)
        PriorityQueue<Node> frontier = new PriorityQueue<>(Comparator.comparingInt(Node::getPriority));

        // HashMap for demonstration, though for visited states a HashSet is often enough
        HashMap<String, Node> visited = new HashMap<>();

        // Add initial nodes to the frontier (in a real scenario, you’d add neighbors as you search)
        frontier.offer(start);
        frontier.offer(a);
        frontier.offer(b);
        frontier.offer(goal);

        System.out.println("=== Best First Search Simulation ===");
        while (!frontier.isEmpty()) {
            Node current = frontier.poll();  // Retrieves and removes the highest-priority (lowest cost) node

            // Check if we've visited this node before
            if (visited.containsKey(current.getName())) {
                System.out.println("Already visited: " + current);
                continue;
            }

            // Mark current as visited
            visited.put(current.getName(), current);
            System.out.println("Expanding: " + current);

            // Check if current is the goal node
            if ("Goal".equals(current.getName())) {
                System.out.println("Reached the goal!");
                break;
            }

            // In a real Best First Search, we’d now find neighbors of 'current' 
            // and insert them into the frontier if they're not visited, e.g.:
            // for (Node neighbor : getNeighbors(current)) {
            //     if (!visited.containsKey(neighbor.getName())) {
            //         frontier.offer(neighbor);
            //     }
            // }
        }

        System.out.println("\n=== Visited Nodes ===");
        for (Node node : visited.values()) {
            System.out.println(node);
        }
    }
}
