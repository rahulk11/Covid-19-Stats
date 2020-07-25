package `in`.rahulkr.covid_19stats.data.api

class ApiHelper(private val apiService: ApiService) {

    suspend fun getSummary() = apiService.getSummary()
}