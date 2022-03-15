package markodunovic.web.app.kotlintest.room.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "petsTable")
data class Animal(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val name:String,
    val type:String,
    val age:Int
)