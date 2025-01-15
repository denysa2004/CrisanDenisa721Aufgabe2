package model;

/**
 * class product with the foloowings attributes
 */
public class Produkt implements HasID{

    private int id;
    private String name;
    private int price;
    private String herkunftsregion;

    public Produkt(int id, String name, int price, String herkunftsregion) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.herkunftsregion = herkunftsregion;
    }


    @Override
    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getHerkunftsregion() {
        return herkunftsregion;
    }

    public void setHerkunftsregion(String herkunftsregion) {
        this.herkunftsregion = herkunftsregion;
    }

    @Override
    public String toString() {
        return "Produkt{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", herkunftsregion='" + herkunftsregion + '\'' +
                '}';
    }
}
