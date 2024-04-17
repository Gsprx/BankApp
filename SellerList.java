import java.util.*;
public class SellerList{
    //Idiothtes klashs SellerList
    private HashMap<String, Seller> list = new HashMap<String, Seller>();

    public void add (Seller seller){
        list.put(seller.getKey(), seller);
    }

    public void printSellers(){
        for(Seller seller : list.values()){
            System.out.println(seller);
        }
    }
    public boolean findId(String id){
        for (Seller seller : list.values()){
            if(id.equals(seller.getId())){
                return true;
            }
        }
        return false;
    }

    public boolean findKey(String key){
        for (String thiskey : list.keySet()){
            if(key.equals(thiskey)){
                return true;
            }
        }
        return false;      
    }

    public HashMap<String, Seller> getList(){
        return this.list;
    }

    public String getSellerId(String key){
        return list.get(key).getId();
    }
}//SellerList
