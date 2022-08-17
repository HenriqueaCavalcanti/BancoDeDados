package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.Date;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

        System.out.println("=== Test 1: department insert ===");

        Department department = new Department(null, "transporte");
        departmentDao.insert(department);
        System.out.println("Novo id: " + department.getId());

        System.out.println("=== Test 2: department findById ===");
        Department department1 = departmentDao.findById(17);
        System.out.println(department1);


        System.out.println("=== Test 3: department Update ===");
        department = departmentDao.findById(17);
        department.setName("phone");
        departmentDao.update(department);
        System.out.println("Update completed");


        System.out.println("Enter id for delete test: ");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");


    }
}
