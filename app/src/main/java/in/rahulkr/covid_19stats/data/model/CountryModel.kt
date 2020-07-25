package `in`.rahulkr.covid_19stats.data.model

data class CountryModel(
    val Country: String,
    val CountryCode: String,
    val Date: String,
    val NewConfirmed: Int,
    val NewDeaths: Int,
    val NewRecovered: Int,
    val Slug: String,
    val TotalConfirmed: Int,
    val TotalDeaths: Int,
    val TotalRecovered: Int
) {
    override fun toString(): String {
        return Country
    }
}