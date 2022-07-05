package uz.kayo.company.service.impl

import org.springframework.stereotype.Service
import uz.kayo.company.dtos.EmployeeCreateDto
import uz.kayo.company.dtos.EmployeeResponseDto
import uz.kayo.company.dtos.EmployeeUpdateDto
import uz.kayo.company.dtos.addEmployeeProjectDto
import uz.kayo.company.entities.Employee
import uz.kayo.company.repositories.CompanyRepository
import uz.kayo.company.repositories.EmployeeRepository
import uz.kayo.company.repositories.ProjectRepository
import uz.kayo.company.service.EmployerService

@Service
class EmployeeServiceImpl(
        private val employeeRepository: EmployeeRepository,
        private val companyRepository: CompanyRepository,
        private val projectRepository: ProjectRepository


) : EmployerService {
    override fun create(dto: EmployeeCreateDto) {
        employeeRepository.save(Employee(dto.name, dto.age, dto.job, companyRepository.findById(dto.companyId).orElseThrow { Exception("Company not found by id: ${dto.companyId}") }))
    }

    override fun getAll() = employeeRepository.findAll().map { EmployeeResponseDto.toDto(it) }

    override fun getOne(id: Long): EmployeeResponseDto {
        val employer = employeeRepository.findById(id).orElseThrow { Exception("Employee not found by id: $id") }
        return EmployeeResponseDto.toDto(employer)
    }

    override fun update(id: Long, dto: EmployeeUpdateDto) {
        val employee = employeeRepository.findById(id).orElseThrow { Exception("Employee not found by id: $id") }
        dto.apply {
            name?.let { employee.name = it }
            age?.let { employee.age = it }
            job?.let { employee.job = it }

        }

        employeeRepository.save(employee)
    }


    override fun delete(id: Long) {
        employeeRepository.deleteById(id)
    }

    override fun addEmployeeProject(id: Long, dto: addEmployeeProjectDto) {

        val project = projectRepository.findById(id).orElseThrow { Exception("Project not found by id: $id") }
        for (employeeId in dto.employeeIds) {
            val employee = employeeRepository.findById(employeeId).orElseThrow { Exception("Employee not found by id: $employeeId") }

            if (project.employee == null) {
                val array = mutableListOf<Employee>()
                array.add(employee)
                project.employee = array
            } else {
                project.employee!!.add(employee)

            }


            projectRepository.save(project)

        }

    }
}