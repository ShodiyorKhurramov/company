package uz.kayo.company.service.impl

import org.springframework.stereotype.Service
import uz.kayo.company.dtos.ProjectCreateDto
import uz.kayo.company.dtos.ProjectResponseDto
import uz.kayo.company.dtos.ProjectUpdateDto
import uz.kayo.company.entities.Project
import uz.kayo.company.repositories.CompanyRepository
import uz.kayo.company.repositories.EmployeeRepository
import uz.kayo.company.repositories.ProjectRepository
import uz.kayo.company.service.ProjectService


@Service
class ProjectServiceImpl(
        private val projectRepository: ProjectRepository,
        private val companyRepository: CompanyRepository
) : ProjectService {
    override fun create(dto: ProjectCreateDto) {
        projectRepository.save(Project(dto.name, dto.cost, companyRepository.findById(dto.companyId).orElseThrow { Exception("Company not found by id: ${dto.companyId}") }))
    }

    override fun getAll() = projectRepository.findAll().map { ProjectResponseDto.toDto(it) }
    override fun getOne(id: Long) = ProjectResponseDto.toDto(projectRepository.findById(id).orElseThrow { Exception("Company not found by id: $id") })

    override fun update(id: Long, dto: ProjectUpdateDto) {
        val project = projectRepository.findById(id).orElseThrow { Exception("Company not by id: $id") }
        dto.apply {
            name?.let { project.name = it }
            cost?.let { project.cost = it }
        }
        projectRepository.save(project)


    }

    override fun delete(id: Long) {
        projectRepository.deleteById(id)
    }


}