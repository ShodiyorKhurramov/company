package uz.kayo.company.entities

import javax.persistence.*

@Entity
class Project(
    var name:String,
    var cost:Long,
    @ManyToOne
    var company: Company,
    @ManyToMany(cascade = [CascadeType.PERSIST,CascadeType.MERGE])
    var employee: MutableList<Employee>? = null,
):BaseEntity()