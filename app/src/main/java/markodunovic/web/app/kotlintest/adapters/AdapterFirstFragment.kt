package markodunovic.web.app.kotlintest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import markodunovic.web.app.kotlintest.R
import markodunovic.web.app.kotlintest.data.Item

class AdapterFirstFragment(private val list:List<Item>): RecyclerView.Adapter<AdapterFirstFragment.AdapterFirstFragmentViewHolder>() {

    private var cont:Context? = null  // this is the proper way to get context from the adapter

    class AdapterFirstFragmentViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val imageView:ImageView = itemView.findViewById(R.id.card_imageView);
        val textView:TextView = itemView.findViewById(R.id.card_textView);
        val textView2:TextView = itemView.findViewById(R.id.card_detailButton);
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AdapterFirstFragmentViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_recycler,parent,false);
        cont = parent.context
        return AdapterFirstFragmentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterFirstFragmentViewHolder, position: Int) {
        val currentItem = list[position]
        holder.imageView.setImageResource(currentItem.image)
        holder.imageView.setColorFilter(R.color.teal_700)
        holder.textView.text = currentItem.text1
        holder.textView2.setOnClickListener(View.OnClickListener {
            Toast.makeText(cont,"I dun been clicked item $position",Toast.LENGTH_SHORT).show()
        })
    }

    override fun getItemCount() = list.size

}