import java.util.*;

public class Task5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int m = scanner.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            int u = scanner.nextInt();
            int v = scanner.nextInt();
            int w = scanner.nextInt();
            edges.add(new Edge(u, v, w));
        }

        Collections.sort(edges, Comparator.comparingInt(e -> e.w));

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int maxWeight = 0;
        int numComponents = n;

        for (int i = m - 1; i >= 0; i--) {
            if (numComponents == 1) {
                break;
            }

            Edge edge = edges.get(i);
            int u = edge.u;
            int v = edge.v;
            int w = edge.w;

            int pu = find(parent, u);
            int pv = find(parent, v);

            if (pu != pv) {
                parent[pu] = pv;
                maxWeight = w;
                numComponents--;
            }
        }

        System.out.println(maxWeight - 1);
    }

    static int find(int[] parent, int node) {
        if (node != parent[node]) {
            parent[node] = find(parent, parent[node]);
        }
        return parent[node];
    }

    static class Edge {
        int u, v, w;

        Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
}
