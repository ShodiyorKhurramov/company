package uz.kayo.company.entities

import javax.persistence.*

@Entity
class Employee(
    var name:String,
    var age:Int,
    var job:String,
    @ManyToOne
    var company: Company

):BaseEntity() {

}
