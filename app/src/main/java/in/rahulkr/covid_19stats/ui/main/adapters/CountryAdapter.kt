package `in`.rahulkr.covid_19stats.ui.main.adapters

import `in`.rahulkr.covid_19stats.data.model.CountryModel
import `in`.rahulkr.covid_19stats.databinding.CountryAdapterBinding
import `in`.rahulkr.covid_19stats.ui.main.view.CountryFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Filter
import android.widget.Filterable
import kotlin.collections.ArrayList

interface CountrySelectListener {
    fun onCountrySelected(country: CountryModel)
}

class CountryAdapter(
    private var countries: List<CountryModel>,
    private var inflater: LayoutInflater,
    private var clickListener: CountrySelectListener
) : BaseAdapter(),
    Filterable {
    private var filteredData = ArrayList<CountryModel>()
    private lateinit var binding: CountryAdapterBinding
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        binding = CountryAdapterBinding.inflate(inflater, p2, false)
        binding.countryName.text = filteredData[p0].Country
        binding.countryName.setOnClickListener {
            run {
                clickListener.onCountrySelected(filteredData[p0])
            }
        }
        return binding.root
    }

    override fun getItem(p0: Int): Any {
        return filteredData?.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return filteredData?.size
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(p0: CharSequence?): FilterResults {
                filteredData.clear()
                if (p0.toString().isEmpty())
                    filteredData.addAll(countries);
                else {
                    for (country in countries) {
                        if (country.Country.contains(p0.toString(), true)) {
                            filteredData.add(country)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = filteredData
                return filterResults
            }

            override fun publishResults(p0: CharSequence?, p1: FilterResults?) {
                notifyDataSetChanged()
            }

        }
    }
}