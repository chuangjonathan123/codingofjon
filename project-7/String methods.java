import java.util.Scanner;

public class APCSA_StringMethodsReview {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // Reading in several strings; students know they are valid but not their content
        System.out.println("Enter string1:");
        String string1 = scan.nextLine();
        System.out.println("Enter string2:");
        String string2 = scan.nextLine();
        System.out.println("Enter string3:");
        String string3 = scan.nextLine();
        System.out.println("Enter string4:");
        String string4 = scan.nextLine();
        System.out.println("Enter string5:");
        String string5 = scan.nextLine();
        
        // ------------------ Questions ------------------
        // Students should write code for each using println, variable creation (int, double, boolean, String)
        // Only using allowed methods: String(String), length(), substring(int), substring(int, int), indexOf(String),
        // equals(Object), compareTo(String), concatenation (+, +=)        
        // Q1. Print string1, string2, string3 each on its own line.
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
        // Q2. Create a String named concat12 that concatenates string1 and string2 (in that order) and print:
        //     "Concatenation: " + concat12
        String concat12 = string1 + string2;
        System.out.println("Concatenation: " + concat12);
        // Q3. Create an int variable len1 holding string1's length; then print:
        //     "Length of string1 is: " + len1
        int len1 = string1.length();
        System.out.println("Length of string1 is: " + len1);
        // Q4. Create a double avg14 that is the average length of String1 and String 4
        //     "Average length of string1 and string4: " + avg14
        double avg14 = (string1.length() + string4.length()) / 2;
        System.out.println("Average length of string1 and string4: " + avg14);
        // Q5. Create a boolean equals23 that is true if string2 has the exact same characters as string3; print:
        //     "string2 equals string3? " + equals23
        boolean equals23 = string2.equals(string3);
        System.out.println("string2 equals string3? " + equals23);
        // Q6. Create an int variable pos3in1 and initialize it with the position of string3 in string1; print:
        //     "Position of string3 in string1: " + pos3in1
        int pos3in1 = string1.indexOf(string3);
        System.out.println("Position of string3 in string1 : " + pos3in1);
        // Q7. Create a String substr1_1_3 that consists of the second and third character of String 1 only; print:
        //     "substring of string1 from 1 to 3: " + substr1_1_3
        String substr1_1_3 = string1.substring(1,3);
        System.out.println("substring of string1 from 1 to 3:" + substr1_1_3);
        // Q8. Create a String substr2_from2 that contains all the character of string2 except for the first 2; print:
        //     "substring of string2 from index 2: " + substr2_from2
        String substr2_from2 = string2.substring(2);
        System.out.println("substring of string2 from index 2: " + substr2_from2);
        // Q9. Create a boolean startsSame that is true if string1 and string2 start with the same character; print:
        //     "Do string1 and string2 start with same character? " + startsSame
        boolean startsSame = (string1.substring(0,1)).equals(string2.substring(0,1));
        System.out.println("Do string1 and string2 start with same character? " + startsSame);
        // Q10. Create a String swapped that concatenates string5 and string 4 in that order; print:
        //     "string5 then string4: " + swapped
        String swapped = string5 + string4; 
        System.out.println("string5 then string4: " + swapped);
        // Q11. Create an int comp = string3.compareTo(string4); try to predict the number: print:
        //     "compareTo result of string3 vs string4: " + comp
        int comp = string3.compareTo(string4);
        System.out.println("compareTo result of string3 vs string4: "+  comp);
        // Q12. Create a boolean same54 that is true if string5 and string 4 are equal, false otherwise; print:
        //     "string5 equals string4? " + same54
        boolean same54 = string5.equals(string4);
        System.out.println("string5 equals string4?" + same54);
        // Q13. Create an int sumLengths that is the sum of the lengths of strings 2, 3, and 5; print:
        //     "Sum of lengths of string2, string3, string5: " + sumLengths
        int sumLengths = string2.length() + string3.length() + string5.length();
        // Q14. Create a String firstChar3 and initialize it with the first character of string3; print:
        //     "First character of string3: " + firstChar3
        String firstChar3 = string3.substring(0,1);
        System.out.println("First character of string3: " + firstChar3);
        // Q15. Create a String lastChar2 and initialize it with the last character of string2; print:
        //     "Last character of string2: " + lastChar2
        String lastChar2 = string2.substring(string2.length()-1);
        // Q16. Create a boolean containsString4in5 that is true if string4 is found within string5; print:
        //     "string5 contains string4? " + containsString4in5
        // Q17. Create a String middle23 and initialize it with all the chars of string2 except the first and last; print:
        //     "string2 without first and last chars: " + middle23
        String middle23 = string2.substring(1,string2.length()-1);
        // Q18. Print all five strings in one line separated by a comma and space (", ")
               System.out.println(string1 + ", " + string2 + ", " + string3 + ", " + string4 + ", " + string5);
        // Q19. Create a String literalNewStr using the String constructor with string1 as the parameter; print:
        //     "New String from string1: " + newStr
        String literalNewStr = new String(string1);
        System.out.println("New String form string1: "+ literalNewStr);
        // Q20. Demonstrate immutability: do
        //     String temp = string1;
        //     temp = temp.substring(0,1);
        //     Print:
        //     "Original string1 after substring attempt: " + string1
        //     "Temp substring(0,1): " + temp
        String temp = string1;
        temp = temp.substring(0,1);
        System.out.println("Orginial string1 after substring attempt: " + string1);
        System.out.println("Temp substring(0,1): " + temp);
    
        scan.close();
    }
}
