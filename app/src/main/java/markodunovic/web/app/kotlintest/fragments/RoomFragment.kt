package markodunovic.web.app.kotlintest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import markodunovic.web.app.kotlintest.R

class RoomFragment : Fragment() {

    private lateinit var txtName: TextView
    private lateinit var fab: FloatingActionButton
    private var background: ImageView? = null
    private var addFragment = FragmentAdd.newInstance()

    companion object {
        fun newInstance() = RoomFragment();
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view: View = inflater.inflate(R.layout.fragment_third, container, false);
        setButtons(view)
        return view
    }

    private fun setButtons(view: View) {
        txtName = view.findViewById(R.id.txt_name);
        background = view.findViewById(R.id.background);
        txtName.setText(RoomFragment::class.simpleName);
        val link: String = "https://github.com/Marko1990x/AppData/raw/main/moded/vertical/4.jpg";
        Picasso.get().load(link).fit().into(background);
        fab = view.findViewById(R.id.fabButton)
        fab.setOnClickListener(View.OnClickListener {
            replaceFragment(addFragment,"addFragment")
        })
    }

    private fun replaceFragment(fragment: Fragment, name: String) {
        val transaction =
            parentFragmentManager.beginTransaction() // call parent to get reference for transaction
        transaction.replace(R.id.fragment_container, fragment)
        transaction.addToBackStack(name)
        transaction.commit()
    }

}