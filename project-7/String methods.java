import java.util.Scanner;

public class StringMethods {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // (apcsa) project
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
        
        
        System.out.println(string1);
        System.out.println(string2);
        System.out.println(string3);
        
        String concat12 = string1 + string2;
        System.out.println("Concatenation: " + concat12);
        
        int len1 = string1.length();
        System.out.println("Length of string1 is: " + len1);
        
        double avg14 = (string1.length() + string4.length()) / 2;
        System.out.println("Average length of string1 and string4: " + avg14);
        
        boolean equals23 = string2.equals(string3);
        System.out.println("string2 equals string3? " + equals23);
        
        int pos3in1 = string1.indexOf(string3);
        System.out.println("Position of string3 in string1 : " + pos3in1);
        
        String substr1_1_3 = string1.substring(1,3);
        System.out.println("substring of string1 from 1 to 3:" + substr1_1_3);

        String substr2_from2 = string2.substring(2);
        System.out.println("substring of string2 from index 2: " + substr2_from2);
        
        boolean startsSame = (string1.substring(0,1)).equals(string2.substring(0,1));
        System.out.println("Do string1 and string2 start with same character? " + startsSame);
        
        String swapped = string5 + string4; 
        System.out.println("string5 then string4: " + swapped);
        
        int comp = string3.compareTo(string4);
        System.out.println("compareTo result of string3 vs string4: "+  comp);
       
        boolean same54 = string5.equals(string4);
        System.out.println("string5 equals string4?" + same54);
       
        int sumLengths = string2.length() + string3.length() + string5.length();
        
        String firstChar3 = string3.substring(0,1);
        System.out.println("First character of string3: " + firstChar3);
       
        String lastChar2 = string2.substring(string2.length()-1);
        
        String middle23 = string2.substring(1,string2.length()-1);
        System.out.println(string1 + ", " + string2 + ", " + string3 + ", " + string4 + ", " + string5);
        
        String literalNewStr = new String(string1);
        System.out.println("New String form string1: "+ literalNewStr);
      
        String temp = string1;
        temp = temp.substring(0,1);
        System.out.println("Orginial string1 after substring attempt: " + string1);
        System.out.println("Temp substring(0,1): " + temp);
    
        scan.close();
    }
}
