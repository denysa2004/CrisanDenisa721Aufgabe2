import model.Charaktere;
import model.Produkt;
import repository.InMemoryRepository;
import repository.Repository;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * The class ConsoleApp represents the implementation of the interface layer.
 * Its sole role is to display relevant text in the console, during runtime.
 */

public class ConsoleApp {
    private final Controller controller;


    public ConsoleApp(Controller controller) {
        this.controller = controller;
    }

    /**
     * Starts the console application, displaying a menu and handling user input.
     */
    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop = true;

        while (continueLoop) {
            System.out.print("""
                    Select an option:
                    
                    1.Get all cutomers
                    2.Get all products
                    3.Delete customer
                    4.Delete product
                    5.Add customer
                    6.Add product
                    7.Update customer
                    8.Update product
                    9.Get customer
                    10. Get product
                    11.filter by ort
                   
                    0. Exit
                    """);

            String option = scanner.nextLine();

            switch (option) {
                case "0":
                    continueLoop = false;
                    break;
                case "1":
                    controller.viewKunden();
                    break;
                case "2":
                    controller.viewProdukten();
                    break;
                case "3":
                    controller.deleteKunde(scanner);
                    break;
                case "4":
                    controller.deleteProduct(scanner);
                     break;

                case "5":
                    controller.createKunde(scanner);
                    break;
                case "6":
                    controller.createProduct(scanner);
                    break;
                case "7":
                    controller.updateKunde(scanner);
                    break;
                case "8":
                    controller.updateProduct(scanner);
                    break;
                case "9":
                    controller.getKunde(scanner);
                    break;
                case "10":
                    controller.getProduct(scanner);
                    break;
                    case "11":
                        controller.filterCustomer(scanner);

                case "12":
                        controller.filterCustomerByProduct(scanner);
                case "13":
                    controller.sortByUser(scanner);
                default:
            }
        }
    }

    /**
     * Start point of the application.
     * This is where the in-memory repositories are created.
     * The controller is then connected to the repos
     * Finally, the application console starts with all the components laid in place.
     */
    
    public static void main(String[] args) {
        Repository<Charaktere> kundenRepo = createInMemoryKundenRepository();
        Repository<Produkt> produktRepo = createInMemoryProduktRepository();


        Controller controller = new Controller(kundenRepo, produktRepo);

        ConsoleApp consoleApp = new ConsoleApp(controller);
        consoleApp.start();

    }

    /**
     * Creates an in-memory repository for ...... and populates it with some initial data.
     *
     * @return The in-memory repository for ........
     */
    private static Repository<Charaktere> createInMemoryKundenRepository() {
        Repository<Charaktere> kundenRepo = new InMemoryRepository<>();
        Produkt produkt1 = new Produkt(1,"Schiuri", 200, "alba");
        Produkt produkt2 = new Produkt(2,"Clapari", 300, "bucuresti");
        Produkt produkt3=new Produkt(3,"Bicicleta",400,"ploiesti");


        // Creăm o listă de produse
        ArrayList<Produkt> productList = new ArrayList<>();
        ArrayList<Produkt> productList1 = new ArrayList<>();
        ArrayList<Produkt> productList2= new ArrayList<>();

        //Adaugam la lista
        productList.add(produkt1);
        productList.add(produkt2);
        productList1.add(produkt3);

        kundenRepo.create(new Charaktere(1,"Maria","Sebes",productList));
        kundenRepo.create(new Charaktere(2,"Denisa","Alba Iulia",productList1));
        kundenRepo.create(new Charaktere(3,"Luciana","Bucuresti",productList2));

        return kundenRepo;


    }

    /**
     * Creates an in-memory repository for ..... and populates it with some initial data.
     *
     * @return The in-memory repository for .......
     */
    private static Repository<Produkt> createInMemoryProduktRepository() {
        Repository<Produkt> produktRepo = new InMemoryRepository<>();
        produktRepo.create(new Produkt(1,"Schiuri",200,"alba"));
        produktRepo.create(new Produkt(2,"Clapari",300,"bucuresti"));
        produktRepo.create(new Produkt(3,"Bicicleta",400,"ploiesti"));

        return produktRepo;
    }
}
