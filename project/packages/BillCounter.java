public class BillCounter{


public double taxCalculator(double total){
private double salesTaxPercent = 0.02;
private double gstTaxPercent = 0.015;

double tax = (total*salesTaxPercent) + (total*gstTaxPercent);

return tax;
}


}