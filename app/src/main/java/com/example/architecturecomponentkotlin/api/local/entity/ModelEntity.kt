package com.example.architecturecomponentkotlin.api.local.entity

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.architecturecomponentkotlin.utils.ListStringConverter

@Entity
@TypeConverters(ListStringConverter::class)
class ModelEntity {
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