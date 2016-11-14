/*
 Google Code Jam 2015 Round 2 (Pegman= 
  
 Problem

 While using Google Street View, you may have picked up and dropped the character Pegman before. Today, a mischievous user is going to place Pegman in some cell of a rectangular grid of unit cells with R rows and C columns. Each of the cells in this grid might be blank, or it might be labeled with an arrow pointing in one of four possible directions: up, right, down, or left.

 When Pegman is placed on a grid cell, if that cell is blank, Pegman stands still forever. However, if that cell has an arrow, Pegman starts to walk in that direction. As he walks, whenever he encounters a blank cell, he just keeps walking in his current direction, but whenever he encounters another arrow, he changes to the direction of that arrow and then keeps walking.

 You know that it is possible that Pegman might keep happily walking around and around the grid forever, but it is also possible that Pegman's walk will take him over the edge of the grid! You may be able to prevent this and save him by changing the direction of one or more arrows. (Each arrow's direction can only be changed to one of the other three possible directions; arrows can only be changed, not added or removed.)

 What is the smallest number of arrows you will need to change to ensure that Pegman will not walk off the edge, no matter where on the grid he is initially placed?

 
 Input

 The first line of the input gives the number of test cases, T. T test cases follow. Each begins with one line with two space-separated integers R, C. This line is followed by R lines, each of which has C characters, each of which describes a grid cell and is one of the following:

 . period = no arrow
 ^ caret = up arrow
 > greater than = right arrow
 v lowercase v = down arrow
 < less than = left arrow

 Output
 For each test case, output one line containing "Case #x: y", where x is the test case number (starting from 1) and y is the minimum number of arrows that must be changed to ensure that Pegman will not leave the grid no matter where he is initially placed, or the text IMPOSSIBLE if it is not possible to ensure this, no matter how many arrows you change.
 */

public class Pegman {
    private static final String INPUT_FILE = "A-small-practice.in";
    private static final String OUTPUT_FILE = "output.out";

    public static void main(String[] args) throws IOException {
        try (Scanner scanner = new Scanner(new File(INPUT_FILE)); FileWriter fw = new FileWriter(new File(OUTPUT_FILE))) {
            StringBuilder stringBuilder = new StringBuilder();
            int t = scanner.nextInt();
            for (int i = 1; i <= t; i++) {
                int r = scanner.nextInt();
                int c = scanner.nextInt();
                char[][] grid = new char[r][c];
                for (int j = 0; j < r; j++) {
                    grid[j] = scanner.next().toCharArray();
                }
                stringBuilder.append(String.format("Case #%d: %s\n", i, minimumMoves(grid)));
            }
            fw.write(stringBuilder.toString());
        }
    }

    private static String minimumMoves(char[][] grid) {
        Cell[][] cellGrid = buildCellGrid(grid);
        for (int i = 0; i < grid[0].length; i++) {
            Character firstArrow = null;
            int rowIndexLastArrow = -1;
            for (int j = 0; j < grid.length; j++) {
                if (grid[j][i] != '.') {
                    if (firstArrow == null) {
                        firstArrow = grid[j][i];
                        cellGrid[j][i].markAsFirstArrowFromColumn();
                    }
                    rowIndexLastArrow = j;
                }
            }
            if(rowIndexLastArrow >= 0) {
                cellGrid[rowIndexLastArrow][i].markAsLastArrowFromColumn();
            }
        }
        for (int i = 0; i < grid.length; i++) {
            Character firstArrow = null;
            int columnIndexLastArrow = -1;
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != '.') {
                    if (firstArrow == null) {
                        firstArrow = grid[i][j];
                        cellGrid[i][j].markAsFirstArrowFromRow();
                    }
                    columnIndexLastArrow = j;
                }
            }
            if(columnIndexLastArrow >= 0) {
                cellGrid[i][columnIndexLastArrow].markAsLastArrowFromRow();
            }
        }
        int minimumMoves = 0;
        for (Cell[] cellRow : cellGrid) {
            for(Cell cell : cellRow) {
                if(cell.isImpossibleToChange()) {
                    return "IMPOSSIBLE";
                }
                if(cell.shouldArrowShouldBeChanged()) {
                    minimumMoves++;
                }
            }
        }
        return Integer.toString(minimumMoves);
    }

    private static Cell[][] buildCellGrid(char[][] grid) {
        Cell[][] cellGrid = new Cell[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                cellGrid[i][j] = new Cell(grid[i][j]);
            }
        }
        return cellGrid;
    }

    private static class Cell {
        private char _arrow;
        private boolean _isFirstArrowFromColumn;
        private boolean _isLastArrowFromColumn;
        private boolean _isFirstArrowFromRow;
        private boolean _isLastArrowFromRow;

        Cell(char arrow) {
            _arrow = arrow;
        }

        void markAsFirstArrowFromColumn() {
            _isFirstArrowFromColumn = true;
        }

        void markAsLastArrowFromColumn() {
            _isLastArrowFromColumn = true;
        }

        void markAsFirstArrowFromRow() {
            _isFirstArrowFromRow = true;
        }

        void markAsLastArrowFromRow() {
            _isLastArrowFromRow = true;
        }

        boolean isImpossibleToChange() {
            return _isFirstArrowFromColumn && _isLastArrowFromColumn && _isFirstArrowFromRow && _isLastArrowFromRow;
        }

        boolean shouldArrowShouldBeChanged() {
            return (_isFirstArrowFromColumn && _arrow == '^') ||
                    (_isLastArrowFromColumn && _arrow == 'v') ||
                    (_isFirstArrowFromRow && _arrow == '<') ||
                    (_isLastArrowFromRow && _arrow == '>');
        }
    }
}
