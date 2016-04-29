package com.company;

public class Main {

    public static void main(String[] args) {

        final int SIZE = 9;

        int[][] puzzle  = { {2,0,0,0,0,7,0,9,0},
                {0,3,0,0,2,0,0,0,8},
                {0,0,9,6,0,0,5,0,0},
                {0,0,5,3,0,0,9,0,0},
                {0,1,0,0,8,0,0,0,2},
                {6,0,0,0,0,4,0,0,0},
                {3,0,0,0,0,0,0,1,0},
                {0,4,0,0,0,0,0,0,7},
                {0,0,7,0,0,0,3,0,0}
        };


        Grid grid = new Grid(puzzle,SIZE);

        boolean solved = SudokuSolver.solve(grid);

        if (solved) {
            System.out.println("has been solved:");
            grid.display();
        } else {
            System.out.println("cannot be solved!");
        }


    }
}
