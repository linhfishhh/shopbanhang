package Daos;

import Models.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.util.List;

public class ProductDao {
    static Connection connection=ConnectionSql.getConnection();
    public static ArrayList<Product> SelectProduct() throws SQLException {
        ArrayList<Product> ListProduct=new ArrayList<>();

        String query="SELECT * FROM case_study.product limit 8;";
        PreparedStatement ps=connection.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Product Product=new Product();
            Product.setId(rs.getInt("idproduct"));
            Product.setName(rs.getString("name"));
            Product.setSize(rs.getString("size"));
            Product.setSoluong(rs.getInt("soluong"));
            Product.setVendor(rs.getString("vendor"));
            Product.setPrice(rs.getInt("price"));
            Product.setImage(rs.getString("image"));
            ListProduct.add(Product);
        }
        return ListProduct;
    }
    public static ArrayList<Product> SelectTopSellerProduct() throws SQLException {
        ArrayList<Product> ListProduct=new ArrayList<>();

        String query="select *,count(idproduct) as a from (select * from product left join detail_bill using(idproduct) join bill using(idbill)) as b group by idproduct order by a desc limit 4\n";
        PreparedStatement ps=connection.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Product Product=new Product();
            Product.setId(rs.getInt("idproduct"));
            Product.setName(rs.getString("name"));
            Product.setSize(rs.getString("size"));
            Product.setSoluong(rs.getInt("soluong"));
            Product.setVendor(rs.getString("vendor"));
            Product.setPrice(rs.getInt("price"));
            Product.setImage(rs.getString("image"));
            ListProduct.add(Product);
        }
        return ListProduct;

    }
    public static ArrayList<Product> SelectAllProduct() throws SQLException {
        ArrayList<Product> ListProduct=new ArrayList<>();

        String query="SELECT * FROM case_study.product limit 8;";
        PreparedStatement ps=connection.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Product Product=new Product();
            Product.setId(rs.getInt("idproduct"));
            Product.setName(rs.getString("name"));
            Product.setSize(rs.getString("size"));
            Product.setSoluong(rs.getInt("soluong"));
            Product.setVendor(rs.getString("vendor"));
            Product.setPrice(rs.getInt("price"));
            Product.setImage(rs.getString("image"));
            ListProduct.add(Product);
        }
        return ListProduct;
    }
    public static ArrayList<Product> FindPrice(int a, int b) throws SQLException {
        ArrayList<Product> ListProduct=new ArrayList<>();

        String query="SELECT * FROM case_study.product where price<=? and price>=?;";
        PreparedStatement ps=connection.prepareStatement(query);
        ps.setInt(1,b);
        ps.setInt(2,a);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Product Product=new Product();
            Product.setId(rs.getInt("idproduct"));
            Product.setName(rs.getString("name"));
            Product.setSize(rs.getString("size"));
            Product.setSoluong(rs.getInt("soluong"));
            Product.setVendor(rs.getString("vendor"));
            Product.setPrice(rs.getInt("price"));
            Product.setImage(rs.getString("image"));
            ListProduct.add(Product);
        }
        return ListProduct;
    }
    public static ArrayList<Product> FindSize(String size) throws SQLException {
        ArrayList<Product> ListProduct=new ArrayList<>();

        String query="SELECT * FROM case_study.product where size like '%"+size+"%';";
        PreparedStatement ps=connection.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        while (rs.next()){
            Product Product=new Product();
            Product.setId(rs.getInt("idproduct"));
            Product.setName(rs.getString("name"));
            Product.setSize(rs.getString("size"));
            Product.setSoluong(rs.getInt("soluong"));
            Product.setVendor(rs.getString("vendor"));
            Product.setPrice(rs.getInt("price"));
            Product.setImage(rs.getString("image"));
            ListProduct.add(Product);
        }
        return ListProduct;
    }
    public static Product SelectOneProduct(String id) throws SQLException {
        String query = "SELECT * FROM case_study.product where idproduct=?";
        PreparedStatement ps = connection.prepareStatement(query);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        rs.next();
        Product Product = new Product();
        Product.setId(rs.getInt("idproduct"));
        Product.setName(rs.getString("name"));
        Product.setSize(rs.getString("size"));
        Product.setSoluong(rs.getInt("soluong"));
        Product.setVendor(rs.getString("vendor"));
        Product.setPrice(rs.getInt("price"));
        Product.setImage(rs.getString("image"));
        return Product;
    }
}
