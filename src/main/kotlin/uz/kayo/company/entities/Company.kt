package uz.kayo.company.entities

import javax.persistence.*
import javax.persistence.CascadeType.*

@Entity
class Company(
        var name: String,
        @ManyToOne
        var district: District,
        @OneToMany(mappedBy = "company", cascade = [ALL])
        var employee: MutableList<Employee>? = null,
        @OneToMany(mappedBy = "company", cascade = [ALL])
        var project: MutableList<Project>? = null

) : BaseEntity() {

}