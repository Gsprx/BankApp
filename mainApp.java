/* -STOIXEIA OMADAS-
Name: Gasparis Rigos
AM: 3210174

Name: Gerasimos Magkos
AM: 3210107

*/
import java.io.*;
import java.util.*;
public class mainApp {
    //Dhmiourgia antikeimenwn twn listwn.
    static SellerList sellers = new SellerList();
    static ProductList products = new ProductList();
    static SaleList sales = new SaleList();
    static CreditCardTransactionList cctransactions = new CreditCardTransactionList();
    public static void main(String args[]){

        // Eisagwges apo ta arxeia txt.
        System.out.println("Reading 'sellersfile.txt'...");
        readFile("sellersfile.txt");

        System.out.println("Reading 'productsfile.txt'...");
        readFile("productsfile.txt");

        System.out.println("Reading 'salesfile.txt'...");
        readFile("salesfile.txt");

        System.out.println("Reading 'cctfile.txt'...");
        readFile("cctfile.txt");


        //For loop(menu)
        Scanner in = new Scanner(System.in);
        String response;
        for(;;){
            System.out.println("\n\n");
            System.out.println("[1] Enter new seller.");
            System.out.println("[2] Enter new product.");
            System.out.println("[3] Enter new sale.");
            System.out.println("[4] Enter new credit card transaction.");
            System.out.println("[5] Print all loans.");
            System.out.println("[6] Calculate a seller's commission.");
            System.out.println("[7] Print credit card transactions related to a seller.");
            System.out.println("[8] Calculate total commissions from all sellers.");
            System.out.println("[9] Print total amount of commissions for each seller.");
            System.out.println("[0] Exit.");
            System.out.println("[S] Save data in storage files.");
            System.out.println();
            System.out.print(">>> Enter input: ");
            response = in.next();
            System.out.println();
            if (response.equals("S") || response.equals("s")){
                System.out.println("Saving data into files...");
                writeFile("productsfile.txt");
                writeFile("sellersfile.txt");
                writeFile("salesfile.txt");
                writeFile("cctfile.txt");
                System.out.println("Save complete.");
                continue;
            }
            else if (response.equals("0")){
                System.out.println("Exiting application...");
                writeFile("productsfile.txt");
                writeFile("sellerfile.txt");
                writeFile("salesfile.txt");
                writeFile("cctfile.txt");
                break;
            }//if0
            else if (response.equals("1")){
                String firstname;
                System.out.print("Enter seller's first name: ");
                firstname = in.next();
                System.out.println();

                String lastname;
                System.out.print("Enter seller's last name: ");
                lastname = in.next();
                System.out.println();

                String id;
                System.out.print("Enter seller's id: ");
                id = in.next();
                System.out.println();

                String afm;
                System.out.print("Enter seller's afm: ");
                afm = in.next();
                System.out.println();

                //User confirmation
                Seller temp_seller = new Seller(id, firstname, lastname, afm );

                while (true){
                    System.out.println("Do you want to continue with the addition of this seller? [1]-> Yes, [0]-> No.\n"
                    + temp_seller.toString());
                    System.out.print(">>> ");
                    response = in.next();
                    if (response.equals("1")){
                        sellers.add(temp_seller);
                        System.out.println("Successfully added item.\n");
                        break;
                    }
                    else if (response.equals("0")){
                        temp_seller = null;
                        break;
                    }
                    else{
                        System.out.println("[!]Error: Invalid response.");
                        continue;
                    }
                }//verification while

            }//if1
            else if (response.equals("2")){
                String id;
                System.out.print("Enter product's id: ");
                id = in.next();
                System.out.println();

                String afm;
                System.out.print("Enter customer's afm: ");
                afm = in.next();
                System.out.println();

                int num = -1;
                for(;;){
                    System.out.print("Enter customer's number: ");
                    num = in.nextInt();
                    System.out.println();
                    if (num < 0){
                        System.out.println("[!]Error: Invalid customer number.");
                        continue;
                    }
                    else{
                        break;
                    }

                }//customer number verification loop


                //product type distinction
                String type;
                while (true){
                    System.out.print("Enter type of product ([1]-> Loan, [2]-> Credit Card): ");
                    type = in.next();
                    System.out.println();
                    if (type.equals("1")){
                        double amount = -1;
                        for(;;){
                            System.out.print("Enter loan's amount: ");
                            amount = in.nextDouble();
                            System.out.println();
                            if (amount<=0){
                                System.out.println("[!]Error: Invalid loan amount.");
                                continue;
                            }
                            else{
                                break;
                            }
                        }//amount verification loop

                        //User confirmation
                        Loan temp_loan = new Loan(id, afm, num, amount);

                        while (true){
                            System.out.println("Do you want to continue with the addition of this loan? [1]-> Yes, [0]-> No.\n"
                            + temp_loan.toString());
                            System.out.print(">>> ");
                            response = in.next();
                            if (response.equals("1")){
                                products.add(temp_loan);
                                System.out.println("Successfully added product.\n");
                                break;
                            }
                            else if (response.equals("0")){
                                temp_loan = null;
                                break;
                            }
                            else{
                                System.out.println("[!]Error: Invalid response.");
                                continue;
                            }
                        }//verification while
                        break; //stops outside while loop

                    }//product type=loan
                    else if (type.equals("2")){
                        double com_rate = -1;
                        for(;;){
                            System.out.print("Enter credit card's commission rate: ");
                            com_rate = in.nextDouble();
                            System.out.println();
                            if (com_rate <= 0 || com_rate > 1){
                                System.out.println("[!]Error: Invalid credit card commission rate.");
                                continue;
                            }
                            else{
                                break;
                            }
                        }//commission rate verification loop

                        double max_amount = -1;
                        for(;;){
                            System.out.print("Enter credit card's maximum amount per transaction: ");
                            max_amount = in.nextDouble();
                            System.out.println();
                            if (max_amount<=0){
                                System.out.println("[!]Error: Invalid credit card maximum amount per transaction.");
                                continue;
                            }
                            else{
                                break;
                            }
                        }//max amount per transaction verification loop

                        double yearly_amount = -1 ;
                        for(;;){
                            System.out.print("Enter credit card's maximum yearly amount : ");
                            yearly_amount = in.nextDouble();
                            System.out.println();
                            if (yearly_amount<=0 || yearly_amount < max_amount){
                                System.out.println("[!]Error: Invalid credit card maximum yearly amount.");
                                continue;
                            }
                            else{
                                break;
                            }
                        }//max yearly amount verification loop

                        //User confirmation
                        CreditCard temp_cc = new CreditCard(id, afm, num, com_rate, max_amount, yearly_amount);

                        while (true){
                            System.out.println("Do you want to continue with the addition of this credit card? [1]-> Yes, [0]-> No.\n"
                            + temp_cc.toString());
                            System.out.print(">>> ");
                            response = in.next();
                            if (response.equals("1")){
                                products.add(temp_cc);
                                System.out.println("Successfully added item.\n");
                                break;
                            }
                            else if (response.equals("0")){
                                temp_cc = null;
                                break;
                            }
                            else{
                                System.out.println("[!]Error: Invalid response.");
                                continue;
                            }
                        }//verification while
                        break; //stops outside while loop

                    }//product type=credit card
                    else{
                        System.out.println("[!]Error: Invalid response");
                        continue; //continues outside while loop
                    }
                }//verification while loop

            }//if2
            else if (response.equals("3")){
                sellers.printSellers();
                System.out.println();
                String seller_id;
                for(;;){
                    System.out.print("Enter the seller's id from the list: ");
                    seller_id = in.next();
                    System.out.println();
                    if (sellers.findId(seller_id) == false){
                        System.out.println("[!]Error: Seller id does not exist.");
                        continue;
                    }
                    else{
                        break;
                    }
                }//verification for loop

                String product_id;

                while(true){
                    products.printLoans();
                    products.printCreditCards();
                    System.out.print("Enter product's id: ");
                    product_id = in.next();
                    System.out.println();
                    if (products.findId(product_id)){
                        break;
                    }
                    else{
                        System.out.println("[!]Error: Product id does not exist");
                        continue;
                    }
                }//verification while loop
                String reason;
                reason = System.console().readLine("Enter the reason of this sale: ");

                //User confirmation
                Sale temp_sale = new Sale(seller_id, product_id, reason);

                while (true){
                    System.out.println("Do you want to continue with the addition of this sale? [1]-> Yes, [0]-> No.\n"
                    + temp_sale.toString());
                    System.out.print(">>> ");
                    response = in.next();
                    if (response.equals("1")){
                        sales.add(temp_sale);
                        System.out.println("Successfully added product.\n");
                        break;
                    }
                    else if (response.equals("0")){
                        temp_sale = null;
                        break;
                    }
                    else{
                        System.out.println("[!]Error: Invalid response.");
                        continue;
                    }
                }//verification while

            }//if3
            else if (response.equals("4")){
                products.printCreditCards();
                System.out.println();
                String key;

                for(;;){
                    System.out.print("Enter credit card's key: ");
                    key = in.next();
                    System.out.println();
                    if (products.findKey(key)){
                        break;
                    }
                    else{
                        System.out.println("[!]Error: Credit card key does not exist.");
                    }
                }


                double amount = 0;
                for (;;){
                    System.out.print("Enter transaction amount ([!] Positive amounts for deposit, negative amounts for withdrawal [!]): ");
                    amount = in.nextDouble();
                    System.out.println();
                    if (amount == 0){
                        System.out.println("[!]Error: Transaction amount cannot be 0.");
                        continue;
                    }
                    else if(amount != 0){
                        if (amount > 0){
                            products.getProduct(key).deposit(amount);
                            if (products.getProduct(key).getError()){
                                continue;
                            }
                        }
                        else{
                            products.getProduct(key).withdraw(-amount);
                            if (products.getProduct(key).getError()){
                                continue;
                            }
                        }
                        break;
                    }

                }//verification for loop

                String reason;
                reason = System.console().readLine("Enter the reason of this transaction: ");
                System.out.println();

                //User confirmation
                CreditCardTransaction temp_cct= new CreditCardTransaction(key, amount, reason);

                while (true){
                    System.out.println("Do you want to continue with the addition of this credit card transaction? [1]-> Yes, [0]-> No.\n"
                    + temp_cct.toString());
                    System.out.print(">>> ");
                    response = in.next();
                    if (response.equals("1")){
                        cctransactions.add(temp_cct);
                        System.out.println("Successfully added item.\n");
                        break;
                    }
                    else if (response.equals("0")){
                        temp_cct = null;
                        break;
                    }
                    else{
                        System.out.println("[!]Error: Invalid response.");
                        continue;
                    }
                }//verification while
                
            }//if4
            else if (response.equals("5")){
                products.printLoans();

            }//if5
            else if (response.equals("6")){
                String seller_key = verifiedInputSeller();
                double sum = calcSellerCommission(seller_key,true);
                System.out.printf("%s %.2f", "Seller's total commission is:", sum);

            }//if6
            else if (response.equals("7")){
                String seller_key = verifiedInputSeller();
                System.out.println("Printing all related credit card transactions...\n");   
                for (Sale sale : sales.getList().values()){
                    if (sale.getSellerId().equals(sellers.getSellerId(seller_key))){
                        for (Product product : products.getList().values()){
                            if (product instanceof CreditCard && sale.getProductId().equals(product.getId())){
                                for (CreditCardTransaction cct : cctransactions.getList().values()){
                                    if (product.getKey().equals(cct.getCardKey())){
                                        System.out.println(cct);
                                    }
                                }
                            }
                        }
                    }
                }

            }//if7
            else if (response.equals("8")){
                double sum = 0;
                for (Seller seller : sellers.getList().values()){
                    sum += calcSellerCommission(seller.getKey(),true);
                }
                System.out.printf("%s %.2f","Total commission for all sellers is: ", sum);

            }//if8
            else if (response.equals("9")){
                double total_sum = 0;
                for (Seller seller: sellers.getList().values()){
                    double sum = 0;
                    sum += calcSellerCommission(seller.getKey(),false);
                    System.out.println(seller.toString2(sum));
                    total_sum += sum;
                }
                System.out.printf("%s %.2f","Total commission for all sellers is: ", total_sum);

            }//if9
            else{
                System.out.println("[!]Error: Input must be an integer (0-9).");
            }//if input is not integer 0-9

        }//main for-loop
        in.close();

    }//main method


    public static double calcSellerCommission(String seller_key, boolean print){
        //methodos upologismou promhtheiwn enos pwlhth me bash to kleidi toy, me 2 leitourgeies
        double sum = 0;
        if (print){
            for(Sale sale : sales.getList().values()){
                if(sellers.getSellerId(seller_key).equals(sale.getSellerId())){
                    for (Product product : products.getList().values()){
                        if (sale.getProductId().equals(product.getId())){
                            if (product instanceof CreditCard){
                                product.setCCTs(cctransactions);
                                System.out.print("Seller's " + sellers.getSellerId(seller_key) + " commission from credit card '" + product.getId() + "'" + " is: ");
                                System.out.printf("%.2f%n",product.calcCommission());
                                sum += product.calcCommission();
                            }
                            else if (product instanceof Loan){
                                System.out.print("Seller's " + sellers.getSellerId(seller_key) + " commission from loan '" + product.getId() + "'" + " is: ");
                                System.out.printf("%.2f%n",product.calcCommission());
                                sum += product.calcCommission();
                            }
                        }
                    }
                }
            }
        }//if print=true print extra flavor text

        else{
            for(Sale sale : sales.getList().values()){
                if(sellers.getSellerId(seller_key).equals(sale.getSellerId())){
                    for (Product product : products.getList().values()){
                        if (sale.getProductId().equals(product.getId())){
                            if (product instanceof CreditCard){
                                product.setCCTs(cctransactions);
                                sum += product.calcCommission();

                            }
                            else{
                                sum += product.calcCommission();
                            }
                        }
                    }
                }
            }
        }//if print=false only calculate

        return sum;

    }//calcSellerCommission function
    
    public static String verifiedInputSeller(){
        //methodos gia elegxomenh eisodo swstou kleidiou pwlhth
        Scanner in = new Scanner(System.in);
        sellers.printSellers();
        String key;
        for(;;){
            System.out.print("Enter the seller's key from the list: ");
            key = in.next();
            System.out.println();
            if (sellers.findKey(key) == false){
                System.out.println("[!]Error: Seller key does not exist.");
                continue;
            }
            else{
                break;
            }
        }//verification for loop
        return key;
    }//verifiedInputSeller function

    public static void readFile (String file_name) {
        try{
            BufferedReader r = new BufferedReader(new FileReader(file_name));
            String line = r.readLine();
            while (line!=null){

                StringTokenizer st = new StringTokenizer(line, "|");
                String obj_type = st.nextToken();

                if (obj_type.contains("Loan") || obj_type.equals("CreditCard")){

                    String product_id = st.nextToken();
                    String cus_afm = st.nextToken();
                    int cus_num = Integer.parseInt(st.nextToken());

                    if (obj_type.contains("Loan")){
                        Double amount = Double.parseDouble(st.nextToken());
                        String key = st.nextToken();
                        Loan loan = new Loan(product_id, cus_afm, cus_num, amount);
                        loan.setKey(key);
                        products.add(loan);


                    }//obj = loan
                    if (obj_type.equals("CreditCard")){
                        double com_rate = Double.parseDouble(st.nextToken());
                        double max_amount = Double.parseDouble(st.nextToken());
                        double yearly_amount = Double.parseDouble(st.nextToken());
                        double bal = Double.parseDouble(st.nextToken());
                        double total_trasn_amount = Double.parseDouble(st.nextToken());
                        String key = st.nextToken();
                        CreditCard cc = new CreditCard(product_id, cus_afm, cus_num, com_rate, max_amount, yearly_amount);
                        cc.setBalance(bal);
                        cc.setTotalTransactedAmount(total_trasn_amount);
                        cc.setKey(key);
                        products.add(cc);


                    }//obj = cc
                }//obj = product

                else if (obj_type.contains("Seller")){
                    String id = st.nextToken();
                    String firstname = st.nextToken();
                    String lastname = st.nextToken();
                    String afm = st.nextToken();
                    sellers.add(new Seller(id, firstname, lastname, afm));
                }//obj = seller

                else if (obj_type.equals("CreditCardTransaction")){
                    String cckey = st.nextToken();
                    double amount = Double.parseDouble(st.nextToken());
                    String reason = st.nextToken();
                    cctransactions.add(new CreditCardTransaction(cckey, amount, reason));
                }//obj = cctransaction

                else if (obj_type.contains("Sale")){
                    String sel_id = st.nextToken();
                    String pro_id = st.nextToken();
                    String reason = st.nextToken();
                    sales.add(new Sale(sel_id, pro_id, reason));
                }//obj = sale

                else{
                    throw new Exception("Error: Invalid object type read.");
                }//obj = unknown

                line = r.readLine(); //diabazoyme pali line gia na sunexisei to while loop
            }//while
            r.close();

        }//try
        catch (FileNotFoundException fe){
            System.out.println("[!]Error: File '" + file_name + "' not found.");
        }
        catch (Exception e){
            System.out.println("[!]Error: An error occured when reading the file...");
            System.out.println(e);
        }

    }//readFile function

    public static void writeFile(String file_name){
        try{
            if((file_name).contains("products")){
                int counter = 0;
                FileWriter writer=new FileWriter(file_name, false);
                for (Product product: products.getList().values()){
                    counter++;
                    if(product instanceof CreditCard){
                    writer.write("CreditCard"
                    +"|"+product.getId()
                    +"|"+product.getAfm()
                    +"|"+product.getCusNum()
                    +"|"+((CreditCard)product).getCom()
                    +"|"+((CreditCard)product).getMaxAmount()
                    +"|"+((CreditCard)product).getYearlyAmount()
                    +"|"+((CreditCard)product).getBalance()
                    +"|"+((CreditCard)product).getTotalTransactedAmount()
                    +"|"+product.getKey()
                    );
                    
                    }//CreditCard
                    else if(product instanceof Loan){
                    writer.write("Loan"
                    +"|"+product.getId()
                    +"|"+product.getAfm()
                    +"|"+product.getCusNum()
                    +"|"+((Loan)product).getAmount()
                    +"|"+product.getKey()
                    );
                    }//Loan 
                    

                    if(counter<products.getList().size()){
                        writer.write("\n");
                    }


                }//for
                writer.close();
            }//Product
            else if((file_name).contains("sellers")){
                FileWriter writer=new FileWriter(file_name, false);
                int counter = 0;
                for(Seller seller:sellers.getList().values()){
                    counter++;
                        writer.write("Seller"
                        +"|"+seller.getId()
                        +"|"+seller.getFirstName()
                        +"|"+seller.getLastName()
                        +"|"+seller.getAfm()
                        );


                        if(counter<sellers.getList().size()){
                            writer.write("\n");
                        }
                }//for
                writer.close();
            }//Seller
            else if((file_name).contains("sales")){
                FileWriter writer=new FileWriter(file_name, false);
                int counter = 0;
                for(Sale sale:sales.getList().values()){
                    counter++;
                    writer.write("Sale"
                    +"|"+sale.getSellerId()
                    +"|"+sale.getProductId()
                    +"|"+sale.getReason()
                    );


                    if(counter<sales.getList().size()){
                        writer.write("\n");
                    }
                }//for
                writer.close();
            }//Sale
            else if((file_name).contains("cct")){
                FileWriter writer=new FileWriter(file_name, false);
                int counter = 0;
                for (CreditCardTransaction cct: cctransactions.getList().values()){
                    counter++;
                    writer.write("CreditCardTransaction"
                    +"|"+cct.getCardKey()		
                    +"|"+cct.getTransactionAmount()
                    +"|"+cct.getReason()
                    );


                    if(counter<cctransactions.getList().size()){
                        writer.write("\n");
                    }
                }//for
                writer.close();
            }//CCTransaction
        }//try
        catch (Exception e) {
            System.err.println("[!]Error: An error occured when writing the file...");
        }
}
        
}//mainApp class