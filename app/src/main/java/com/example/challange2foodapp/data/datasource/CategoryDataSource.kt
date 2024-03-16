package com.example.challange2foodapp.data.datasource

import com.example.challange2foodapp.R
import com.example.challange2foodapp.data.model.Category

interface CategoryDataSource {
    fun getCategoryData(): List<Category>
}

class CategoryDataSourceImpl() : CategoryDataSource {
    override fun getCategoryData(): List<Category> {
        return mutableListOf(
            Category(
                imageCategory = R.drawable.img_category_rice,
                name = "Nasi"
            ),
            Category(
                imageCategory = R.drawable.img_category_noodle,
                name = "Mie"
            ),
            Category(
                imageCategory = R.drawable.img_category_snack,
                name = "Snack"
            ),
            Category(
                imageCategory = R.drawable.img_category_fastfood,
                name = "Fast food"
            ),
            Category(
                imageCategory = R.drawable.img_category_meatball,
                name = "Bakso & soto"
            ),
            Category(
                imageCategory = R.drawable.img_category_seafood,
                name = "Seafood"
            ),
            Category(
                imageCategory = R.drawable.img_category_beverages
                , name = "Minuman"
            )
        )
    }

}