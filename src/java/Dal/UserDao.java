/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dal;

import Model.User;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author HOME PC
 */
public class UserDao extends DBContext {

    public List<User> getAllUser() {
        List<User> list = new ArrayList<>();
        String query = "select * from users";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                User obj = new User();
                obj.setId(rs.getInt("id"));
                obj.setEmail(rs.getString("email"));
                obj.setPassword("password");
                obj.setFirstName(rs.getString("firstName"));
                obj.setLastName(rs.getString("lastName"));
                obj.setGender(rs.getInt("gender"));
                obj.setAddress(rs.getString("address"));
                obj.setRole(rs.getInt("role"));
                list.add(obj);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public int createUser(User user) {
        String email = user.getEmail();
        String password = user.getPassword();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        int gender = user.getGender();
        String address = user.getAddress();
        int role = 0;
        String query = "insert into users values (N'" + email + "',N'" + password + "',N'" + firstName + "',N'" + lastName + "'," + gender + ",N'" + address + "'," + role + ")";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            int affected = ps.executeUpdate();
            return affected;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return 0;
    }

    public User getUserByEmail(String email) {
        User user = null;
        String query = "Select * from users where email = N'" + email + "'";
        try {

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword("password");
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setGender(rs.getInt("gender"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return user;
    }

    public User getUserById(int id) {
        User user = null;
        String query = "Select * from users where id = N'" + id + "'";
        try {

            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword("password");
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setGender(rs.getInt("gender"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return user;
    }

    public User LoginValidate(String password, String email) {
        User user = null;
        String query = "Select * from users where email = N'" + email + "' and password = N'" + password + "'";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getInt("id"));
                user.setEmail(rs.getString("email"));
                user.setPassword("password");
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setGender(rs.getInt("gender"));
                user.setAddress(rs.getString("address"));
                user.setRole(rs.getInt("role"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
        return user;
    }

    public int updatePassword(String email, String password) {
        String query = "update users set password =N'" + password + "' where email = N'" + email + "'";
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
        return 0;
    }

    public int updateUser(User user) {
        String query = "update users set firstName =N'" + user.getFirstName() + "', lastName =N'" + user.getLastName() + "', email =N'" + user.getEmail() + "', address =N'" + user.getAddress() + "', gender =" + user.getGender() + " where id = " + user.getId();
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int deleteUserById(int id) {
        String query = "delete from users where id = " + id;
        try {
            PreparedStatement ps = connection.prepareStatement(query);
            return ps.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return 0;
        }
    }

    public int getAmountOfUser() {
        String query = "Select count(*) as sum from Users";
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
