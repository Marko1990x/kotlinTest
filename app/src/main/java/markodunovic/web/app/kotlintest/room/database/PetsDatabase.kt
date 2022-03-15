package markodunovic.web.app.kotlintest.room.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import markodunovic.web.app.kotlintest.room.dao.PetDao
import markodunovic.web.app.kotlintest.room.model.Animal

@Database(entities = [Animal::class], version = 1, exportSchema = false)
abstract class PetsDatabase:RoomDatabase() {

    abstract fun petDao():PetDao
    companion object{
        @Volatile
        private var INSTANCE:PetsDatabase? = null
        fun getDatabase(context:Context):PetsDatabase{
            val tempInstance = INSTANCE
            if (tempInstance!= null){
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PetsDatabase::class.java,
                    "pets_databse"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }

}