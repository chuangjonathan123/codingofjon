public class CameraRunner 
{
    public static void main(String[] args) 
    {
       // Create at least 3 camera objects and print them out
       Camera one = new Camera("film", 10);
       Camera two = new Camera(3, 100);
       Camera three = new Camera("digital", 100);
       
       System.out.println(one);
       System.out.println(two);
       System.out.println(three);
       
       
    }
}