import java.util.Scanner;

public class NameTagGenerator
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner (System.in);
        System.out.print("Give me a name: ");
        String name1 = input.nextLine();
        System.out.print("Give me another: ");
        String name2 = input.nextLine();
        displayNameTag(name1);
        displayNameTag(name2);
        boolean stan = name1.equals(name2);
        System.out.println("Are the two names the same?: " + stan);
    }
    
    
  
    public static void displayNameTag(String name)
    {
        System.out.println("****************");
        System.out.println("Name: " + name);
        System.out.println("Length: " + name.length() + "characters");
        System.out.println("Last Letter: " + name.substring(name.length()-1));
        System.out.println("****************");
        
    }
}
