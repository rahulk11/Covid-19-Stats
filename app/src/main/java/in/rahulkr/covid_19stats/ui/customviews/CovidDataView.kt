package `in`.rahulkr.covid_19stats.ui.customviews

import `in`.rahulkr.covid_19stats.R
import `in`.rahulkr.covid_19stats.data.model.CountryModel
import `in`.rahulkr.covid_19stats.data.model.CovidDataModel
import `in`.rahulkr.covid_19stats.data.model.GlobalModel
import `in`.rahulkr.covid_19stats.databinding.CovidDataViewBinding
import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout

const val TYPE_GLOBAL: Int = 0
const val TYPE_COUNTRY: Int = 1

class CovidDataView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val binding: CovidDataViewBinding

    init {
        val inflater =
            context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        binding = CovidDataViewBinding.inflate(inflater, this, true)
    }

    fun bindData(dataModel: GlobalModel) {
        binding.tvCountry.text = "Global"
        binding.layoutTotal.labelCases.text = resources.getString(R.string.total_confirmed)
        binding.layoutTotal.valueCases.text = dataModel.TotalConfirmed.toString()
        binding.layoutTotal.labelDeaths.text = resources.getString(R.string.total_deaths)
        binding.layoutTotal.valueDeaths.text = dataModel.TotalDeaths.toString()
        binding.layoutTotal.labelRecovered.text = resources.getString(R.string.total_recovered)
        binding.layoutTotal.valueRecovered.text = dataModel.TotalRecovered.toString()
        binding.layoutNew.labelCases.text = resources.getString(R.string.new_confirmed)
        binding.layoutNew.valueCases.text = "+${dataModel.NewConfirmed}"
        binding.layoutNew.labelDeaths.text = resources.getString(R.string.new_deaths)
        binding.layoutNew.valueDeaths.text = "+${dataModel.NewDeaths}"
        binding.layoutNew.labelRecovered.text = resources.getString(R.string.new_recovered)
        binding.layoutNew.valueRecovered.text = "+${dataModel.NewRecovered}"
    }

    fun bindData(dataModel: CountryModel) {
        binding.tvCountry.text = dataModel.Country
        binding.layoutTotal.labelCases.text = resources.getString(R.string.total_confirmed)
        binding.layoutTotal.valueCases.text = dataModel.TotalConfirmed.toString()
        binding.layoutTotal.labelDeaths.text = resources.getString(R.string.total_deaths)
        binding.layoutTotal.valueDeaths.text = dataModel.TotalDeaths.toString()
        binding.layoutTotal.labelRecovered.text = resources.getString(R.string.total_recovered)
        binding.layoutTotal.valueRecovered.text = dataModel.TotalRecovered.toString()
        binding.layoutNew.labelCases.text = resources.getString(R.string.new_confirmed)
        binding.layoutNew.valueCases.text = "+${dataModel.NewConfirmed}"
        binding.layoutNew.labelDeaths.text = resources.getString(R.string.new_deaths)
        binding.layoutNew.valueDeaths.text = "+${dataModel.NewDeaths}"
        binding.layoutNew.labelRecovered.text = resources.getString(R.string.new_recovered)
        binding.layoutNew.valueRecovered.text = "+${dataModel.NewRecovered}"
    }
}