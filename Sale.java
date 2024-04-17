public class Sale {
    //Idiothtes klashs Sale.
    private String seller_id;
    private String product_id;
    private String reason;
    private String key;
    private static int count;

    public Sale (String sel_id, String pro_id, String reason){
        seller_id = sel_id;
        product_id = pro_id;
        this.reason = reason;
        count++;
        key = "SL" + count;
    }//Constructor

    public String getProductId(){
        return product_id;
    }

    public String getSellerId(){
        return this.seller_id;
    }

    public String getKey(){
        return key;
    }

    public String getReason(){
        return reason;
    }

    public String toString(){
        return "--------------------------------------\n" + "Key: " + key + "\n" +
                "Seller's id: " + seller_id + "\n" +
                "Product id: " + product_id + "\n" +
                "Reason: " + reason +
                "\n--------------------------------------\n";
    }
    
}//Sale
