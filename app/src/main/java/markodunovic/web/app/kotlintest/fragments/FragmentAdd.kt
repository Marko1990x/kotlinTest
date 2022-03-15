package markodunovic.web.app.kotlintest.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.NumberPicker
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import markodunovic.web.app.kotlintest.MainActivity
import markodunovic.web.app.kotlintest.R
import markodunovic.web.app.kotlintest.room.model.Animal
import markodunovic.web.app.kotlintest.room.viewmodel.PetsViewModel
import kotlin.math.log

class FragmentAdd : Fragment() {

    private lateinit var numberPicker: NumberPicker
    private lateinit var petName: TextView
    private lateinit var petRace: TextView
    private lateinit var button: Button

    private lateinit var petUserViewModel:PetsViewModel

    companion object {
        fun newInstance() = FragmentAdd()
        private val TAG: String? = FragmentAdd::class.simpleName;
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_add, container, false)
        petUserViewModel = ViewModelProvider(this).get(PetsViewModel::class.java)
        numberPicker = view.findViewById(R.id.petAge)
        petName = view.findViewById(R.id.petName)
        petRace = view.findViewById(R.id.petRace)
        numberPicker.minValue = 0
        numberPicker.maxValue = 10
        button = view.findViewById(R.id.addPet)
        button.setOnClickListener(View.OnClickListener {
            val name: String = petName.text.toString()
            val race: String = petRace.text.toString()
            if (name.isEmpty() || race.isEmpty()) {
                Toast.makeText(context, "Data cant be empty", Toast.LENGTH_LONG).show()
            } else {
                Log.d(TAG, "name ${petName.text} race ${petRace.text} age ${numberPicker.value}")
                val animal = Animal(0,name,race,numberPicker.value)
                petUserViewModel.addPet(animal)
                Toast.makeText(context,"Added to database",Toast.LENGTH_SHORT).show()

            }
        })
        return view
    }


}