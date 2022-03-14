package markodunovic.web.app.kotlintest.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import markodunovic.web.app.kotlintest.R
import markodunovic.web.app.kotlintest.adapters.AdapterFirstFragment
import markodunovic.web.app.kotlintest.data.Item

class FragmentFirst: Fragment() {

    private lateinit var txtName: TextView
    private lateinit var recyclerView: RecyclerView
    private var background:ImageView? = null

    companion object{
        fun newInstance() = FragmentFirst();
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_first,container,false)
        setButtons(view);
        val list:List<Item> = adapterDummyList(100)
        recyclerView = view.findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = AdapterFirstFragment(list,context)
        return view
    }

    private fun setButtons(view: View) {
        txtName = view.findViewById(R.id.txt_name);
        background = view.findViewById(R.id.background);
        txtName.setText(FragmentFirst::class.simpleName);
        val link:String = "https://github.com/Marko1990x/AppData/raw/main/moded/vertical/2.jpg";
        Picasso.get().load(link).fit().into(background);
    }

    private fun adapterDummyList(size: Int): List<Item> {

        val list = ArrayList<Item>()

        for (i in 0 until size) {
            val drawable = when (i % 3) {
                0 -> R.drawable.ic_baseline_cyclone_24
                1 -> R.drawable.ic_baseline_colorize_24
                else -> R.drawable.ic_baseline_format_align_left_24
            }

            val item = Item(drawable, "Item $i", "Line 2")
            list += item
        }

        return list
    }
}