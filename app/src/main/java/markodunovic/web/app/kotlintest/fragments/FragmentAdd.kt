package markodunovic.web.app.kotlintest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import markodunovic.web.app.kotlintest.R

class FragmentAdd:Fragment() {

    companion object{
        fun newInstance() = FragmentAdd()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_add,container,false)

        return view
    }
}