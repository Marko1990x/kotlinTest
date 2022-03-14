package markodunovic.web.app.kotlintest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import markodunovic.web.app.kotlintest.R

class FragmentBottomFirst: Fragment() {

    companion object{
        fun newInstance() = FragmentBottomFirst()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_bottom1,container,false)
        return view
    }
}