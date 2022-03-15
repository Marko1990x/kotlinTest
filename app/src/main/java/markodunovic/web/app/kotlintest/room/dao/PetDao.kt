package markodunovic.web.app.kotlintest.room.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import markodunovic.web.app.kotlintest.room.model.Animal

@Dao
interface PetDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addPet(animal: Animal)

    @Query("SELECT * FROM petsTable ORDER by id ASC")
    fun readAllData(): LiveData<List<Animal>>

}