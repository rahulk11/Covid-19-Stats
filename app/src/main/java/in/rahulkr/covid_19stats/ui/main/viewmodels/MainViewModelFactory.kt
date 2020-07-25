package `in`.rahulkr.covid_19stats.ui.main.viewmodels

import `in`.rahulkr.covid_19stats.data.api.ApiHelper
import `in`.rahulkr.covid_19stats.data.repository.CovidDataRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class MainViewModelFactory(private val apiHelper: ApiHelper) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(CovidDataRepository(apiHelper)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }

}