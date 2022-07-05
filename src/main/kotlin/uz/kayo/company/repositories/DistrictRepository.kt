package uz.kayo.company.repositories

import org.springframework.data.jpa.repository.Query
import uz.kayo.company.entities.District


interface DistrictRepository : BaseRepository<District> {
    @Query("select d from District d where d.region.id = ?1")
    fun findAllByRegionId(region_id: Long): List<District>

    fun findByName(districtName:String):District



}