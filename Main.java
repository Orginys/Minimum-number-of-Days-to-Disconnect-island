class Solution{
    private int countIslands(int[][] grid){
        int count = 0;
        boolean [] [] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++){
            for (int j = 0 ; j < grid[0].length; j++){
                if (grid[i][j] == 1 && !visited[i][j]){
                    dfs(grid, visited, i,j);
                    count++;
                }
            }
        }
        return count;
    }
    private void dfs(int[][] grid, boolean[] [] visited, int i, int j){
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
        dfs(grid, visited, i - 1, j);
    }
    public int minDays(int[][] grid) {
        int initialIslands = countIslands(grid);
        if(initialIslands != 1){
            return 0;
        }
        for (int i = 0; i < grid.length; i++){
            for (int j = 0; j < grid[0].length; j++){
                if (grid[i][j] == 1){
                    grid[i][j] = 0;
                    if (countIslands(grid) != 1){
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }
}
