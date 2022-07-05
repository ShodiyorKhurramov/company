package uz.kayo.company.repositories

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import uz.kayo.company.entities.Employee

interface EmployeeRepository:BaseRepository<Employee> {


    @Query("SELECT e FROM Employee e WHERE e.name IN (:names)")
    fun findByNames(@Param("names") names: List<String>): List<Employee>

    fun findByName(name: String):Employee

}