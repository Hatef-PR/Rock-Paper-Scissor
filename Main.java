import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        int userWin = 0, computerWin = 0;
        String[] options = {"r", "p", "s"}; // Rock, Paper, Scissor

        while (true) {
            System.out.println("Type R / P / S or Q to quit: ");
            String userInput = input.next().toLowerCase();
            if (userInput.equals("q")) {
                break;
            } else if (!userInput.equals("r") && !userInput.equals("p") && !userInput.equals("s")) {
                continue;
            }
            int randomNumber = rand.nextInt(0, 2);
            String computerPick = options[randomNumber];

            if (checkUserWin(userInput, computerPick)) {
                System.out.println("You won!");
                userWin += 1;
            } else if (checkComputerWin(userInput, computerPick)) {
                System.out.println("Computer won!");
                computerWin += 1;
            } else if (userInput.equals(computerPick)) {
                System.out.println("Both are the same!");
            }

        }
        System.out.println("You: " + userWin);
        System.out.println("Computer: " + computerWin);
    }
    // this method checks the user won the game or not
    public static boolean checkUserWin(String userInput, String computerPick) {
        boolean flag = false;
        if (userInput.equals("r") && computerPick.equals("p") ||
                userInput.equals("p") && computerPick.equals("s") ||
                userInput.equals("s") && computerPick.equals("r")) {
            flag = true;
        }
        return flag;
    }
    // this method checks the computer won the game or not
    public static boolean checkComputerWin(String userInput, String computerPick) {
        boolean flag = false;
        if (computerPick.equals("r") && userInput.equals("p") ||
                computerPick.equals("p") && userInput.equals("s") ||
                computerPick.equals("s") && userInput.equals("r")) {
            flag = true;
        }
        return flag;
    }
}
