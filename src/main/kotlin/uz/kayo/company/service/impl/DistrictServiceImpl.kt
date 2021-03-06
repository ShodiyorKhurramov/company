package uz.kayo.company.service.impl

import org.springframework.stereotype.Service
import uz.kayo.company.dtos.DistrictCreateDto
import uz.kayo.company.dtos.DistrictResponseDto
import uz.kayo.company.dtos.DistrictUpdateDto
import uz.kayo.company.entities.District
import uz.kayo.company.repositories.DistrictRepository
import uz.kayo.company.repositories.RegionRepository
import uz.kayo.company.service.DistrictService


@Service
class DistrictServiceImpl(
        private val districtRepository: DistrictRepository,
        private val regionRepository: RegionRepository

) : DistrictService {
    override fun create(dto: DistrictCreateDto) {
        val region =
             regionRepository.findById(dto.regionId).orElseThrow { Exception("Region not found by id: ${dto.regionId}") }
        districtRepository.save(District(dto.name, region))

    }

    override fun getAll(regionId: Long) = districtRepository.findAllByRegionId(regionId).map {
        DistrictResponseDto.toDto(it)

    }

    override fun getOne(districtId: Long): DistrictResponseDto {
        val district =
            districtRepository.findById(districtId).orElseThrow { Exception("District not by id: $districtId") }
        return DistrictResponseDto.toDto(district)
    }

    override fun update(id: Long, dto: DistrictUpdateDto) {
        val district = districtRepository.findById(id).orElseThrow { Exception("District not by id: $id") }
        dto.apply {
            name?.let { district.name = it }

            regionId?.let {
                val region = regionRepository.findById(it).orElseThrow { Exception("District not by id: $id") }
                district.region = region
            }
        }
        districtRepository.save(district)
    }

    override fun delete(id: Long) {
        districtRepository.deleteById(id)

    }
}