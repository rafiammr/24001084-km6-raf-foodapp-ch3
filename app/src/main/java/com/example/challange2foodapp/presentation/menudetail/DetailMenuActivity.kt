package com.example.challange2foodapp.presentation.menudetail

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.challange2foodapp.R
import com.example.challange2foodapp.data.model.Menu
import com.example.challange2foodapp.data.utils.toIndonesianFormat
import com.example.challange2foodapp.databinding.ActivityDetailMenuBinding

class DetailMenuActivity : AppCompatActivity() {

    companion object {
        const val EXTRAS_ITEM = "EXTRAS_ITEM"
    }

    private val binding: ActivityDetailMenuBinding by lazy {
        ActivityDetailMenuBinding.inflate(layoutInflater)
    }

    private var totalItem = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getArgumentData()
    }

    private fun getArgumentData() {
        intent?.extras?.getParcelable<Menu>(EXTRAS_ITEM)?.let {
            setBackgroundMenu(it.imageMenu)
            setMenuDataDetail(it)
        }
    }

    private fun setBackgroundMenu(imageMenu: Int?) {
        imageMenu?.let {
            binding.layoutDetailMenu.layoutDetailMenuHeader.ivDetailMenuBg.setImageResource(
                it
            )
        }
    }

    private fun setMenuDataDetail(menu: Menu) {
        binding.layoutDetailMenu.layoutDetailMenuHeader.tvDetailMenuName.text = menu.name
        binding.layoutDetailMenu.layoutDetailMenuHeader.tvDetailMenuPrice.text =
            menu.price.toIndonesianFormat()
        binding.layoutDetailMenu.layoutDetailMenuHeader.tvDetailMenuDesc.text = menu.shortDesc
        binding.layoutDetailMenu.layoutDetailLocation.tvDetailLocation.text = menu.location

        binding.layoutDetailMenu.layoutDetailLocation.tvLocation.setOnClickListener {
            goGmaps(menu)
        }

        binding.layoutDetailMenu.layoutDetailLocation.tvDetailLocation.setOnClickListener {
            goGmaps(menu)
        }

        binding.layoutDetailMenu.layoutDetailMenuHeader.ibBack.setOnClickListener {
            onBackPressed()
        }

        binding.layoutButtonAddToCart.btnAddItem.setOnClickListener {
            addItem(menu)
        }

        binding.layoutButtonAddToCart.btnSubItem.setOnClickListener {
            subItem(menu)
        }
        val text = resources.getString(R.string.button_add_to_cart, menu.price.toIndonesianFormat())
        binding.layoutButtonAddToCart.btnAddToCart.text = text
    }

    private fun addItem(menu: Menu) {
        totalItem++
        binding.layoutButtonAddToCart.tvTotalItem.text = totalItem.toString()
        updateTotalPrice(menu)
    }

    private fun subItem(menu: Menu) {
        if (totalItem > 1) {
            totalItem--
            binding.layoutButtonAddToCart.tvTotalItem.text = totalItem.toString()
            updateTotalPrice(menu)
        }
    }

    // Handle click event to open the location URL
    private fun goGmaps(menu: Menu) {
        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(menu.urlLocation))
        startActivity(intent)
    }

    private fun updateTotalPrice(menu: Menu) {
        val totalPrice = totalItem * menu.price
        val text = resources.getString(R.string.button_add_to_cart, totalPrice.toIndonesianFormat())
        binding.layoutButtonAddToCart.btnAddToCart.text = text
    }

}