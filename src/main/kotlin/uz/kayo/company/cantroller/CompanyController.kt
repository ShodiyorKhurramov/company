package uz.kayo.company.cantroller

import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import uz.kayo.company.dtos.CompanyCreateDto
import uz.kayo.company.dtos.CompanyUpdateDto
import uz.kayo.company.service.CompanyService
import uz.kayo.company.service.impl.CompanyServiceImpl

@RestController
@RequestMapping("company")
class CompanyController(
        private val companyService: CompanyService
) {

    @PostMapping("create")
    fun create(@RequestBody dto: CompanyCreateDto) = companyService.create(dto)

    @PutMapping("{id}")
    fun update(@PathVariable id: Long, @RequestBody dto: CompanyUpdateDto) = companyService.update(id, dto)

    @GetMapping
    fun getAll() = companyService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id: Long) = companyService.getOne(id)

    @DeleteMapping("{id}")
    fun delete(@PathVariable id: Long) = companyService.delete(id)

}