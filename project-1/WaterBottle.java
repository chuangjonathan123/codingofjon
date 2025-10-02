public class WaterBottle 
{
    private double capacity; 
    private double currentVolume; 
    private int currentSipCount;
    private int remainingPercent; 
    private double volumeConsumed; 

  
    public WaterBottle(double bottleCapacity, double bottleInitialVolume) 
    {
        capacity = bottleCapacity;
        
        currentVolume = Math.min(bottleInitialVolume, capacity);
        remainingPercent = (int) ((currentVolume / capacity) * 100);
        currentSipCount = 0;
        volumeConsumed = 0.0;
    }

    public void drink(double amount) 
    {
        currentVolume -= amount;


        currentVolume = Math.max(currentVolume, 0); 

        currentVolume = Math.round(currentVolume * 10) / 10.0;
        
        remainingPercent = calcRemainingPercentage();

        currentSipCount++;
        
        volumeConsumed += amount;
    }

    // Method to refill the bottle 
    public void refill(double amount) 
    {
        currentVolume += amount;
        currentVolume = Math.min(currentVolume, capacity);
        
        remainingPercent = calcRemainingPercentage();
    }
    
   
    public void refill()
    {
        refill(capacity);
    }

    private int calcRemainingPercentage() 
    {
       
        return (int) ((currentVolume / capacity) * 100);
    }

    public void resetConsumption()
    {
        
        currentSipCount = 0;

        volumeConsumed = 0.0;
    }

   
    public String toString() {
        return "== Water Bottle Status ==" +
                "\nCapacity: " + capacity + "L" +
                "\nCurrent Volume Left: " + currentVolume + "L" +
                "\nPercent Volume Remaining: " + remainingPercent + "%\n" +
                "\n** Water Consumption Status **" +
                "\nVolume Consumed: " + volumeConsumed + "L" + 
                "\nSip Count: " + currentSipCount + "\n";
    }
}
