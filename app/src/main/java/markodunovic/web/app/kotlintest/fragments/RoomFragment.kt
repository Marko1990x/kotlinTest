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
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import markodunovic.web.app.kotlintest.R
import markodunovic.web.app.kotlintest.adapters.AdapterFirstFragment
import markodunovic.web.app.kotlintest.adapters.AdapterForRoom
import markodunovic.web.app.kotlintest.room.viewmodel.PetsViewModel

class RoomFragment : Fragment() {

    private lateinit var txtName: TextView
    private lateinit var fab: FloatingActionButton
    private var background: ImageView? = null
    private var addFragment = FragmentAdd.newInstance()
    private lateinit var recyclerView: RecyclerView
    private lateinit var petUserViewModel: PetsViewModel
    private val adapter = AdapterForRoom()

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

        petUserViewModel = ViewModelProvider(this).get(PetsViewModel::class.java)
        recyclerView = view.findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(false)
        recyclerView.adapter = adapter
        petUserViewModel.readAllData.observe(viewLifecycleOwner, Observer { pet ->
            adapter.setData(pet)
        })

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