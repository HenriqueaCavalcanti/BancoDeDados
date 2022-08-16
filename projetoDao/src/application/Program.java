package application;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.dao.impl.SellerDaoJDBC;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        Department obj = new Department(1, "Books");
        Seller obj2 = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();
        System.out.println("=== Test 1: seller findById ===");
        Seller seller = sellerDao.findById(4);
        System.out.println(seller);

        System.out.println("=== Test 2: seller findByDepartment ===");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj3 : list) {
            System.out.println(obj3);
        }

        System.out.println("=== Test 3: seller findAll ===");
        list = sellerDao.findAll();
        for (Seller obj3 : list) {
            System.out.println(obj3);
        }
    }
}
