package StoreProcess;

import Products.*;
import Products.processes.TechProductProcess;
import java.util.*;
public class MyStore {
    public static List<Brand> brands = new ArrayList<>();
    public static List<TechProduct> mobilePhones = new ArrayList<>();
    public static List<TechProduct> notebooks = new ArrayList<>();
    TechProductProcess techProductProcess = createTechProcessObj();
    Scanner scanner = new Scanner(System.in);

    private static MyStore myStore;
    private MyStore(){
        autoAddConstant();
    }
    public static MyStore getSingleInstance(){
        if(myStore == null){
            myStore = new MyStore();
        }
        return myStore;
    }
    public void start() throws Exception {

        while (true){
            System.out.println("MyStore Product Management Panel!");
            System.out.println("---------------------------------");
            System.out.println("1. Notebook Process");
            System.out.println("2. Mobile Phone Process");
            System.out.println("3. List Brands");
            System.out.println("4. Exit");
            System.out.print(": ");
            int input = scanner.nextInt();
            switch (input){
                case 1:
                    accessTechProductProcess(notebooks,"Notebook");
                    break;
                case 2:
                    accessTechProductProcess(mobilePhones,"Mobile Phone");
                    break;
                case 3:
                    listBrands(brands);
                    scanner.nextLine();
                    System.out.println("Press any key...");
                    scanner.nextLine();
                    break;
                case 4:
                    String s = "g...";
                    System.out.print("Exitin");
                    for(int i = 0 ; i < s.length(); i++){
                        System.out.print(s.charAt(i));
                        Thread.sleep(1000); // Here is just for fun, like it is updating something and preparing for closing the project.
                    }
                    System.out.println(" GOOD BYE");
                    break;
            }
            if (input == 4){
                break;
            }
        }
    }
    public static void autoAddConstant(){
        brands.add(new Brand(0,"Lenovo"));
        brands.add(new Brand(1,"Apple"));
        brands.add(new Brand(2,"Huawei"));
        brands.add(new Brand(3,"Casper"));
        brands.add(new Brand(4,"Asus"));
        brands.add(new Brand(5,"Hp"));
        brands.add(new Brand(6,"Xiaomi"));
        brands.add(new Brand(7,"Monster"));
        brands.sort(Comparator.comparing(Brand::getName));

        notebooks.add(new Notebook(1,"Apple M2",123999f,0,1, "Apple",8192,64,16f,0,0));
        notebooks.add(new Notebook(2,"Monster Semruk S7 V8.1.2",149999f,0,1, "Monster",6144,128,17.3f,0,0));
        notebooks.add(new Notebook(3,"Casper Excalibur G911",80590f,0,1, "Casper",500,16,16f,0,0));

        mobilePhones.add(new MobilePhone(1,"Apple iPhone X",11999f,0,1, "Apple",64,3,5.8f,2716,12));
        mobilePhones.add(new MobilePhone(2,"Xiaomi Redmi Note 11",5449f,0,1, "Xiaomi",128,4,6.43f,5000,50));
        mobilePhones.add(new MobilePhone(3,"Huawei Nova Y70",4999f,0,1, "Huawei",128,4,6.75f,6000,48));

    }

    public static TechProductProcess createTechProcessObj(){
        return TechProductProcess.getSingleInstance();
    }

    public void accessTechProductProcess(List<TechProduct> list, String product) {
        while (true){
            System.out.println( product + " Processes");
            System.out.println("------------------------------------");
            System.out.println("1. List " + product + " (order by id)");
            System.out.println("2. List " + product +" (order by name)");
            System.out.println("3. Add " + product);
            System.out.println("4. Remove " + product);
            System.out.println("5. Home Page");
            System.out.print(": ");

            int input = scanner.nextInt();
            switch (input){
                case 1:
                    techProductProcess.sortProductByID(list);
                    techProductProcess.showProduct(list);
                    break;
                case 2:
                    techProductProcess.sortProductByName(list);
                    techProductProcess.showProduct(list);
                    break;
                case 3:
                    techProductProcess.addNew(list, product);
                    break;
                case 4:
                    techProductProcess.sortProductByID(list);
                    techProductProcess.showProduct(list);
                    techProductProcess.removeProduct(list);
                    break;
                case 5:
                    System.out.println("---------------------------------");
            }
            if (input == 5){
                break;
            }
        }
    }
    public static void listBrands(List<Brand> list){
        System.out.println("--------------------------");
        System.out.printf("%-23s ** %n", "**        BRANDS");
        System.out.println("--------------------------");
        for (Brand brand : list){
            System.out.printf("%-24s | %n" , "| " + brand.getName());
        }
        System.out.println("--------------------------");
    }
}

