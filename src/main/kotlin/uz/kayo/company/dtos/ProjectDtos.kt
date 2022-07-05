package uz.kayo.company.dtos

import uz.kayo.company.entities.Employee
import uz.kayo.company.entities.Project

data class ProjectCreateDto(
    var name:String,
    var cost:Long,
    var companyId:Long,
)
data class ProjectUpdateDto(
    var name:String?,
    var cost:Long?
)

data class ProjectResponseDto(
    var name:String,
    var cost:Long,
){
    companion object{
        fun toDto(p: Project) = p.run {
            ProjectResponseDto(name,cost)
        }
    }
}

data class ProjectRemoveEmployeesDto(
    var employeeIds: List<Long>
)