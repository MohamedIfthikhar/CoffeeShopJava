public class Customer{

int id;
String[] orders;
double[] order_price;

public Customer(int id, String[] orders, double[] order_prices){
this.id = id;
this.orders = orders;
this.order_prices = order_prices;
}

double total = 0.0;

public double calculateTotal{
for(double price: order_prices){
total+= price;
}
}


}