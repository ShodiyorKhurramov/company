package uz.kayo.company.service.impl

import org.springframework.stereotype.Service
import uz.kayo.company.dtos.RegionCreateDto
import uz.kayo.company.dtos.RegionResponseDto
import uz.kayo.company.dtos.RegionUpdateDto
import uz.kayo.company.entities.Region
import uz.kayo.company.repositories.DistrictRepository
import uz.kayo.company.repositories.RegionRepository
import uz.kayo.company.service.RegionService

@Service
class RegionServiceImpl(private val districtRepository: DistrictRepository, private val regionRepository: RegionRepository) : RegionService {


    override fun create(dto: RegionCreateDto) {
        regionRepository.save(Region(dto.name))

    }

    override fun getAll() = regionRepository.findAll().map { RegionResponseDto.toDto(it) }

    override fun getOne(id: Long): RegionResponseDto {
        val region = regionRepository.findById(id).orElseThrow { Exception("Region not found by id: $id") }
        return RegionResponseDto.toDto(region)
    }

    override fun update(id: Long, dto: RegionUpdateDto) {
        val region = regionRepository.findById(id).orElseThrow { Exception("Region not found by id: $id") }
        dto.apply {
            name?.let {
                region.name = it
            }

        }
        regionRepository.save(region)
    }


    override fun delete(id: Long) {

        val allDistrict = districtRepository.findAllByRegionId(id)
        districtRepository.deleteAll(allDistrict)
        regionRepository.deleteById(id)

    }
}