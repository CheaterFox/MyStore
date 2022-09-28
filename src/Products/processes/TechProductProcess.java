package Products.processes;

import Products.MobilePhone;
import Products.Notebook;
import Products.TechProduct;
import StoreProcess.MyStore;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TechProductProcess {
    private static TechProductProcess techProductProcess;
    private TechProductProcess(){
    }
    public static TechProductProcess getSingleInstance(){
        if(techProductProcess == null){
            techProductProcess = new TechProductProcess();
        }
        return techProductProcess;
    }
    Scanner scanner = new Scanner(System.in);
    public void addNew(List<TechProduct> list, String productName) {
        try{
            System.out.println("--------------------------");
            System.out.println("Please write the information about the product below.");
            System.out.print("Name : ");
            String name = scanner.nextLine();
            System.out.print("Price : ");
            float price = scanner.nextFloat();
            System.out.print("Discount Rate : ");
            float discountRate = scanner.nextFloat();
            System.out.print("Stock : ");
            int stock = scanner.nextInt();
            System.out.println("** Brands **");
            System.out.println("-----------------------------");
            MyStore.listBrands(MyStore.brands);
            System.out.print("Choose Brand from the list : ");
            scanner.nextLine(); // Here is for taking the value after the nextInt
            String brand = scanner.nextLine();
            System.out.print("Storage : ");
            int storage = scanner.nextInt();
            System.out.print("RAM : ");
            int ram = scanner.nextInt();
            System.out.print("Screen Size : ");
            float screenSize = scanner.nextFloat();
            System.out.print("Battery Power : ");
            float battery = scanner.nextFloat();
            System.out.print("Camera Pixel : ");
            int camera = scanner.nextInt();
            int id = list.size() + 1;
            if (productName.equalsIgnoreCase("Mobile Phone")){
                list.add(new MobilePhone(id,name,price,discountRate,stock,brand,storage,ram,screenSize,battery,camera));
                System.out.println("New " + productName + " added to list.");
            } else if (productName.equalsIgnoreCase("Notebook")) {
                list.add(new Notebook(id,name,price,discountRate,stock,brand,storage,ram,screenSize,battery,camera));
                System.out.println("New " + productName + " added to list.");
            }
            else {
                System.out.println("Can not find the product");
            }
        }
        catch (Exception e){
            System.out.println(e);
        }

    }
    public void showProduct(List<TechProduct> list){
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-5s |", "| ID " );
        System.out.printf("%-25s |", " Product's Name ");
        System.out.printf("%-10s |", " Price ");
        System.out.printf("%-10s |", " Brand ");
        System.out.printf("%-10s |", " Storage ");
        System.out.printf("%-10s |", " Screen ");
        System.out.printf("%-10s |", " RAM ");
        System.out.printf("%-10s |", " Camera ");
        System.out.printf("%-10s |", " Battery ");
        System.out.printf("%-10s | %n", " Colour ");
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");

        for (TechProduct product : list){
            System.out.printf("%-5s |", "| " + product.getId());
            System.out.printf("%-25s |", " " + product.getName());
            System.out.printf("%-10s |", " " + product.getPrice());
            System.out.printf("%-10s |", " " + product.getBrand());
            System.out.printf("%-10s |", " " + product.getStorage());
            System.out.printf("%-10s |", " " + product.getScreenSize());
            System.out.printf("%-10s |", " " + product.getRam());
            System.out.printf("%-10s |", " " + product.getCameraPixel());
            System.out.printf("%-10s |", " " + product.getBatteryPower());
            System.out.printf("%-10s | %n", " " + product.getColour());

        }
        System.out.println("----------------------------------------------------------------------------------------------------------------------------------");
    }
    public void sortProductByName(List<TechProduct> list){
        list.sort(Comparator.comparing(TechProduct::getName));
    }
    public void sortProductByID(List<TechProduct> list){
        list.sort(Comparator.comparing(TechProduct::getId));
    }
    public void removeProduct(List<TechProduct> list){
        int i = 0;
        System.out.println("Which product do you want to remove ?");
        System.out.println("You can write the id of product to remove!");
        System.out.print(": ");
        int index = scanner.nextInt();
        for (TechProduct phone : list){
            if (index == phone.getId()){
                list.remove(i);
                System.out.println("Product removed from the list");
                System.out.println("------------------------------------");
                i++;
                break;
            }
            i++;
        }
        if (list.size() == i){
            System.out.println("There is no product matching the id you entered");
        }
    }
}
