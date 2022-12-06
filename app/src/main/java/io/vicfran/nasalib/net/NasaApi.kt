package io.vicfran.nasalib.net

import android.util.Log
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.core.FuelManager
import com.github.kittinunf.fuel.core.Request
import com.github.kittinunf.fuel.core.Response
import com.github.kittinunf.fuel.gson.responseObject

internal class NasaApi {

    private val TAG = "nasalib-NasaApi"
    private val apiKey = "DEMO_KEY"

    init {
        FuelManager.instance.basePath = "https://api.nasa.gov/planetary/apod?api_key=$apiKey"
    }

    fun getAstronomyPictureOfTheDay(callback: (io.vicfran.nasalib.AstronomyPicture?) -> Unit) {
        Fuel.get("").responseObject { request, response, result ->
            log(request, response, result)

            callback(result.component1())
        }
    }

    private fun log(request: Request, response: Response, result: Any) {
        Log.d(TAG, "Request: $request")
        Log.d(TAG, "Response: $response")
        Log.d(TAG, "Result: $result")
    }

}