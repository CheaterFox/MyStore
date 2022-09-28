package StoreProcess;

public class Main {
    public static void main(String[] args) throws Exception {
        MyStore myStore = MyStore.getSingleInstance();
        myStore.start();
    }
}
