package markodunovic.web.app.kotlintest.room.repository

import androidx.lifecycle.LiveData
import markodunovic.web.app.kotlintest.room.dao.PetDao
import markodunovic.web.app.kotlintest.room.model.Animal

class PetsRepo(private val petsDao: PetDao) {

    val readAllData: LiveData<List<Animal>> = petsDao.readAllData()

    suspend fun addAnimal(animal: Animal){
        petsDao.addPet(animal)
    }

}