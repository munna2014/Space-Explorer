package project;

import static project.Main.*;
import java.util.Scanner;

public class Airplane {
    public int x;
    private int y;

    public Airplane(int x, int y) {
        this.x = x;
        this.y = y;
        updateBoard();
    }

    public void move(int dx, int dy) {
        board[y][x] = " ";
        board[y][x - 1] = " ";
        board[y][x - 2] = " ";
        board[y][x - 3] = " ";
        board[y][x - 4] = " ";
        board[y - 1][x - 3] = " ";
        board[y - 1][x - 4] = " ";
        board[y + 1][x - 3] = " ";
        board[y + 1][x - 4] = " ";

      int newX = x + dx;
       int newY = y + dy;

        if(collisionDetectedEarth(newX,newY)){
            System.out.println("Win");
            Main.gameRunning = false; // Set the gameRunning flag to false to end the game
            System.out.println("Do you want to play again[1,0] :");
            Scanner sc =new Scanner(System.in);
            int f= sc.nextInt();
            if(f==1){
                Main game=new Main();
                game.play();
            }
            else{
                System.out.println("Thanks for playing.");
            }

        }
       if (!collisionDetected(newX, newY)) {
            clearPreviousPosition();
            x = newX;
            y = newY;
            updateBoard();
        }

        else
        {
            String ansicolor = "\u001B[0;31m";
            System.out.println(ansicolor+"Collision detected! Game over.");
            Main.gameRunning = false; // Set the gameRunning flag to false to end the game
            System.out.println("Do you want to play again[1,0] :");
            Scanner sc =new Scanner(System.in);
            int f= sc.nextInt();
            if(f==1){
                Main game=new Main();
                game.play();
            }
            else{
                System.out.println("Thanks for playing.");
            }
        }

        updateBoard();
    }

    private void clearPreviousPosition() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void updateBoard() {
        board[y][x] =">";
        board[y][x - 1] =">";
        board[y][x - 2] ="=";
        board[y][x - 3] ="=";
        board[y][x - 4] ="=";
        board[y - 1][x - 3] ="\\";
       board[y - 1][x - 3] ="\\";
        board[y - 1][x - 4] ="=";
        board[y + 1][x - 3] ="/";
        board[y + 1][x - 4]="=";
    }

    private boolean collisionDetected(int newX, int newY) {
        return board[newY][newX].equals("\uD83E\uDEA8") || // Stone check
                board[newY][newX - 1].equals("\uD83E\uDEA8") || // Check left of the airplane
                board[newY][newX - 2].equals("\uD83E\uDEA8") || // Check left of the airplane
                board[newY][newX - 3].equals("\uD83E\uDEA8") || // Check left of the airplane
                board[newY][newX - 4].equals("\uD83E\uDEA8") || // Check left of the airplane
                board[newY-1][newX -3].equals("\uD83E\uDEA8") ||
                board[newY-1][newX -3].equals("\uD83E\uDEA8") ||// Check right of the airplane
                board[newY-1][newX - 4].equals("\uD83E\uDEA8") || // Check right of the airplane
                board[newY+1][newX - 3].equals("\uD83E\uDEA8") || // Check right of the airplane
                board[newY+1][newX - 4].equals("\uD83E\uDEA8") || // Check right of the airplane

                newX < 0 || newX >= BOARD_WIDTH || newY < 0 || newY >= BOARD_HEIGHT;
    }
    private boolean collisionDetectedEarth(int newX, int newY) {
        return board[newY][newX].equals("\uD83C\uDF0E") || // Stone check
                board[newY][newX - 1].equals("\uD83C\uDF0E") || // Check left of the airplane
                board[newY][newX - 2].equals("\uD83C\uDF0E") || // Check left of the airplane
                board[newY][newX - 3].equals("\uD83C\uDF0E") || // Check left of the airplane
                board[newY][newX - 4].equals("\uD83C\uDF0E") || // Check left of the airplane
                board[newY-1][newX -3].equals("\uD83C\uDF0E") ||
                board[newY-1][newX -3].equals("\uD83C\uDF0E") || // Check right of the airplane
                board[newY-1][newX - 4].equals("\uD83C\uDF0E") || // Check right of the airplane
                board[newY+1][newX - 3].equals("\uD83C\uDF0E") || // Check right of the airplane
                board[newY+1][newX - 4].equals("\uD83C\uDF0E") || // Check right of the airplane

                newX < 0 || newX >= BOARD_WIDTH || newY < 0 || newY >= BOARD_HEIGHT;
    }





}
