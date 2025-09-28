public class WaterBottle 
{
    private double capacity; // Total capacity in liters
    private double currentVolume; // Current volume in liters
    private int currentSipCount; // Current number of sips
    private int remainingPercent; // Current remaining %
    private double volumeConsumed; // Amount of water consumed in liters

    // Constructor
    public WaterBottle(double bottleCapacity, double bottleInitialVolume) 
    {
        capacity = bottleCapacity;
        // Make sure current volume is not above capacity
        currentVolume = Math.min(bottleInitialVolume, capacity);
        remainingPercent = (int) ((currentVolume / capacity) * 100);
        currentSipCount = 0;
        volumeConsumed = 0.0;
    }

    // Method to drink a specified amount from the bottle
    public void drink(double amount) 
    {
        // Subtract amount from current volume
        currentVolume -= amount;

        // If volume is negative after this drink, set current
        // volume to 0
        currentVolume = Math.max(currentVolume, 0); 

        // Round volume to nearest tenth of a liter
        currentVolume = Math.round(currentVolume * 10) / 10.0;
        
        // Calculate new remaining percent
        remainingPercent = calcRemainingPercentage();

        // Add one sip to counter
        currentSipCount++;
        
        // Add amount to volume consumed
        volumeConsumed += amount;
    }

    // Method to refill the bottle 
    public void refill(double amount) 
    {
        // Add amount to current volume
        currentVolume += amount;

        // If current volume is greater than capacity, set
        // current volume to capacity (no overflow)
        currentVolume = Math.min(currentVolume, capacity);
        
        // Calculate new remaining percent
        remainingPercent = calcRemainingPercentage();
    }
    
    // Overloaded method without an amount refills to full
    // capacity
    public void refill()
    {
        refill(capacity);
    }

    // Private method to help calculate the remaining percentage
    private int calcRemainingPercentage() 
    {
        // Calculate remaining percent
        return (int) ((currentVolume / capacity) * 100);
    }

    public void resetConsumption()
    {
        // Reset sip count
        currentSipCount = 0;

        // Rest volume consumed
        volumeConsumed = 0.0;
    }

    // toString method to display bottle details
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
