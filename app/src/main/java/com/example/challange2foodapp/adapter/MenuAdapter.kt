package com.example.foodappchallenge.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.challange2foodapp.databinding.ItemMenuBinding
import com.example.foodappchallenge.model.Menu
import com.example.foodappchallenge.utils.toIndonesianFormat
import java.text.NumberFormat
import java.util.Locale

class MenuAdapter : RecyclerView.Adapter<MenuAdapter.MenuViewHolder>() {

    private val data = mutableListOf<Menu>()

    fun submitData(items: List<Menu>) {
        data.addAll(items)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuViewHolder {
        return MenuViewHolder(
            ItemMenuBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: MenuViewHolder, position: Int) {
        holder.bind(data[position])
    }

    class MenuViewHolder(private val binding: ItemMenuBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Menu) {
            binding.tvMenuName.text = item.name
            binding.tvMenuPrice.text = item.price.toIndonesianFormat()
            binding.ivMenuImg.setImageResource(item.image)
        }
    }
}