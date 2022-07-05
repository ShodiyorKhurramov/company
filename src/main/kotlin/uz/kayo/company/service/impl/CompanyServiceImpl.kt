package uz.kayo.company.service.impl

import org.springframework.stereotype.Service
import uz.kayo.company.dtos.CompanyCreateDto
import uz.kayo.company.dtos.CompanyResponseDto
import uz.kayo.company.dtos.CompanyUpdateDto
import uz.kayo.company.entities.Company
import uz.kayo.company.repositories.CompanyRepository
import uz.kayo.company.repositories.DistrictRepository
import uz.kayo.company.service.CompanyService


@Service
class CompanyServiceImpl(
        private val companyRepository: CompanyRepository,
        private val districtRepository: DistrictRepository

) : CompanyService {
    override fun create(dto: CompanyCreateDto) {
        val district = districtRepository.findByName(dto.districtName)
        companyRepository.save(Company(dto.name, district))
    }

    override fun update(id: Long, dto: CompanyUpdateDto) {
        val company = companyRepository.findById(id).orElseThrow { Exception("Company not by id: $id") }
        dto.apply {
            name.let { company.name = it }
            districtId.let {
                company.district = districtRepository.findById(it).orElseThrow { Exception("District not by id: $districtId") }
            }
        }

        companyRepository.save(company)
    }

    override fun getAll() = companyRepository.findAll().map { CompanyResponseDto.toDto(it) }
    override fun getOne(id: Long) = CompanyResponseDto.toDto(companyRepository.findById(id).orElseThrow { Exception("Region not found by id: $id") })
    override fun delete(id: Long) { companyRepository.deleteById(id) }

}



