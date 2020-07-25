package `in`.rahulkr.covid_19stats.data.repository

import `in`.rahulkr.covid_19stats.data.api.ApiHelper

class CovidDataRepository(private val apiHelper: ApiHelper) {

    suspend fun getSummary() = apiHelper.getSummary()
}