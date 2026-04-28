class Solution {
    public int orangesRotting(int[][] g) {
        Queue<int[]> q = new LinkedList<>();
        int fresh = 0, time = 0;

        for (int i = 0; i < g.length; i++)
            for (int j = 0; j < g[0].length; j++) {
                if (g[i][j] == 2) q.offer(new int[]{i, j});
                if (g[i][j] == 1) fresh++;
            }

        int[] d = {0,1,0,-1,0};

        while (!q.isEmpty() && fresh > 0) {
            time++;
            for (int s = q.size(); s > 0; s--) {
                int[] c = q.poll();
                for (int k = 0; k < 4; k++) {
                    int x = c[0] + d[k], y = c[1] + d[k+1];
                    if (x>=0 && y>=0 && x<g.length && y<g[0].length && g[x][y]==1) {
                        g[x][y] = 2;
                        q.offer(new int[]{x,y});
                        fresh--;
                    }
                }
            }
        }
        return fresh == 0 ? time : -1;
    }
}
