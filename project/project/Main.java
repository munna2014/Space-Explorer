package project;


import java.util.Arrays;
import java.util.Scanner;

public class Main{
    public static final int BOARD_WIDTH = 100;
    public static final int BOARD_HEIGHT = 20;
    private static final int NUM_STONES = 7;
    public static String[][] board = new String[BOARD_HEIGHT][BOARD_WIDTH];
    public static boolean gameRunning;
    private Airplane airplane;

    public Main() {
        initializeBoard();
        airplane = new Airplane(4, BOARD_HEIGHT / 2);
        gameRunning = true;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);


        while (gameRunning) {
            printBoard();
           String ansi_color = "\u001B[0;33m";
            System.out.print(ansi_color + "Enter a direction (w= up)/(a= left)/(s= right)/(z= down) or 'q' to quit: ");
            String input = scanner.nextLine().toLowerCase();

            switch (input) {
                case "a":
                    airplane.move(-2, 0);
                    break;
                case "w":
                    airplane.move(0, -1);
                    break;
                case "s":
                    airplane.move(2, 0);
                    break;
                case "z":
                    airplane.move(0, 2);
                    break;
                case "q":
                    gameRunning = false;
                    break;
                default:
                    System.out.println("Invalid input! Please try again.");
                    break;
            }
            System.out.flush();
        }
        String ansicolor = "\u001B[0;31m";
        System.out.println(ansicolor+"Game over. Thanks for playing!");
    }

    public void initializeBoard() {
        Randomgenerator random = new Randomgenerator(System.currentTimeMillis());
        for (String[] row : board) Arrays.fill(row, " ");


        int x = random.generateRandomNumber(BOARD_WIDTH);
        int y = random.generateRandomNumber(BOARD_HEIGHT);
        System.out.println();


        x = Math.max(0, Math.min(x, BOARD_WIDTH -2));
        y = Math.max(0, Math.min(y, BOARD_HEIGHT -2));

        board[y][x] = "\uD83C\uDF0E";

        for (int i = 0; i < NUM_STONES; i++) {
            int stoneX;
            int stoneY;

            do {
                stoneX = random.generateRandomNumber(BOARD_WIDTH);
                stoneY = random.generateRandomNumber(BOARD_HEIGHT);

                stoneX = Math.max(0, Math.min(stoneX, BOARD_WIDTH -4));
                stoneY = Math.max(0, Math.min(stoneY, BOARD_HEIGHT -2));
            } while (!board[stoneY][stoneX].equals(" "));

            board[stoneY][stoneX] = "\uD83E\uDEA8";

        }
    }


    private void printBoard() {
        for (int i = 0; i < BOARD_WIDTH -52; i++) {
            System.out.print("\uD83C\uDF0C");
        }
        System.out.println();

        for (int i = 0; i < BOARD_HEIGHT; i++) {
            System.out.print("\uD83C\uDF0C");
            for (int j = 0; j < BOARD_WIDTH; j++) {
                System.out.print(board[i][j]);
            }
                System.out.println("\uD83C\uDF0C");
            }

        for (int i = 0; i < BOARD_WIDTH-52; i++) {
            System.out.print("\uD83C\uDF0C");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        try {
            Main game = new Main();
            game.play();
        }
        catch(Exception e){
            String ansicolor = "\u001B[0;31m";
            System.out.println(ansicolor+"Game Over!!!!");
        }
    }
}
