package uz.kayo.company.cantroller

import org.springframework.web.bind.annotation.*
import uz.kayo.company.dtos.DistrictCreateDto
import uz.kayo.company.dtos.DistrictUpdateDto
import uz.kayo.company.service.DistrictService


@RestController
@RequestMapping("district")
class DistrictController(
        private val districtService: DistrictService,
) {

    @PostMapping("create")
    fun create(@RequestBody dto: DistrictCreateDto) = districtService.create(dto)

    @GetMapping("get")
    fun getAll(@RequestParam regionId: Long) = districtService.getAll(regionId)

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = districtService.getOne(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: DistrictUpdateDto) = districtService.update(id, dto)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = districtService.delete(id)


}
