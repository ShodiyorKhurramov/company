package uz.kayo.company.service

import uz.kayo.company.dtos.*

interface ProjectService {
    fun create(dto:ProjectCreateDto)
    fun getAll():List<ProjectResponseDto>
    fun getOne(id:Long):ProjectResponseDto
    fun update(id: Long, dto: ProjectUpdateDto)
    fun delete(id: Long)
}