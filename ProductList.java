import java.util.*;
public class ProductList{
    //Idiothtes klashs ProductList
    private HashMap<String, Product> list = new HashMap<String, Product>();

    public void add (Product product){
        if(list.keySet().contains(product.getKey())){
            product.setKey("C" + (product.getCount() + 1));
            list.put(product.getKey(), product);
        }
        else{
            list.put(product.getKey(), product);
        }
    }

    public void printLoans(){
        for (Product product : list.values()){
            if (product instanceof Loan){
                System.out.println(product);
            }
        }
    }

    public void printCreditCards(){
        for (Product product : list.values()){
            if (product instanceof CreditCard){
                System.out.println(product);
            }
        }        
    }

    public boolean findKey(String key){
        for(String k : list.keySet()){
            if (k.equals(key)){
                return true;
            }
        }
        return false;
    }

    public boolean findId(String id){
        for (Product product : list.values()){
            if (product.getId().equals(id)){
                return true;
            }
        }
        return false;
    }

    public Product getProduct(String key){
        return list.get(key);
    }

    public HashMap<String, Product> getList(){
        return this.list;
    }

}//ProductList