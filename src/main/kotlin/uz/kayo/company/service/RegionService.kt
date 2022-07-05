package uz.kayo.company.service

import uz.kayo.company.dtos.RegionCreateDto
import uz.kayo.company.dtos.RegionResponseDto
import uz.kayo.company.dtos.RegionUpdateDto

interface RegionService {
    fun create(dto: RegionCreateDto)
    fun getAll(): List<RegionResponseDto>
    fun getOne(id: Long): RegionResponseDto
    fun update(id: Long, dto: RegionUpdateDto)
    fun delete(id: Long)

}