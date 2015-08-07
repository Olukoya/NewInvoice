import java.text.NumberFormat;
import java.util.*;
public class Invoice {
	

	private ArrayList<LineItem> outputLine = new ArrayList<LineItem>();
	
	
	public void AddLineItem(LineItem lineItem)
	{
		outputLine.add(lineItem);
		System.out.println();
		
	}

	@Override
	public String toString() {
		String s = "";
		for(LineItem l : outputLine){
		System.out.print(String.format("%-8s%-33s%-16s%-12s%-2s\n",l.getProduct().getCode(),l.getProduct().getDescription(),l.getProduct().getFormattedPrice(),l.getQuantity(),l.getFormattedTotal()));
		}
		return s;
	}
	
	public double getITotal()
    {
        double sum = 0.0;
        for (LineItem l : outputLine){
        	sum += (l.getProduct().getPrice() * l.getQuantity());
        }
        return sum;
    }

    public String getFormattedITotal()
    {
        NumberFormat currency = 
            NumberFormat.getCurrencyInstance();
        return currency.format(this.getITotal());
    }
	
	
}
