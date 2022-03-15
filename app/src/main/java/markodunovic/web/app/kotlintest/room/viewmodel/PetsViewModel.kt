package markodunovic.web.app.kotlintest.room.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import markodunovic.web.app.kotlintest.room.database.PetsDatabase
import markodunovic.web.app.kotlintest.room.model.Animal
import markodunovic.web.app.kotlintest.room.repository.PetsRepo

class PetsViewModel(application: Application): AndroidViewModel(application){

    private val readAllData:LiveData<List<Animal>>
    private val repository:PetsRepo

    init {
        val petDao = PetsDatabase.getDatabase(application).petDao()
        repository = PetsRepo(petDao)
        readAllData = repository.readAllData
    }

    //on the background thread
    fun addPet(pet:Animal){
        viewModelScope.launch(Dispatchers.IO){
            repository.addAnimal(pet)
        }
    }

}