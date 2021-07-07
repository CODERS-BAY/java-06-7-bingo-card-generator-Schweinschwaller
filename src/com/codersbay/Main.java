package com.codersbay;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Random furtuna = new Random();
        final int bingoSize = 5;
        int[][] bingoSheet = new int[bingoSize][bingoSize];

        for (int i = 0; i < bingoSize; i++) {
            for (int j = 0; j < bingoSize; j++) {
                int rangeMin = 1;
                switch (i) {
                    case (1) -> rangeMin = 16;
                    case (2) -> rangeMin = 31;
                    case (3) -> rangeMin = 46;
                    case (4) -> rangeMin = 61;
                }
                int help;
                do {
                    help = furtunasChoise(furtuna, 15) + rangeMin;
                } while (!uniqueNr(bingoSheet, help));
                bingoSheet[j][i] = help;
            }
        }
        printBingo(bingoSheet);
    }

    public static int furtunasChoise(Random furtuna, int range) {
        return furtuna.nextInt(range);
    }

    public static boolean uniqueNr(int[][] bingoSheet, int nr) {
        for (int i = 0; i < bingoSheet.length; i++) {
            for (int j = 0; j < bingoSheet[0].length; j++) {
                if (bingoSheet[i][j] == nr) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void printBingo(int[][] bingoSheet) {
        System.out.println("-----BINGO----");
        for (int i = 0; i < bingoSheet.length; i++) {
            for (int j = 0; j < bingoSheet[0].length; j++) {
                if (j == 2 && i == 2) {
                    System.out.print("  |");
                } else if (j == bingoSheet[0].length - 1) {
                    System.out.printf("%2d", bingoSheet[i][j]);
                } else {
                    System.out.printf("%2d|", bingoSheet[i][j]);
                }
            }
            System.out.println();
        }
        System.out.println("--------------");
    }
}