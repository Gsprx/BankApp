
public class Seller {
    //Idiothtes klashs Seller
    protected String seller_id;
    protected String seller_firstname;
    protected String seller_lastname;
    protected String seller_afm;
    protected String key;
    protected static int count;

    public Seller (String id, String firstname, String lastname, String afm){
        seller_id = id;
        seller_firstname = firstname;
        seller_lastname = lastname;
        seller_afm = afm;
        count++;
        key = "SR" + count;
    }//Constructor

    public String getId(){
        return this.seller_id;
    }

    public String getKey(){
        return key;
    }

    public String getFirstName(){
        return seller_firstname;
    }

    public String getLastName(){
        return seller_lastname;
    }

    public String getAfm(){
        return seller_afm;
    }
    
    public String toString(){
        return "--------------------------------------\n" + "Key: " + key + "\n" +
                "Seller's id: " + seller_id + "\n" +
                "Seller's first name : " + seller_firstname + "\n" +"Seller's last name: " + seller_lastname + "\n" +
                "Seller's afm: " + seller_afm + "\n--------------------------------------\n";
    }

    public String toString2(double a){
        return "--------------------------------------\n" + "Key: " + key + "\n" +
        "Seller's id: " + seller_id + "\n" +
        "Seller's first name: " + seller_firstname + "\n" + "Seller's last name: " + seller_lastname + "\n" +
        String.format("%s %.2f", "Seller's commission: " , a) +
        "\n--------------------------------------\n";

    }
    public boolean equals(Seller seller){
        if (seller.getKey().equals(key)){
            return true;
        }
        else{
            return false;
        }
    }
    
}//Seller
