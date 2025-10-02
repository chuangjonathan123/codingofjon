public class BookstoreReceipt
{
    private String customerName;
    private int numberOfBooks;
    private double pricePerBook;
    private String thankYouMessage;
    
    public BookstoreReceipt(String name, int num, String message)
    {
        customerName = name;
        numberOfBooks = num;
        pricePerBook = 13.99;
        thankYouMessage = message; 
    }
    
    public String getReceipt()
    {
        String build = "Customer Name: " + customerName;
        build += "\nNumber of Books: " + numberOfBooks;
        build += "\nTotal Price: $" + pricePerBook * numberOfBooks;
        build += "\n" + thankYouMessage;
        return build;
    }
}
