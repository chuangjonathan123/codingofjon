import java.util.Scanner;

public class WordGameRunner
{
    public static void main(String[] args)
    {
        // fun game i coded in apcsa, splitting up words through index of. 
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter a word: ");
        String word = input.nextLine();
        
        System.out.println("Scrambled word: " + WordGames.scramble(word));
        
       
        System.out.println("Enter an integer: ");
        int idx = input.nextInt();
        input.nextLine();
        System.out.println("Enter another word: ");
        String anotherWord = input.nextLine();
        
        System.out.println("Banana split!: " + WordGames.bananaSplit(word, idx, anotherWord));
        
       
        System.out.println("Enter a character in " + word + ": ");
        String letter = input.nextLine();
        System.out.println("Enter another word: ");
        anotherWord = input.nextLine();
        
        System.out.println("Banana split!: " + WordGames.bananaSplit(word, letter, anotherWord));
    }
}
