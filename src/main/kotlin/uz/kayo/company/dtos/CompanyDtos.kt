package uz.kayo.company.dtos

import uz.kayo.company.entities.Company
import uz.kayo.company.entities.Employee

data class CompanyCreateDto(
        var name: String,
        var districtName: String,
        var employee: List<Employee>? = null
)

data class CompanyUpdateDto(
        var name: String,
        var districtId: Long
)


data class CompanyResponseDto(
        val id: Long?,
        var name: String,
        var districtName: String
) { companion object { fun toDto(c: Company) = c.run { CompanyResponseDto(id, name, district.name)}}}
