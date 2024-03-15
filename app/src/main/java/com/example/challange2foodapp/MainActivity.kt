package com.example.challange2foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.challange2foodapp.databinding.ActivityMainBinding
import com.example.challange2foodapp.menulist.adapter.CategoryAdapter
import com.example.challange2foodapp.menulist.adapter.MenuAdapter
import com.example.challange2foodapp.data.model.Category
import com.example.challange2foodapp.data.model.Menu

class MainActivity : AppCompatActivity() {

    private val TAG: String? = MainActivity::class.java.name

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapterCategory = CategoryAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: Activity Created")
        setContentView(binding.root)
        setListCategory()
    }

    private fun setListCategory() {
        val data = listOf(
            Category(image = R.drawable.img_category_rice, name = "Nasi"),
            Category(image = R.drawable.img_category_noodle, name = "Mie"),
            Category(image = R.drawable.img_category_snack, name = "Snack"),
            Category(image = R.drawable.img_category_fastfood, name = "Fast food"),
            Category(image = R.drawable.img_category_meatball, name = "Bakso & soto"),
            Category(image = R.drawable.img_category_seafood, name = "Seafood"),
            Category(image = R.drawable.img_category_beverages, name = "Minuman")
        )
        binding.rvCategory.apply {
            adapter = this@MainActivity.adapterCategory
        }
        adapterCategory.submitData(data)
    }

}