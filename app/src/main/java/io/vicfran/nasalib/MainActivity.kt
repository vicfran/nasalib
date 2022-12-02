package io.vicfran.nasalib

import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import io.vicfran.lib.NasaApi

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val nasaApi: NasaApi by lazy { NasaApi() }

    override fun onResume() {
        super.onResume()

        nasaApi.getAstronomyPictureOfTheDay { astronomyPicture ->
            astronomyPicture?.let {
                findViewById<TextView>(R.id.tvTitle).text = it.title
                Picasso.get().load(it.url).into(findViewById<ImageView>(R.id.image))
                findViewById<TextView>(R.id.tvExplanation).text = it.explanation
            }
        }
    }

}