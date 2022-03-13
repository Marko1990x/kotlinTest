package markodunovic.web.app.kotlintest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import markodunovic.web.app.kotlintest.R

class FirstImageFragment: Fragment() {

    private var background: ImageView? = null

    private fun loadBackground(view:View){
        val link:String = "https://github.com/Marko1990x/AppData/raw/main/moded/vertical/5.jpg";
        Picasso.get().load(link).into(background);
    }

    companion object{
        fun newInstance() = FirstImageFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_home,container,false);
        setButtons(view)
        loadBackground(view)
        return view;
    }

    private fun setButtons(view: View) {
        background = view.findViewById(R.id.background);
    }
}