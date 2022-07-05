package uz.kayo.company.service

import uz.kayo.company.dtos.DistrictCreateDto
import uz.kayo.company.dtos.DistrictResponseDto
import uz.kayo.company.dtos.DistrictUpdateDto


interface DistrictService {
    fun create(dto: DistrictCreateDto)
    fun getAll(regionId: Long): List<DistrictResponseDto>
    fun getOne(districtId: Long): DistrictResponseDto
    fun update(id: Long, dto: DistrictUpdateDto)
    fun delete(id: Long)


}
