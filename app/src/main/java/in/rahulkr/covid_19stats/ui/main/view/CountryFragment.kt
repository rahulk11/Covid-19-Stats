package `in`.rahulkr.covid_19stats.ui.main.view

import `in`.rahulkr.covid_19stats.R
import `in`.rahulkr.covid_19stats.data.model.CountryModel
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.country_fragment.*

class CountryFragment(private val country: CountryModel) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.country_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        view_country_data.bindData(country)
    }
}