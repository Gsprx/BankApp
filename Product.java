public abstract class Product{
    // Idiothtes uperklashs Product.
    protected String product_id;
    protected String customer_afm;
    protected int customer_number;
    protected String key;
    protected int count;

    public Product (String pro_id, String afm, int cus_num){
        product_id = pro_id;
        customer_afm = afm;
        customer_number = cus_num;
    }//Constructor

    public String getKey(){
        return key;
    }

    public String getId(){
        return product_id;
    }

    public String getAfm(){
        return customer_afm;
    }

    public int getCusNum(){
        return customer_number;
    }

    public int getCount(){
        return count;
    }

    abstract public void setKey(String key);
    abstract public void setCount(int count);
    abstract public double calcCommission();
    abstract public void deposit(double amount);
    abstract public void withdraw(double amount);
    abstract public boolean getError();
    abstract public void setCCTs(CreditCardTransactionList cct);

}//Product