package com.example.challange2foodapp.data.model

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import java.util.UUID

@Parcelize
data class Menu(
    var id: String = UUID.randomUUID().toString(),
    @DrawableRes
    var image: Int,
    var price: Double,
    var name: String,
    var shortDesc: String,
    var location: String,
    var urlLocation: String,

) : Parcelable
