package com.example.challange2foodapp.data.model

import androidx.annotation.DrawableRes
import java.util.UUID

data class Category(
    var id: String = UUID.randomUUID().toString(),
    @DrawableRes
    var imageCategory: Int,
    var name: String,
)
