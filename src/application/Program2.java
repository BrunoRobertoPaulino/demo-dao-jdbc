package application;

import java.util.List;
import java.util.Scanner;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DepartmentDao departmentDao = DaoFactory.createDepartment();

		System.out.println("=== TEST 1: department findById ====");
		
		Department department = departmentDao.findById(1);
		
		System.out.println(department);
		
		System.out.println("\n=== TEST 2: department findAll ====");
		
		List<Department> list = departmentDao.findAll();
		
		list.forEach(System.out::println);
		
		System.out.println("\n=== TEST 3: department insert ====");
		
		Department newDepartment = new Department(null, "Music");
		
		departmentDao.insert(newDepartment);
		
		System.out.println("Inserted! New ID: " + newDepartment.getId());
		
		System.out.println("\n=== TEST 4: department update ====");
		
		Department dep2 = departmentDao.findById(1);
		dep2.setName("Food");
		departmentDao.update(dep2);
		System.out.println("Update completed");
		
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		
		departmentDao.deleteById(id);
		
		System.out.println("Delete completed");
		
		sc.close();
	}

}
