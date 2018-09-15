package marno.aplikasifootbalclub

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.club_item.*

class  DataItemAdapter(private  val cont:Context, private val ClubItems:List<DataItem>, private  val listen:(DataItem)->Unit)
    :RecyclerView.Adapter<DataItemAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            ViewHolder(LayoutInflater.from(cont).inflate(R.layout.club_item, parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(ClubItems[position], listen)
    }

    override fun getItemCount(): Int = ClubItems.size

   class ViewHolder(override val containerView: View?):RecyclerView.ViewHolder(containerView),LayoutContainer{
        fun bindItems(item: DataItem, listener: (DataItem) -> Unit) {
            text_club.text = item.NamaClub
           Glide.with(itemView.context).load(item.GambarClub).into(image_deploy)
           itemView.setOnClickListener { listener(item) }
        }
   }
           

}
