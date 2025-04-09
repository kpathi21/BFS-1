import java.util.*;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for (int[] pr : prerequisites) { //TC: O(E) - edges
            //pr[0] - dependent, pr[1] - independent
            indegrees[pr[0]]++;
            map.putIfAbsent(pr[1], new ArrayList<>());
            map.get(pr[1]).add(pr[0]);
        }

        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < indegrees.length; i++) { //O(E)
            if (indegrees[i] == 0) {
                q.add(i);
                count++;
            }
        }

        if (q.isEmpty()) //cycle
            return false;

        if (count == numCourses)
            return true;

        while (!q.isEmpty()) { //TC: O(V+E) - vertices + edges
            int curr = q.poll();
            List<Integer> dependents = map.get(curr);

            if (dependents != null) {
                for (int dependent : dependents) {
                    indegrees[dependent]--;
                    if (indegrees[dependent] == 0) {
                        q.add(dependent);
                        count++;
                    }

                    if (count == numCourses)
                        return true;
                }
            }

        }
        return false;
    }
}

//TC: O(V+E)
//SC: O(V+E)
