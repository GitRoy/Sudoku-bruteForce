package com.company;

/**
 * Created by Clint on 29-4-2016.
 */
 public class SudokuSolver {

    public static boolean solve(Grid grid) {
        int i = 0;
        int currentCellNum = 0;

        int[][] emptyCells = grid.emptyCellsList;
        int[][] fields = grid.fields;

        while (i < grid .nEmptyCells) {
            currentCellNum = fields[emptyCells[i][0]][emptyCells[i][1]];
            if (currentCellNum != 9) {
                currentCellNum++;
                fields[emptyCells[i][0]][emptyCells[i][1]] = currentCellNum;
                if (isConsistent(fields, emptyCells[i][0], emptyCells[i][1])) {
                    i++;
                }
            } else {
                currentCellNum = 0;
                fields[emptyCells[i][0]][emptyCells[i][1]] = currentCellNum;
                i--;
                if (i < 0) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean hasNoDuplicates(int[] digitsList) {
        for (int j = 0; j < digitsList.length; j++) {
            for (int k = j + 1; k < digitsList.length; k++) {
                if (digitsList[j] == digitsList[k] && digitsList[j] != 0)
                    return false;
            }
        }
        return true;
    }

    private static boolean checkCurrentRow(int[][] grid, int currentRow) {
        int[] digitsList = new int[grid.length];
        for (int c = 0; c < digitsList.length; c++) {
            digitsList[c] = grid[currentRow][c];
        }
        if (hasNoDuplicates(digitsList)) {
            return true;
        }
        return false;
    }

    private static boolean checkCurrentCol(int[][] grid, int currentCol) {
        int[] digitsList = new int[grid.length];
        for (int i = 0; i < digitsList.length;  i++) {
            digitsList[i] = grid[i][currentCol];
        }
        if (hasNoDuplicates(digitsList)) {
            return true;
        }
        return false;
    }

    private static boolean checkCurrentRegion(int[][] grid, int currentRow, int currentCol) {
        int[] digitsList = new int[grid.length];
        currentRow = (currentRow / 3) * 3;
        currentCol = (currentCol / 3) * 3;
        int i = 0;
        for (int r = 0; r < 3; r++) {
            for (int c = 0; c < 3; c++) {
                digitsList[i] = grid[currentRow + r][currentCol + c];
                i++;
            }
        }
        if (hasNoDuplicates(digitsList)) {
            return true;
        }
        return false;
    }

    public static boolean isConsistent(int[][] grid, int currentRow, int currentCol) {
        boolean checkRow = checkCurrentRow(grid, currentRow);
        boolean checkCol = checkCurrentCol(grid, currentCol);
        boolean checkReg = checkCurrentRegion(grid, currentRow, currentCol);

        if (checkRow && checkCol && checkReg) {
            return true;
        }
        return false;
    }
}
