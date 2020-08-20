package com.poilkar.nehank.daggerhilt_demo.model


import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class SeriesModel(
    @SerializedName("_embedded")
    val embedded: Embedded,
    val externals: Externals,
    val genres: List<String>,
    val id: Int,
    val image: Image,
    val language: String,
    @SerializedName("_links")
    val links: Links,
    val name: String,
    val network: Network,
    val officialSite: String,
    val premiered: String,
    val rating: Rating,
    val runtime: Int,
    val schedule: Schedule,
    val status: String,
    val summary: String,
    val type: String,
    val updated: Int,
    val url: String,
    val webChannel: WebChannel,
    val weight: Int
) {

    data class Embedded(
        val episodes: List<Episode>
    ) {
        data class Episode(
            val airdate: String,
            val airstamp: String,
            val airtime: String,
            val id: Int,
            val image: Image,
            @SerializedName("_links")
            val links: Links,
            val name: String,
            val number: Int,
            val runtime: Int,
            val season: Int,
            val summary: String,
            val url: String
        ) : Serializable {
            data class Image(
                val medium: String,
                val original: String
            )

            data class Links(
                val self: Self
            ) {
                data class Self(
                    val href: String
                )
            }
        }
    }

    data class Externals(
        val imdb: String,
        val thetvdb: Int,
        val tvrage: Int
    )

    data class Image(
        val medium: String,
        val original: String
    )

    data class Links(
        val previousepisode: Previousepisode,
        val self: Self
    ) {
        data class Previousepisode(
            val href: String
        )

        data class Self(
            val href: String
        )
    }

    data class Network(
        val country: Country,
        val id: Int,
        val name: String
    ) {
        data class Country(
            val code: String,
            val name: String,
            val timezone: String
        )
    }

    data class Rating(
        val average: Double
    )

    data class Schedule(
        val days: List<String>,
        val time: String
    )

    data class WebChannel(
        val country: Country,
        val id: Int,
        val name: String
    ) {
        data class Country(
            val code: String,
            val name: String,
            val timezone: String
        )
    }
}