package uz.kayo.company.cantroller

import org.springframework.web.bind.annotation.*
import uz.kayo.company.dtos.EmployeeCreateDto
import uz.kayo.company.dtos.EmployeeUpdateDto
import uz.kayo.company.dtos.addEmployeeProjectDto
import uz.kayo.company.service.EmployerService

@RestController
@RequestMapping("employee")
class EmployerController(
        private val employerService: EmployerService
) {

    @PostMapping("create")
    fun create(@RequestBody dto: EmployeeCreateDto) = employerService.create(dto)

    @GetMapping
    fun getAll() = employerService.getAll()

    @GetMapping("{id}")
    fun getOne(@PathVariable id:Long) = employerService.getOne(id)

    @PutMapping("update/{id}")
    fun update(@PathVariable id:Long, @RequestBody dto: EmployeeUpdateDto) = employerService.update(id,dto)

    @DeleteMapping("delete/{id}")
    fun delete(@PathVariable id: Long) = employerService.delete(id)

    @PutMapping("add/project/{id}")
    fun addEmployeeProject(@PathVariable id:Long, @RequestBody dto: addEmployeeProjectDto) = employerService.addEmployeeProject(id,dto)

}