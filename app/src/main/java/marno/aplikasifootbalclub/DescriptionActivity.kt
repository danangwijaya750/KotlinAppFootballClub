package marno.aplikasifootbalclub

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.bumptech.glide.Glide
import org.jetbrains.anko.*




class DescriptionActivity : AppCompatActivity(),AnkoLogger {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        DescriptionActivityUI().setContentView(this)
        val mainUI=DescriptionActivityUI();
        mainUI.setContentView(this)
        val layoutParams = LinearLayout.LayoutParams(100, 100)
        layoutParams.gravity = Gravity.CENTER_HORIZONTAL
        val callId:Int=intent.getStringExtra("id").toInt()
        val namaClub=resources.getStringArray(R.array.club)
        val descClub=resources.getStringArray(R.array.desc)
        val fotoClub=resources.obtainTypedArray(R.array.img)
        mainUI.imagev.setLayoutParams(layoutParams);
        mainUI.textdes.text=descClub[callId-1].toString()
        mainUI.texttitle.text=namaClub[callId-1].toString()
        Glide.with(this).load(fotoClub.getResourceId(callId-1,0)).into(mainUI.imagev)
        info("Log ID from Main : ${callId.toString()}")
    }
    class DescriptionActivityUI:AnkoComponent<DescriptionActivity>{

        lateinit var imagev:ImageView
        lateinit var textdes:TextView
        lateinit var  texttitle:TextView
        override fun createView(ui: AnkoContext<DescriptionActivity>)=with(ui) {

            verticalLayout{
                padding=dip(16)

            imagev= imageView(){

                scaleType=ImageView.ScaleType.FIT_XY
            }.lparams(90,90)
               texttitle= textView(){

                  padding=dip(5)
                    textSize=15.toFloat()

              }.lparams{width= wrapContent
                    height= wrapContent
                    this.gravity=Gravity.CENTER
                }
            textdes=textView(){

                padding=dip(5)

            }.lparams{width = wrapContent
                height = wrapContent
                this.gravity=Gravity.CENTER
            }
            }
        }

    }
}
