package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import db.DB;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		DepartmentDao depDao = DaoFactory.createDepartmentDao();

		System.out.println("--- TEST 1: Department FindById ---");
		Department department = depDao.findById(3);
		System.out.println(department);

		System.out.println("--- TEST 2: Department FindAll ---");
		List<Department> lista = new ArrayList<Department>();
		lista = depDao.findAll();

		for (Department department2 : lista) {
			System.out.println(department2);
		}

		System.out.println("--- TEST 3: Department Insert ---");
		Department dep = new Department(null, "Games");
		depDao.insert(dep);
		System.out.println("Inserted! New id = " + dep.getId());

		System.out.println("--- TEST 4: Department Update ---");
		department.setName("Music");
		depDao.update(department);
		System.out.println("Update completed!");
		
		System.out.println("\n--- TEST 6: Seller Delete ---");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		depDao.delete(id);
		System.out.println("Deleted complete!");

		DB.closeConnection();
	}

}
