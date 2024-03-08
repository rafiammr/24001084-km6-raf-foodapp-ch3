package com.example.challange2foodapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.challange2foodapp.databinding.ActivityMainBinding
import com.example.foodappchallenge.adapter.CategoryAdapter
import com.example.foodappchallenge.adapter.MenuAdapter
import com.example.foodappchallenge.model.Category
import com.example.foodappchallenge.model.Menu

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val adapterCategory = CategoryAdapter()
    private val adapterMenu = MenuAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setListCategory()
        setListMenu()
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

    private fun setListMenu() {
        val data = listOf(
            Menu(image = R.drawable.img_menu_dimsum, name = "Dimsum Mix", price = 20000.00),
            Menu(image = R.drawable.img_menu_pukis, name = "Kue pukis pandan", price = 15000.00),
            Menu(image = R.drawable.img_menu_martabak_manis, name = "Martabak manis", price = 23000.00),
            Menu(image = R.drawable.img_menu_martabak_telur, name = "Martabak telur", price = 30000.00),
            Menu(image = R.drawable.img_menu_takoyaki, name = "Takoyaki", price = 13000.00),
            Menu(image = R.drawable.img_menu_corndog, name = "Corndog", price = 10000.00),
            Menu(image = R.drawable.img_menu_topokki, name = "Topokki", price = 15000.00),
            Menu(image = R.drawable.img_menu_pempek, name = "Pempek", price = 25000.00),
        )
        binding.rvMenu.apply {
            adapter = this@MainActivity.adapterMenu
        }
        adapterMenu.submitData(data)
    }

}