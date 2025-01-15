package model;

import java.util.List;

public class Charaktere implements HasID {
    private Integer id;
    private String name;
    private String ort;
    List<Produkt> orederdProducts;

    @Override
    public String toString() {
        return "Charaktere{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ort='" + ort + '\'' +
                ", orederdProducts=" + orederdProducts +
                '}';
    }

    public Charaktere(Integer id, String name, String ort, List<Produkt> orederdProducts) {
        this.id = id;
        this.name = name;
        this.ort = ort;
        this.orederdProducts = orederdProducts;
    }


    @Override
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOrt() {
        return ort;
    }

    public void setOrt(String ort) {
        this.ort = ort;
    }

    public List<Produkt> getOrederdProducts() {
        return orederdProducts;
    }

    public void setOrederdProducts(List<Produkt> orederdProducts) {
        this.orederdProducts = orederdProducts;
    }
}
