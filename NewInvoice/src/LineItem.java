
import java.text.NumberFormat;

public class LineItem
{
    private Product product;
    private int quantity;
    private double total;

    public LineItem()
    {
        this.product = new Product();
        this.quantity = 0;
        this.total = 0;
    }

    public void setProduct(Product product)
    {
        this.product = product;
    }

public Product getProduct()
    {
        return product;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public double getTotal()
    {
        this.calculateTotal();
        return total;
    }

public void calculateTotal()
    {
        total = quantity * product.getPrice();
    }

    public String getFormattedTotal()
    {
        NumberFormat currency = 
            NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }

	@Override
	public String toString() {
		return product.getCode() + product.getDescription() + product.getPrice() + quantity + total;
	}
    
    
}
