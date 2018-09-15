package marno.aplikasifootbalclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView


class MainActivity : AppCompatActivity() {
public var clubItems:MutableList<DataItem> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainUI = MainActivityUI()
        mainUI.setContentView(this)
        fetch()
        mainUI.listvi.layoutManager=LinearLayoutManager(this)
        mainUI.listvi.adapter=DataItemAdapter(this,clubItems){
           startActivity<DescriptionActivity>("id" to it.IdClub.toString())
        }
    }
    fun fetch(){
        val idclub=resources.getIntArray(R.array.idclub);
        val nama=resources.getStringArray(R.array.club)
        val image=resources.obtainTypedArray(R.array.img)
        clubItems.clear()
        for(i in nama.indices){
            clubItems.add(DataItem(idclub[i],nama[i],image.getResourceId(i,0)))
        }
        image.recycle()
    }

    class MainActivityUI :AnkoComponent<MainActivity>{
        lateinit var listvi:RecyclerView
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {

            verticalLayout{
                padding = dip(5)
            listvi= recyclerView() {

            }.lparams(width= matchParent,height = wrapContent)

             }

            }
        }

    }

