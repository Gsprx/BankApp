import java.util.*;
public class CreditCardTransactionList{
    //Idiothtes klashs CreditCardTransactionList
    private HashMap<String, CreditCardTransaction> list = new HashMap<String, CreditCardTransaction>();

    public void add (CreditCardTransaction cct){
        list.put(cct.getKey(), cct);
    }

    public HashMap<String, CreditCardTransaction> getList(){
        return this.list;
    }


}//CreditCardTransactionList
