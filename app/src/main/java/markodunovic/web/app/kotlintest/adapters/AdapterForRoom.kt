package markodunovic.web.app.kotlintest.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.RecyclerView
import markodunovic.web.app.kotlintest.R
import markodunovic.web.app.kotlintest.room.model.Animal

class AdapterForRoom:RecyclerView.Adapter<AdapterForRoom.AdapterForRoomViewHolder>() {

    private lateinit var context:Context
    private var petList = emptyList<Animal>()

    class AdapterForRoomViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imageView: ImageView = itemView.findViewById(R.id.card_imageView);
        val textView: TextView = itemView.findViewById(R.id.card_textView);
        val textView2: TextView = itemView.findViewById(R.id.card_detailButton);
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterForRoomViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_room,parent,false)
        context = parent.context
        return AdapterForRoomViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: AdapterForRoomViewHolder, position: Int) {
        val currentAnimal:Animal = petList[position]
        holder.textView.text = currentAnimal.name
        holder.textView2.text = currentAnimal.age.toString()
    }

    override fun getItemCount() = petList.size

    fun setData(pet: List<Animal>){
        this.petList = pet
        notifyDataSetChanged()
    }
}