package com.springdatajpawithhibernatepart2.Assignment.jpqlandnativesql.repos;

import com.springdatajpawithhibernatepart2.Assignment.jpqlandnativesql.entities.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<Employee,Integer> {

    @Query("Select firstName,lastName from Employee where salary > " +
            "(select avg(salary) from Employee) order by age asc, salary desc" )
    List<Object[]> findAllHavingSalaryGreaterThanAvgSalary();


    @Query("Select avg(salary) from Employee")
    int findAvgSalary();


    @Query("Update Employee Set salary =:sal where salary <:findAvgSalary")
    @Modifying
    void updateEmployeesHavingSalaryLessThanAvgSalary(@Param("sal") int sal,
                                                      @Param("findAvgSalary") int findAvgSalary);


    @Query("Select min(salary) from Employee")
    int findMinSalary();


    @Modifying
    @Query("delete from Employee where salary =:findMinSalary")
    void deleteEmployeeHavingMinSalary(@Param("findMinSalary") int findMinSalary);


    @Query(value = "Select empid,empfirstname,empage from employeetable" +
            " where emplastname like '%singh'", nativeQuery = true)
    List<Object[]> findEmployeesWhereLastNameEndsWithNQ();


    /** Modifying annotation is used to tell spring data that it is a non-select operation
        it is telling that this query will modify the data  ***/
    @Modifying
    @Query(value = "Delete from employeetable where empage >:age", nativeQuery = true)
    void deleteAllEmployeeWhereAgeGreaterThanNQ(@Param("age") int age);
}
