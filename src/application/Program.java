package application;

import java.util.Date;
import java.util.List;

import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("--- TEST 1: Seller FindById ---");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n--- TEST 2: Seller FindByDepartment ---");
		List<Seller> list = sellerDao.findByDepartment(new Department(2, null));

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n--- TEST 3: Seller FindAll ---");
		list = sellerDao.findAll();

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n--- TEST 4: Seller Insert ---");
		Seller seller2 = new Seller(null, "Greg", "greg@email.com", new Date(), 4500.0, new Department(2, null));
		sellerDao.insert(seller2);
		System.out.println("Inserted! New id = " + seller2.getId());

	}

}
