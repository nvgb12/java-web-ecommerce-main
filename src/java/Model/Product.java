/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author HOME PC
 */
public class Product {
    private int id;
    private String title;
    private String description;
    private String brand;
    private String color;
    private String size;
    private String type;
    private double price;
    private int releaseDate;
    private String imageURL;

    public Product() {
    }

    public Product(String title, String brand, String color, String size, String type) {
        this.title = title;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.type = type;
    }

    
    
    public Product(String title, String description, String brand, String color, String size, String type, double price, int releaseDate, String imageURL) {
        this.title = title;
        this.description = description;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.type = type;
        this.price = price;
        this.releaseDate = releaseDate;
        this.imageURL = imageURL;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(int releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", title=" + title + ", description=" + description + ", brand=" + brand + ", color=" + color + ", size=" + size + ", type=" + type + ", price=" + price + ", releaseDate=" + releaseDate + ", imageURL=" + imageURL + '}';
    }
    
}
