package uz.kayo.company.service

import uz.kayo.company.dtos.*

interface EmployerService {
    fun create(dto: EmployeeCreateDto)
    fun getAll(): List<EmployeeResponseDto>
    fun getOne(id: Long): EmployeeResponseDto
    fun update(id: Long, dto: EmployeeUpdateDto)
    fun delete(id: Long)
   fun addEmployeeProject(id:Long,dto:addEmployeeProjectDto)
}