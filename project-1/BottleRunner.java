public class BottleRunner 
{
    public static void main(String[] args) 
    {
       
        WaterBottle jon = new WaterBottle(1.0, 0.6);
        jon.drink(0.4);
        jon.drink(0.4);
        jon.drink(0.3);
        jon.refill(0.6);
        System.out.println(jon);
        
        
        
        
        
        
        
    }
}
