package `in`.rahulkr.covid_19stats.data.api

import `in`.rahulkr.covid_19stats.BuildConfig
import `in`.rahulkr.covid_19stats.data.model.CovidDataModel
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiService {
    @GET("/summary")
    suspend fun getSummary(): CovidDataModel
}

object ApiBuilder {
    private fun getApiBuilder(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BuildConfig.COVID_BASE_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getApiBuilder().create(ApiService::class.java)
}