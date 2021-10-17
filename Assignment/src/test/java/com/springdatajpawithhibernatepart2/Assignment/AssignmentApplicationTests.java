package com.springdatajpawithhibernatepart2.Assignment;

import com.springdatajpawithhibernatepart2.Assignment.componentmapping.entities.EmployeeMapping;
import com.springdatajpawithhibernatepart2.Assignment.componentmapping.entities.Salary;
import com.springdatajpawithhibernatepart2.Assignment.componentmapping.repos.EmployeeMappingRepository;
import com.springdatajpawithhibernatepart2.Assignment.inheritance.entities.Check;
import com.springdatajpawithhibernatepart2.Assignment.inheritance.entities.CreditCard;
import com.springdatajpawithhibernatepart2.Assignment.inheritance.repos.PaymentRepository;
import com.springdatajpawithhibernatepart2.Assignment.jpqlandnativesql.entities.Employee;
import com.springdatajpawithhibernatepart2.Assignment.jpqlandnativesql.repos.EmployeeRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AssignmentApplicationTests {

	@Autowired
	EmployeeRepository employeeRepository;

	@Autowired
	EmployeeMappingRepository employeeMappingRepository;

	@Autowired
	PaymentRepository paymentRepository;

	@Test
	void contextLoads() {
	}


	/****************** JPQL Queries *************************/

	@Test
	public void testCreateEmployee(){
		Employee employee = new Employee();
		employee.setAge(26);
		employee.setFirstName("Ritika");
		employee.setLastName("Gautam");
		employee.setSalary(32000);
		employeeRepository.save(employee);
	}

	/*** Display the first name, last name of all employees having salary greater than
	average salary ordered in ascending by their age and in descending by their salary.  **/

	@Test
	public void testFindAllHavingSalaryGreaterThanAvgSalary(){
		List<Object[]> empData = employeeRepository.findAllHavingSalaryGreaterThanAvgSalary();
		for (Object[] emp : empData)
			System.out.println(emp[0] + " " + emp[1]);
	}


	/**** Update salary of all employees by a salary passed as a parameter
	 whose existing salary is less than the average salary. ********/

	@Test
	public void testFindAvgSalary(){
		System.out.println(employeeRepository.findAvgSalary());
	}


	@Test
	@Transactional
	@Rollback(value = false)
	public void testUpdateEmployeesHavingSalaryLessThanAvgSalary(){
		employeeRepository.updateEmployeesHavingSalaryLessThanAvgSalary(85000,
				employeeRepository.findAvgSalary());
	}


	/*********** Delete all employees with minimum salary ***********/
	@Test
	public void testFindMinSalary(){
		System.out.println(employeeRepository.findMinSalary());
	}

	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeesHavingMinSalary(){
		employeeRepository.deleteEmployeeHavingMinSalary(employeeRepository.findMinSalary());
	}


	/*************************** Native Queries *********************************/

	/** Display the id, first name, age of all employees where last name ends with "singh"  **/
	@Test
	public void testFindEmployeesWhereLastNameEndsWith(){
		List<Object[]> empList = employeeRepository.findEmployeesWhereLastNameEndsWithNQ();
		for (Object[] emp : empList)
			System.out.println(emp[0] + "  " + emp[1] + "  " +  emp[2]);
	}


	/*** Delete all employees with age greater than 45(Should be passed as a parameter) *****/
	@Test
	@Transactional
	@Rollback(value = false)
	public void testDeleteEmployeeWhereAgeGreaterThan(){
		employeeRepository.deleteAllEmployeeWhereAgeGreaterThanNQ(45);
	}

	/************************ Inheritance **************************************/

	@Test
	public void createCardPayment(){
		CreditCard cc = new CreditCard();
		cc.setId(1l);
		cc.setCardnumber("123456789");
		cc.setAmount(50000.78);
		paymentRepository.save(cc);
	}


	@Test
	public void createCheckPayment(){
		Check check = new Check();
		check.setId(2l);
		check.setChecknumber("987654321");
		check.setAmount(45897.34);
		paymentRepository.save(check);
	}


	/*************************** Component Mapping *****************************/

	/** Implement and demonstrate Embedded mapping using employee table having following fields:
	 id, firstName, lastName, age, basicSalary, bonusSalary, taxAmount, specialAllowanceSalary. */

	@Test
	public void testCreateEmployeeMapping(){
		EmployeeMapping employee = new EmployeeMapping();
		employee.setAge(24);
		employee.setFirstname("Vaishali");
		employee.setLastname("Gupta");

		Salary salary = new Salary();
		salary.setBasicSalary(20000);
		salary.setBonusSalary(10000);
		salary.setSpecialAllowanceSalary(12000);
		salary.setTaxAmount(5000);

		employee.setSalary(salary);

		employeeMappingRepository.save(employee);

	}
}
