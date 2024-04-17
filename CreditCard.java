public class CreditCard extends Product {
    //Idiothtes upoklashs CreditCard.
    private double commission_rate;
    private double max_transaction_amount;
    private double max_yearly_transaction_amount;
    private double balance = 0;
    private boolean error = false; //xrhsh sthn main gia break h continue sto for loop otan ginetai kinhsh kartas
    private double total_transacted_amount;
    private CreditCardTransactionList cct_list;
    private static int count = 0;
    
    public CreditCard (String pro_id, String afm, int cus_num, double com_rate, double max_amount, double yearly_amount){
        super(pro_id, afm, cus_num);
        commission_rate = com_rate;
        max_transaction_amount = max_amount;
        max_yearly_transaction_amount = yearly_amount;
        count++;
        key = "C" + count;
    }//Constructor

    public double calcCommission(){
        double sum = 0;
        for (CreditCardTransaction cct : cct_list.getList().values()){
            if (this.key.equals(cct.getCardKey())){
                sum += java.lang.Math.abs(cct.getTransactionAmount())*commission_rate;
            }
        }
        return sum;
    }
    

    public void deposit(double amount){
        if (amount > max_transaction_amount){
            System.out.println("Error: Amount surpasses maximum transaction limit (" + amount + "/" + max_transaction_amount + ").");
            error = true;
        }
        else{
            if(total_transacted_amount + amount <= max_yearly_transaction_amount){
                balance += amount;
                total_transacted_amount += amount;
                error = false;
            }
            else{
                System.out.println("Error: Amount surpasses maximum yearly transaction limit (" +
                                    total_transacted_amount + "/" + max_yearly_transaction_amount + ").");
                error = true;
            }
        }
    }

    public void withdraw(double amount){
        if (amount > balance){
            System.out.println("Error: Insufficient funds (Available funds: " + balance +").");
            error = true;
        }
        else{
            if(total_transacted_amount + amount <= max_yearly_transaction_amount){
                balance -= amount;
                total_transacted_amount += amount;
                error = false;
            }
            else{
                System.out.println("Error: Amount surpasses maximum yearly transaction limit (" +
                                    total_transacted_amount + "/" + max_yearly_transaction_amount + ").");
                error = true;
            
            }
        }
    }
    public void setBalance(double bal){
        balance = bal;
    }
    public double getBalance(){
        return balance;
    }

    public boolean getError(){
        return error;
    }

    public double getCom(){
        return commission_rate;
    }

    public double getMaxAmount(){
        return max_transaction_amount;
    } 

    public double getYearlyAmount(){
        return max_yearly_transaction_amount;
    }

    public void setCCTs(CreditCardTransactionList ccts){
        cct_list = ccts;
    }

    public double getTotalTransactedAmount(){
        return total_transacted_amount;
    }

    public void setTotalTransactedAmount(double amount){
        total_transacted_amount = amount;
    }

    public void setCount(int count){
        CreditCard.count = count;
    }

    public void setKey(String key){
        this.key = key;
    }

    public String toString(){
        return "--------------------------------------\n" + "Key: " + key + "\n" +
        "Credit Card's id: " + product_id + "\n" +
        String.format("%s %.2f%n%s %.2f%s%n", "Balance:", balance, "Credit card's rate:", commission_rate*100, "%") +
        "Credit card's holder afm: " + customer_afm + "\n" + "Credit card's holder number: " + customer_number + "\n" +
        String.format("%s %.2f%n%s %.2f", "Maximum amount per transaction:", max_transaction_amount,
                                                     "Maximum amount of yearly transactions:", max_yearly_transaction_amount) +
        "\n--------------------------------------\n";
    }
}//CreditCard
