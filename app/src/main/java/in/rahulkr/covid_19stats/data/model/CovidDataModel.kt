package `in`.rahulkr.covid_19stats.data.model

data class CovidDataModel(
    val Global: GlobalModel,
    val Countries: List<CountryModel>
)