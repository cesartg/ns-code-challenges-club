/*
 PROBLEM DESCRIPTION:
  An island is a set of true values linked vertically or horizontally.
 Note: true values can *NOT* be linked diagonally.
 i.e.
 1,0,0
 1,1,1
 1,0,1
 returns 1 island
 as
 1,
 1,1,1
 1, ,1 represents one island
 */

class IslandsProblem {
    static int islands(int[][] matrix) {
        if(matrix.length <= 0) {
            return -1;
        }
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        int numberOfIslands = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(visited[i][j]) {
                    continue;
                }
                if(matrix[i][j] == 1) {
                    numberOfIslands++;
                    visitNeighbors(matrix, visited, i, j);
                }
                visited[i][j] = true;
            }
        }
        return numberOfIslands;
    }

    private static void visitNeighbors(int[][] matrix, boolean[][] visited, int i, int j) {
        if(isOutOfBounds(matrix, i, j) || visited[i][j] || matrix[i][j] == 0) {
            return;
        }
        visited[i][j] = true;
        visitNeighbors(matrix, visited, i - 1, j);
        visitNeighbors(matrix, visited, i + 1, j);
        visitNeighbors(matrix, visited, i, j - 1);
        visitNeighbors(matrix, visited, i, j + 1);
    }

    private static boolean isOutOfBounds(int[][] matrix, int i, int j) {
        return i < 0 || i > matrix.length - 1 || j < 0 || j > matrix[0].length - 1;
    }
}
