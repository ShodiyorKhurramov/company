package uz.kayo.company.cantroller

import org.springframework.web.bind.annotation.*
import uz.kayo.company.dtos.RegionCreateDto
import uz.kayo.company.dtos.RegionUpdateDto
import uz.kayo.company.service.RegionService

@RestController
@RequestMapping("region")
class RegionController(
        private val regionService: RegionService,
) {

    @PostMapping("create")
    fun create(@RequestBody dto: RegionCreateDto) = regionService.create(dto)

    @GetMapping
    fun getAll() = regionService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = regionService.getOne(id)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: RegionUpdateDto) = regionService.update(id, dto)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = regionService.delete(id)
}
