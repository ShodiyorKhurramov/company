package uz.kayo.company.repositories
import uz.kayo.company.entities.Company


interface CompanyRepository:BaseRepository<Company> {

    fun findByName(name:String):Company
    fun existsByName(name: String):Boolean

}
