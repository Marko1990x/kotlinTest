package markodunovic.web.app.kotlintest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.squareup.picasso.Picasso
import markodunovic.web.app.kotlintest.R

class FragmentSecond : Fragment() {
    private lateinit var txtName: TextView
    private var background: ImageView? = null
    companion object {
        fun newInstance() = FragmentSecond();
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_second,container,false)
        setButtons(view)
        return view
    }

    private fun setButtons(view: View) {
        txtName = view.findViewById(R.id.txt_name);
        background = view.findViewById(R.id.background);
        txtName.setText(FragmentSecond::class.simpleName);
        val link:String = "https://github.com/Marko1990x/AppData/raw/main/moded/vertical/3.jpg";
        Picasso.get().load(link).fit().into(background);
    }
}