
import java.util.Scanner;
public class InvoiceApp
{
    public static void main(String args[])
    {
    	Invoice invoice = new Invoice();
        // display a welcome message
        System.out.println(
            "Welcome to the Line Item Calculator");
        System.out.println();

        Scanner sc = new Scanner(System.in);
        String choice = "y";
        while (choice.equalsIgnoreCase("y"))
        {
            // get the input from the user
            String productCode =
                Validator.getString(sc,
                "Enter product code: ");
            int quantity = Validator.getInt(sc,
                "Enter quantity:     ", 0, 1000);
			// get the Product object
            Product product = ProductDB.getProduct(productCode);

            // create the LineItem object and set its fields
            LineItem lineItem = new LineItem();
            lineItem.setProduct(product);
            lineItem.setQuantity(quantity);
            invoice.AddLineItem(lineItem);
         
            // see if the user wants to continue
            choice = Validator.getString(
                sc, "Another line item? (y/n): ");
   
        
        }
        System.out.println("Code	Description			 Price		Qty	    Total\n"
        		         + "-----------------------------------------------------------------------");
        System.out.println(invoice);
        System.out.println();
        System.out.println("					Invoice Total: " +invoice.getFormattedITotal());
    }
}
