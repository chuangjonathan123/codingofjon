public class BookstoreReceiptRunner
{
    public static void main(String[] args)
    {
        //Create 2 BookstoreReceipt objects
        BookstoreReceipt jon = new BookstoreReceipt("JOnathan", 49, "Thanks for shopping!");
        BookstoreReceipt stan = new BookstoreReceipt("harry potter", 4, "Thanks for shopping!");
        //Print out the receipts
        System.out.println(jon.getReceipt());
        System.out.println(stan.getReceipt());
    }
}
