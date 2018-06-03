package firsov.Kirill;

import java.util.Random;
import java.util.Scanner;


public class Main {

    private static char[][] map;
    private static final int SIZE = 3;
    private static int DOTS_TO_WIN = 3;

    private static final char DOT_EMPTY = '\u2218';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';

    private static Scanner sc = new Scanner(System.in);
    private static Random rand = new Random();

    public static void main(String[] args) {
        initMap();
        printMap();
        while(true){
            humanTurn();
            printMap();
            if (checkWin(DOT_X)){
                System.out.println("Human wins");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)){
                System.out.println("Computer wins");
                break;
            }
            if (isMapFull()) {
                System.out.println("Draw");
                break;
            }
            }
            System.out.println("Game Over");
        }

    private static void initMap(){
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    private static void printMap(){
        for (int i = 0; i <= SIZE ; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i+1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void humanTurn(){
        int x, y;
        do{
            System.out.println("Enter XY");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        }while(!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    private static void aiTurn(){
        int x, y;
        int[] position;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        }while(!isCellValid(x, y));
        System.out.println("Computer did his turn");
        map[y][x] = DOT_O;
    }

    private static boolean isCellValid(int x, int y){
        if (x<0 || x >= SIZE || y < 0 || y >= SIZE) return false;
        return map[y][x] == DOT_EMPTY;
    }

    private static boolean checkWin(char symb){
        for (int i = 0; i < SIZE; i++) {
            if (map[i][0] == symb && map[i][0] == map[i][1] && map[i][0] == map[i][2]) return true;
            if (map[0][i] == symb && map[0][i] == map[1][i] && map[0][i] == map[2][i]) return true;
            if (map[i][i] == symb && map[i][i] == map[1][1] && map[i][i] == map[2][2]) return true;
            if (map[2][i] == symb && map[1][1] == symb && map[i][2] == symb) return true;
        }
        return false;
    }

    private static boolean isMapFull(){
        for (int i = 0; i < SIZE; i++) {
            for (int j=0; j < SIZE; j++){
                if (map[i][j] == DOT_EMPTY) return false;
            }
        }
        return true;
    }
}

