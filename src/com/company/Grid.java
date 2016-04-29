package com.company;

/**
 * Created by Clint on 29-4-2016.
 */
public class Grid {

    int[][] fields;
    int[][] emptyCellsList;
    int nEmptyCells;


    public Grid(int[][] puzzle, int size){
        this.fields = puzzle;
        this.emptyCellsList = new int[size*size][2];
        this.nEmptyCells = getEmptyCells();
    }

    private int getEmptyCells() {
        int i = 0;
        int numEmptyCells = 0;
        for (int r = 0; r < this.fields.length; r++) {
            for (int c = 0; c < this.fields[r].length; c++) {
                if (this.fields[r][c] == 0) {
                    this.emptyCellsList[i][0] = r;
                    this.emptyCellsList[i][1] = c;
                    numEmptyCells++;
                    i++;
                }
            }
        }
        return numEmptyCells;
    }

    public void display() {
        for (int r = 0; r < this.fields.length; r++) {
            if (r % 3 == 0) {
                System.out.println("+---+---+---+");
            }
            for (int c = 0; c < this.fields[r].length; c++) {
                if (c % 3 == 0) {
                    System.out.print("|");
                }

                if (this.fields[r][c] == 0) {
                    System.out.print('0');
                } else {
                    System.out.print(this.fields[r][c]);
                }
            }
            System.out.print("|");
            System.out.println();
        }
        System.out.println("+---+---+---+");
    }

}
