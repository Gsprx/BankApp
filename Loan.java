public class Loan extends Product{
    //Idiothtes upoklashs Loan.
    private double loan_amount;
    private double loan_rate;
    private static int count = 0;

    public Loan (String pro_id, String afm, int cus_num,double amount){
        super(pro_id, afm, cus_num);
        loan_amount = amount;
        if (amount <= 500000){
            loan_rate = 0.01;
        }
        else if(amount <= 2000000){
            loan_rate = 0.02;
        }
        else if(amount > 2000000){
            loan_rate = 0.025;
        }
        count++;
        key = "L" + count;
    }//Constructor

    public double calcCommission(){
        return loan_amount*loan_rate;
    }

    public String getKey(){
        return key;
    }

    public double getAmount(){
        return loan_amount;
    }

    public void setCount(int count){
        Loan.count = count;
    }

    public void setKey(String key){
        this.key = key;
    }

    //Methodoi gia na hremisei o compiler...
    public void setCCTs(CreditCardTransactionList cct){}
    public void withdraw(double amount){}
    public void deposit (double amount){}
    public boolean getError(){return false;}

    public String toString(){
        return "--------------------------------------\n" + "Key: " + key + "\n" +
                "Loan's id: " + product_id + "\n" +
                String.format("%s %.2f%n%s %.2f%s%n", "Loan's amount:", loan_amount, "Loan's rate:", loan_rate*100, "%") +
                "Loan's holder afm: " + customer_afm + "\n" + "Loan's holder number: " + customer_number + 
                "\n--------------------------------------\n";
    }
    
}//Loan
