public class BookstoreReceiptRunner
{
    public static void main(String[] args)
    {
        BookstoreReceipt jon = new BookstoreReceipt("Jonathan", 49, "Thanks for shopping!");
        BookstoreReceipt stan = new BookstoreReceipt("harry potter", 4, "Thanks for shopping!");
        System.out.println(jon.getReceipt());
        System.out.println(stan.getReceipt());
    }
}
