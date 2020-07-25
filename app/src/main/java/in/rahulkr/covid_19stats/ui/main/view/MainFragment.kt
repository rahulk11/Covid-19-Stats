package `in`.rahulkr.covid_19stats.ui.main.view

import `in`.rahulkr.covid_19stats.R
import `in`.rahulkr.covid_19stats.data.api.ApiBuilder
import `in`.rahulkr.covid_19stats.data.api.ApiHelper
import `in`.rahulkr.covid_19stats.data.model.CountryModel
import `in`.rahulkr.covid_19stats.data.model.CovidDataModel
import `in`.rahulkr.covid_19stats.ui.main.adapters.CountryAdapter
import `in`.rahulkr.covid_19stats.ui.main.adapters.CountrySelectListener
import `in`.rahulkr.covid_19stats.ui.main.viewmodels.MainViewModel
import `in`.rahulkr.covid_19stats.ui.main.viewmodels.MainViewModelFactory
import `in`.rahulkr.covid_19stats.util.Status
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() =
            MainFragment()
    }

    private val countries = ArrayList<CountryModel>()
    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        val adapter = CountryAdapter(countries, layoutInflater, object : CountrySelectListener {
            override fun onCountrySelected(country: CountryModel) {
                parentFragmentManager.beginTransaction()
                    .replace(R.id.container, CountryFragment(country))
                    .addToBackStack(null)
                    .commit()
            }
        })
        auto_complete_countries.setAdapter(adapter)
        viewModel = ViewModelProviders.of(
            this,
            MainViewModelFactory(ApiHelper(ApiBuilder.apiService))
        ).get(MainViewModel::class.java)
        setObservers()
    }

    private fun setObservers() {
        viewModel.getSummary().observe(viewLifecycleOwner, Observer {
            it?.let { resource ->
                when (resource.status) {
                    Status.SUCCESS -> {
                        progress_circular.visibility = View.GONE
                        resource.data?.let { covidDataModel ->
                            populateData(covidDataModel)
                        }
                    }
                    Status.ERROR -> {
                        progress_circular.visibility = View.GONE
                        Toast.makeText(context, it.message, Toast.LENGTH_LONG).show()
                    }
                    Status.LOADING -> {
                        progress_circular.visibility = View.VISIBLE
                    }
                }
            }
        })
    }

    private fun populateData(covidData: CovidDataModel) {
        countries.addAll(covidData.Countries)
        view_global_data.bindData(covidData.Global)
    }
}
