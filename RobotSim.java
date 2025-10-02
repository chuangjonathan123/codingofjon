import java.util.*;


public class RobotSim {
    public static void main(String[] args) {
        Grid grid = new Grid(12, 12);
        grid.addRandomObstacles(18, 42); 
        Position charger = new Position(1, 1);
        Robot robot = new Robot("R2-Java", new Position(1, 1), charger, grid);

        int steps = 0;
        while (steps < 300) {
            System.out.println("\n=== Step " + steps + " ===");
            grid.print(robot);
            robot.step();
            if (robot.isShutdown()) {
                System.out.println("Robot shutdown (battery empty). Simulation ends.");
                break;
            }
            steps++;
            try { Thread.sleep(120); } catch (InterruptedException e) {}
        }
        System.out.println("\nSimulation finished. Final robot state:");
        grid.print(robot);
    }

   
    static class Position {
        int r, c;
        Position(int r, int c) { this.r = r; this.c = c; }
        @Override public boolean equals(Object o){
            if (!(o instanceof Position)) return false;
            Position p = (Position)o; return p.r==r && p.c==c;
        }
        @Override public int hashCode(){ return Objects.hash(r,c); }
        @Override public String toString(){ return "(" + r + "," + c + ")"; }
    }

    static class Grid {
        final int rows, cols;
        boolean[][] obstacle;
        Random rng;

        Grid(int rows, int cols) {
            this.rows = rows; this.cols = cols;
            obstacle = new boolean[rows][cols];
            rng = new Random();
        }

        boolean inside(Position p) {
            return p.r >= 0 && p.r < rows && p.c >= 0 && p.c < cols;
        }

        boolean isFree(Position p) {
            return inside(p) && !obstacle[p.r][p.c];
        }

        void setObstacle(int r, int c, boolean val) {
            if (r>=0 && r<rows && c>=0 && c<cols) obstacle[r][c]=val;
        }

        void addRandomObstacles(int count, long seed) {
            rng = new Random(seed);
            int placed = 0;
            while (placed < count) {
                int r = rng.nextInt(rows);
                int c = rng.nextInt(cols);
                if (!obstacle[r][c] && !(r==0 && c==0)) {
                    obstacle[r][c] = true;
                    placed++;
                }
            }
        }

        void print(Robot robot) {
            for (int r=0;r<rows;r++){
                for (int c=0;c<cols;c++){
                    Position p = new Position(r,c);
                    if (robot.pos.equals(p)) System.out.print("R ");
                    else if (robot.charger.equals(p)) System.out.print("C ");
                    else if (obstacle[r][c]) System.out.print("# ");
                    else System.out.print(". ");
                }
                System.out.println();
            }
            System.out.printf("Robot pos=%s battery=%.1f%% mode=%s\n",
                    robot.pos, robot.getBatteryPercent(), robot.mode);
        }
    }

    enum Mode { EXPLORING, RETURNING, CHARGING }

    static class Robot {
        final String id;
        Position pos;
        final Position charger;
        final Grid grid;

        double battery = 100.0;

        Mode mode = Mode.EXPLORING;
        Random rng = new Random(13);

        static final int[][] DIRS = { {-1,0}, {1,0}, {0,-1}, {0,1} };

        LinkedList<Position> currentPath = new LinkedList<>();

        Robot(String id, Position start, Position charger, Grid grid) {
            this.id = id; this.pos = start; this.charger = charger; this.grid = grid;
        }

        void step() {
            if (pos.equals(charger)) {
                mode = Mode.CHARGING;
                charge();
                return;
            }

            if (battery < 25.0 && mode != Mode.RETURNING) {
                System.out.println("Battery low -> planning return to charger.");
                mode = Mode.RETURNING;
                planPathTo(charger);
            }

            switch (mode) {
                case EXPLORING:
                    exploreStep();
                    break;
                case RETURNING:
                    followPathStep();
                    break;
                case CHARGING:
                    break;
            }

            battery -= 0.05;
            battery = Math.max(0.0, battery);
            if (battery <= 0.0) {
                System.out.println("Battery exhausted!");
            }
        }

        boolean isShutdown() { return battery <= 0.0; }

        double getBatteryPercent() { return battery; }

        int distanceSensor(int dirIndex, int maxRange) {
            int[] d = DIRS[dirIndex];
            int distance = 0;
            Position p = new Position(pos.r, pos.c);
            for (int i = 1; i <= maxRange; i++) {
                p = new Position(p.r + d[0], p.c + d[1]);
                if (!grid.inside(p) || grid.obstacle[p.r][p.c]) break;
                distance++;
            }
            return distance;
        }

        void exploreStep() {
            int dir = rng.nextInt(DIRS.length);
            int dist = distanceSensor(dir, 1); 
            if (dist > 0 && tryMove(dir)) {
            } else {
                boolean moved = false;
                for (int i = 0; i < DIRS.length; i++) {
                    if (tryMove(i)) { moved = true; break; }
                }
                if (!moved) {
                    System.out.println("Surrounded! staying put this step.");
                }
            }
            battery -= 0.5; 
        }

        boolean tryMove(int dirIndex) {
            int nr = pos.r + DIRS[dirIndex][0];
            int nc = pos.c + DIRS[dirIndex][1];
            Position np = new Position(nr, nc);
            if (grid.isFree(np)) {
                pos = np;
                return true;
            }
            return false;
        }

        // Plan a shortest path (BFS) to a target
        void planPathTo(Position target) {
            Queue<Position> q = new ArrayDeque<>();
            Map<Position, Position> parent = new HashMap<>();
            q.add(pos);
            parent.put(pos, null);

            Position found = null;
            while (!q.isEmpty()) {
                Position cur = q.poll();
                if (cur.equals(target)) { found = cur; break; }
                for (int[] d : DIRS) {
                    Position np = new Position(cur.r + d[0], cur.c + d[1]);
                    if (!grid.isFree(np)) continue;
                    if (parent.containsKey(np)) continue;
                    parent.put(np, cur);
                    q.add(np);
                }
            }

            currentPath.clear();
            if (found == null) {
                System.out.println("No path found to target! I'll attempt greedy moves.");
                greedyStepTowards(target);
                return;
            }

            Position cur = found;
            LinkedList<Position> rev = new LinkedList<>();
            while (cur != null && !cur.equals(pos)) {
                rev.add(cur);
                cur = parent.get(cur);
            }
            Collections.reverse(rev);
            currentPath.addAll(rev);
            System.out.println("Planned path of length " + currentPath.size());
        }

        void followPathStep() {
            if (currentPath.isEmpty()) {
                System.out.println("Path exhausted or not available. Switching to exploring.");
                mode = Mode.EXPLORING;
                return;
            }
            Position next = currentPath.pollFirst();
            if (grid.isFree(next)) {
                pos = next;
                battery -= 0.4;
            } else {
                System.out.println("Path blocked by new obstacle — replanning.");
                planPathTo(charger);
            }
        }

        void greedyStepTowards(Position target) {
            int dr = Integer.compare(target.r, pos.r);
            int dc = Integer.compare(target.c, pos.c);
            Position try1 = new Position(pos.r + dr, pos.c);
            Position try2 = new Position(pos.r, pos.c + dc);
            if (grid.isFree(try1)) { pos = try1; battery -= 0.4; }
            else if (grid.isFree(try2)) { pos = try2; battery -= 0.4; }
            else {
                for (int i=0;i<DIRS.length;i++){
                    if (tryMove(i)) break;
                }
            }
        }

        void charge() {
            battery += 6.0;
            if (battery >= 100.0) {
                battery = 100.0;
                mode = Mode.EXPLORING;
                System.out.println("Fully charged. Switching to EXPLORING.");
            } else {
                System.out.printf("Charging... battery now %.1f%%\n", battery);
            }
        }
    }
}
