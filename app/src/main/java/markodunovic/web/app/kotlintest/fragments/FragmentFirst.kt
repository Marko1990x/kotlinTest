package markodunovic.web.app.kotlintest.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import markodunovic.web.app.kotlintest.R
import markodunovic.web.app.kotlintest.adapters.AdapterFirstFragment
import markodunovic.web.app.kotlintest.data.Item
import kotlin.random.Random

class FragmentFirst: Fragment() {
    private lateinit var txtName: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var buttonInsert:Button
    private lateinit var buttonRemove:Button
    private var background:ImageView? = null
    private var list:ArrayList<Item> = adapterDummyList(100)
    private val adapter = AdapterFirstFragment(list)

    companion object{
        fun newInstance() = FragmentFirst();
        private val TAG:String? = FragmentFirst::class.simpleName
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val view:View = inflater.inflate(R.layout.fragment_first,container,false)
        setButtons(view);
        recyclerView = view.findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = adapter
        setAdapterInsertRemove(view)
        return view
    }

    private fun setAdapterInsertRemove(view: View) {
        buttonInsert = view.findViewById(R.id.buttonInsert)
        buttonInsert.setOnClickListener(View.OnClickListener {
            Log.d(TAG, "button insert: ")
            val index:Int = Random.nextInt(10)
            val newItem = Item(R.drawable.a,"new item @ $index","$index")
            list.add(index,newItem)
            adapter.notifyItemInserted(index)

        })
        buttonRemove = view.findViewById(R.id.buttonRemove)
        buttonRemove.setOnClickListener(View.OnClickListener {
            Log.d(TAG, "button remove: ")
            val index:Int = Random.nextInt(10) //list size for real use
            list.removeAt(index)
            adapter.notifyItemRemoved(index)
            Toast.makeText(context,"Removed Item @index$index",Toast.LENGTH_SHORT).show()

        })

    }


    private fun setButtons(view: View) {
        txtName = view.findViewById(R.id.txt_name);
        background = view.findViewById(R.id.background);
        txtName.setText(FragmentFirst::class.simpleName);
        val link:String = "https://github.com/Marko1990x/AppData/raw/main/moded/vertical/2.jpg";
        Picasso.get().load(link).fit().into(background);

    }

    private fun adapterDummyList(size: Int): ArrayList<Item> {

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