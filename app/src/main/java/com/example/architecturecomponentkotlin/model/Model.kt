package com.example.architecturecomponentkotlin.model

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.architecturecomponentkotlin.utils.ListStringConverter
import com.google.gson.annotations.SerializedName


@Entity
@TypeConverters(ListStringConverter::class)
class Model {
    @PrimaryKey
    @NonNull
    var app_id : String? = null
    var app_package : String? = null
    var email : String? = null
    var website : String? = null
    var privacy_policy_url : String? = null
    var total_downloads : Int? = null
    var average_ratings : Int? = null
    var total_ratings : Int? = null
    var total_rating_1 : Int? = null
    var total_rating_2 : Int? = null
    var total_rating_3 : Int? = null
    var total_rating_4 : Int? = null
    var total_rating_5 : Int? = null
    var app_version_id : String? = null
    var version_code : String? = null
    var app_size : String? = null
    var last_update : String? = null
    var publisher_name : String? = null
    var name : String? = null
    var short_desc : String? = null
    var long_desc : String? = null
    var app_icon_url : String? = null
    var app_featured_url : String? = null
}








//data class Model(
//
//    @SerializedName("app_id") val app_id : String,
//    @SerializedName("app_package") val app_package : String,
//    @SerializedName("email") val email : String,
//    @SerializedName("website") val website : String,
//    @SerializedName("privacy_policy_url") val privacy_policy_url : String,
//    @SerializedName("total_downloads") val total_downloads : Int,
//    @SerializedName("average_ratings") val average_ratings : Int,
//    @SerializedName("total_ratings") val total_ratings : Int,
//    @SerializedName("total_rating_1") val total_rating_1 : Int,
//    @SerializedName("total_rating_2") val total_rating_2 : Int,
//    @SerializedName("total_rating_3") val total_rating_3 : Int,
//    @SerializedName("total_rating_4") val total_rating_4 : Int,
//    @SerializedName("total_rating_5") val total_rating_5 : Int,
//    @SerializedName("app_version_id") val app_version_id : String,
//    @SerializedName("version_code") val version_code : String,
//    @SerializedName("app_size") val app_size : String,
//    @SerializedName("last_update") val last_update : String,
//    @SerializedName("publisher_name") val publisher_name : String,
//    @SerializedName("name") val name : String,
//    @SerializedName("short_desc") val short_desc : String,
//    @SerializedName("long_desc") val long_desc : String,
//    @SerializedName("app_icon_url") val app_icon_url : String,
//    @SerializedName("app_featured_url") val app_featured_url : String
//
//)