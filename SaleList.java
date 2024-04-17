import java.util.*;
public class SaleList{
    //Idiothtes klashs SaleList
    private HashMap<String, Sale> list = new HashMap<String, Sale>();

    public void add (Sale sale){
        list.put(sale.getKey(), sale);
    }

    public HashMap<String, Sale> getList(){
        return this.list;
    }

}//SaleList