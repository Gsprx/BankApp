public class CreditCardTransaction {
    //Idiothtes klashs CreditCardTransaction
    private String card_key;
    private double transaction_amount;
    private String reason;
    private String key;
    private static int count;
    private CreditCard creditcard;

    public CreditCardTransaction (String cckey, double amount, String reason){
        card_key = cckey;
        transaction_amount = amount;
        this.reason = reason;
        count++;
        key = "CCT" + count;
    }//Constructor

    public void setCC(CreditCard cc){
        creditcard = cc;
    }
    
    public CreditCard getCC(){
        return creditcard;
    }

    public String getKey(){
        return key;
    }

    public String getCardKey(){
        return this.card_key;
    }

    public double getTransactionAmount(){
        return transaction_amount;
    }

    public String getReason(){
        return reason;
    }

    public String toString(){
        return "--------------------------------------\n" + "Key: " + key + "\n" +
        "Credit Card's key: " + card_key + "\n" +
        String.format("%s %.2f", "Transaction amount:" , transaction_amount) + "\n" + "Reason of transaction: " + reason + 
        "\n--------------------------------------\n";
    }
    
}//CreditCardTransaction
