package `in`.rahulkr.covid_19stats.ui.main.viewmodels

import `in`.rahulkr.covid_19stats.data.repository.CovidDataRepository
import `in`.rahulkr.covid_19stats.util.Resource
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers

class MainViewModel(private val mainDataRepository: CovidDataRepository) : ViewModel() {
    fun getSummary() = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = mainDataRepository.getSummary()))
        } catch (exception: Exception) {
            emit(Resource.error(data = null, message = exception.message ?: "Error! Could not fetch data."))
        }
    }
}
