package Services;

import Daos.ProductDao;
import Models.Product;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProductService {
    public static ArrayList<Product> ShowProduct() throws SQLException {
        return ProductDao.SelectProduct();
    }
    public static ArrayList<Product> ShowTopSale() throws SQLException {
        return ProductDao.SelectTopSellerProduct();
    }
    public static ArrayList<Product> ShowAllProduct() throws SQLException {
        return ProductDao.SelectAllProduct();
    }
    public static ArrayList<Product> FindPrice(int a,int b) throws SQLException {
        return ProductDao.FindPrice(a,b);
    }
    public static ArrayList<Product> FindSize(String size) throws SQLException {
        return ProductDao.FindSize(size);
    }
    public static Product SelectOneProduct(String id) throws SQLException {
        return ProductDao.SelectOneProduct(id);
    }
}
