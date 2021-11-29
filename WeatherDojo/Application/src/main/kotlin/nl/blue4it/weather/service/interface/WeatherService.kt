package nl.blue4it.weather.service.`interface`

import nl.blue4it.weather.service.domain.Forecast
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface WeatherService {

        @GET("/data/2.5/forecast")
        fun getForecast(@Query("id") id: String, @Query("appid") appid: String): Call<Forecast?>?

}