public class BottleRunner 
{
    public static void main(String[] args) 
    {
        // making a math model on how many sips it would take for a refill to be necesary
        WaterBottle jon = new WaterBottle(1.0, 0.6);
        jon.drink(0.4);
        jon.drink(0.4);
        jon.drink(0.3);
        jon.refill(0.6);
        System.out.println(jon);
        
        
        
        
        
        
        
    }
}
