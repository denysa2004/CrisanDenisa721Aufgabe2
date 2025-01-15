import model.Charaktere;
import model.Produkt;
import repository.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * It computes the users choices from the console,
 * gathers information from the inputs introduced by the user and displays messages to the console
 */
public class Controller {


    private final Repository<Charaktere> repoKunde;
    private final Repository<Produkt> repoProduct;


    public Controller(Repository<Charaktere> inMemoryRepositoryKunde, Repository<Produkt> inMemoryRepositoryProdukt) {
        this.repoKunde = inMemoryRepositoryKunde;
        this.repoProduct = inMemoryRepositoryProdukt;
    }

    /**
     * CRUD Operation : get,getAll,create,update,delete
     */

    /**
     * CRUD Operation ->get all
     */
    public void viewKunden() {
        StringBuilder output = new StringBuilder("Alle Kunden:\n");
        repoKunde.getAll().forEach(kunde -> output.append(kunde.toString()).append("\n"));
        System.out.println(output);
    }

    public void viewProdukten() {
        StringBuilder output = new StringBuilder("Available students:\n");
        repoProduct.getAll().forEach(produkt -> output.append(produkt.toString()).append("\n"));
        System.out.println(output);
    }

    /**
     * CRUD OPERATION->delete
     * @param scanner takes the id of the Object we want to delete
     */

    public void deleteKunde(Scanner scanner) {
        System.out.println("Enter the id of the user you want to delete from the system:");
        Integer id = Integer.parseInt(scanner.nextLine());
        repoKunde.delete(id);
    }
    public void deleteProduct(Scanner scanner) {
        System.out.println("Enter the id of the user you want to delete from the system:");
        Integer id = Integer.parseInt(scanner.nextLine());
        repoProduct.delete(id);
    }

    /**
     * CRUD Operation->create
     * @param scanner
     */
    public void createKunde(Scanner scanner) {
        System.out.println("Enter Kunde id:");
        Integer id = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Kunde name:");
        String name = scanner.nextLine();
        System.out.println("Enter Kunde ort:");
        String ort = scanner.nextLine();
        ArrayList<Produkt> productList = new ArrayList<>();
        Charaktere kunde = new Charaktere(id, name, ort, productList);
        repoKunde.create(kunde);
        System.out.println("Kunde created: " + kunde);
    }

    public void createProduct(Scanner scanner) {
        System.out.println("Enter Produkt id:");
        Integer id =Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Produkt name:");
        String name = scanner.nextLine();
        System.out.println("Enter Produkt price:");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.println("Enter Produkt jahreszeit:");
        String jahreszeit = scanner.nextLine();

        Produkt produkt = new Produkt(id,name, price, jahreszeit);
        repoProduct.create(produkt);
        System.out.println("Produkt created: " + produkt);
    }

    /**
     * CRUD Operation-> get
     * @param scanner takes the id of the Object that we want
     */
    public  void getKunde(Scanner scanner) {
        System.out.println("Enter the id of the Kunde you want to get:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Charaktere kunde = repoKunde.get(id);
        if (kunde != null) {
            System.out.println("Kunde found: " + kunde);
        } else {
            System.out.println("Kunde not found with id: " + id);
        }
    }

    public void getProduct(Scanner scanner) {
        System.out.println("Enter the id of the Produkt you want to get:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Produkt produkt = repoProduct.get(id);
        if (produkt != null) {
            System.out.println("Produkt found: " + produkt);
        } else {
            System.out.println("Produkt not found with id: " + id);
        }
    }

    /**
     * CRUD Operation ->update
     * @param scanner takes the id of the Object we want to update
     */

    public void updateKunde(Scanner scanner) {
        System.out.println("Enter the id of the Kunde you want to update:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Charaktere kunde = repoKunde.get(id);
        if (kunde != null) {

            System.out.println("Enter new name for Kunde:");
            String newName = scanner.nextLine();
            System.out.println("Enter new ort for Kunde:");
            String newOrt = scanner.nextLine();

            kunde.setName(newName);
            kunde.setOrt(newOrt);
            repoKunde.update(kunde);
            System.out.println("Kunde updated: " + kunde);
        } else {
            System.out.println("Kunde not found with id: " + id);
        }
    }



    public void updateProduct(Scanner scanner) {
        System.out.println("Enter the id of the Produkt you want to update:");
        Integer id = Integer.parseInt(scanner.nextLine());
        Produkt produkt = repoProduct.get(id);
        if (produkt != null) {
            System.out.println("Enter new name for Produkt:");
            String newname = scanner.nextLine();
            System.out.println("Enter new price for Produkt:");
            int newPrice = Integer.parseInt(scanner.nextLine());
            System.out.println("Enter new jahreszeit for Produkt:");
            String newJahreszeit = scanner.nextLine();

            //cate vrei sa schimbi
            produkt.setName(newname);
            produkt.setPrice(newPrice);


            repoProduct.update(produkt);
            System.out.println("Produkt updated: " + produkt);
        } else {
            System.out.println("Produkt not found with name: " + id);
        }
    }
    //c)
    //filtrare clienti care sunt din orasul dat de la tastatura
    public void filterCustomer(Scanner scanner){
        System.out.println("Enter the name of the city");
        String ort = scanner.nextLine();
        StringBuilder output = new StringBuilder("Kunden :\n");
        List<Charaktere> filterKunden=new ArrayList<>(repoKunde.getAll());
        filterKunden.stream().filter(kunde-> kunde.getOrt().equals(ort)).forEach(kunde -> output.append(kunde).append("\n"));
        System.out.println(output);
    }

}
