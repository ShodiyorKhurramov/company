package uz.kayo.company.dtos

import uz.kayo.company.entities.Employee

data class EmployeeCreateDto(
    var name:String,
    var age:Int,
    var job:String,
    var companyId:Long
)

data class EmployeeUpdateDto(
    var name:String?,
    var age:Int?,
    var job:String?
)

data class EmployeeResponseDto(
    var name:String,
    var age:Int,
    var job:String
){
    companion object{
        fun toDto(e:Employee) = e.run {
            EmployeeResponseDto(name, age, job)
        }
    }
}


data class addEmployeeProjectDto(
        val employeeIds:List<Long>


        )


