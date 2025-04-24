/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.Product;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author HOME PC
 */
public class ProductDao extends DBContext {

    private List<Product> productMapper(ResultSet rs, List<Product> result) throws SQLException {
        while (rs.next()) {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setTitle(rs.getString("title"));
            product.setDescription(rs.getString("description"));
            product.setBrand(rs.getString("brand"));
            product.setColor(rs.getString("color"));
            product.setSize(rs.getString("size"));
            product.setType(rs.getString("type"));
            product.setPrice(rs.getDouble("price"));
            product.setReleaseDate(rs.getInt("releaseDate"));
            product.setImageURL(rs.getString("imageURL"));
            result.add(product);
            System.out.println(product);
        }
        return result;
    }

    public List<Product> getLatestProduct() {
        List<Product> result = new ArrayList<>();
        String query = "Select * from Products where id >5 ";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            result = productMapper(rs, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Product> getMostBoughtProduct() {
        List<Product> result = new ArrayList<>();
        String query = "select Top 8 a.* from products a join (select productId as id,count(userId) as amount from carts group by productId) as b on a.id = b.id order by b.amount desc";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            result = productMapper(rs, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Product> getLuxuryProduct() {
        List<Product> result = new ArrayList<>();
        String query = "select top 8 * from products order by price desc";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            result = productMapper(rs, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Product> getRelatedProduct(String type) {
        List<Product> result = new ArrayList<>();
        String query = "select top 8 * from products where type like N'%+" + type + "+%'";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            result = productMapper(rs, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public List<Product> search(Product product) {
        List<Product> result = new ArrayList<>();
        String subQuery = "";
        if (product.getTitle() != null && !product.getTitle().isBlank()) {
            subQuery += " title like N'%" + product.getTitle() + "%' ";
        }
        if (product.getBrand() != null && !product.getBrand().isBlank()) {
            if (!subQuery.isBlank()) {
                subQuery += " and ";
            }
            subQuery += " brand like N'%" + product.getBrand() + "%' ";
        }
        if (product.getColor() != null && !product.getColor().isBlank()) {
            if (!subQuery.isBlank()) {
                subQuery += " and ";
            }
            subQuery += " color like N'%" + product.getColor() + "%' ";
        }
        if (product.getSize() != null && !product.getSize().isBlank()) {
            if (!subQuery.isBlank()) {
                subQuery += " and ";
            }
            subQuery += " size like N'%" + product.getSize() + "%' ";
        }
        if (product.getType() != null && !product.getType().isBlank()) {
            if (!subQuery.isBlank()) {
                subQuery += " and ";
            }
            subQuery += " type like N'%" + product.getType() + "%' ";
        }
        if (!subQuery.isBlank()) {
            subQuery = " where " + subQuery;
        }
        String query = "Select * from products " + subQuery;

        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            result = productMapper(rs, result);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Product productMapper(ResultSet rs) throws SQLException {
        Product product = new Product();
        while (rs.next()) {
            product.setId(rs.getInt("id"));
            product.setTitle(rs.getString("title"));
            product.setDescription(rs.getString("description"));
            product.setBrand(rs.getString("brand"));
            product.setColor(rs.getString("color"));
            product.setSize(rs.getString("size"));
            product.setType(rs.getString("type"));
            product.setPrice(rs.getDouble("price"));
            product.setReleaseDate(rs.getInt("releaseDate"));
            product.setImageURL(rs.getString("imageURL"));
        }
        return product;
    }

    public Product getProductById(int id) {
        String query = "select * from products where id = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            return productMapper(rs);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public int addProductToCart(int productId, int userId) {
        String query = "insert into carts values (" + userId + "," + productId + ")";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public List<Product> getUserCart(int userId) {
        String query = "Select * from carts where userId = " + userId;
        List<Product> result = new ArrayList<>();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int productId = rs.getInt("productId");
                result.add(getProductById(productId));
            }
            return result;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return result;
        }
    }

    public int deleteProductFromCart(int userId, int productId) {
        String query = "delete from carts where productId = " + productId + " and userId = " + userId;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int getAmountOfProduct() {
        String query = "Select count(*) as sum from Products";
        int result = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getInt("sum");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public int getAmountOfCart() {
        String query = "Select count(*) as sum from Carts";
        int result = 0;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                result = rs.getInt("sum");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return result;
    }
}
