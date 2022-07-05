package uz.kayo.company.repositories

import uz.kayo.company.entities.Project

interface ProjectRepository:BaseRepository<Project> {
    fun findByName(name: String):Project
}