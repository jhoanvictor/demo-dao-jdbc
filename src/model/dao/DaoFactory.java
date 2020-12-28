package model.dao;

import db.DB;
import model.dao.implementation.DepartamentDaoJDBC;
import model.dao.implementation.SellerDaoJDBC;

public class DaoFactory {

	public static SellerDao createSellerDao() {
		return new SellerDaoJDBC(DB.getConnection());
	}

	public static DepartmentDao createDepartmentDao() {
		return new DepartamentDaoJDBC(DB.getConnection());
	}

}
