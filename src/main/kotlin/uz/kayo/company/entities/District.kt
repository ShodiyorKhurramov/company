package uz.kayo.company.entities

import javax.persistence.Entity
import javax.persistence.ManyToOne


@Entity
class District(
        var name: String,
        @ManyToOne var region: Region

        ) : BaseEntity()
