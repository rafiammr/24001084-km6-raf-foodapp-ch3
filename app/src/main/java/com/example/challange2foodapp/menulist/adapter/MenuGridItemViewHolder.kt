package com.example.challange2foodapp.menulist.adapter

import android.media.Image
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.challange2foodapp.base.ViewHolderBinder
import com.example.challange2foodapp.databinding.ItemMenuBinding
import com.example.challange2foodapp.data.model.Menu
import com.example.challange2foodapp.utils.toIndonesianFormat

class MenuGridItemViewHolder (
    private val binding: ItemMenuBinding,
) : ViewHolder(binding.root), ViewHolderBinder<Menu> {

    override fun bind(item: Menu) {
        item.let {
            setMenuImage(it.image)
            binding.tvMenuName.text = it.name
            binding.tvMenuPrice.text = it.price.toIndonesianFormat()
        }
    }

    private fun setMenuImage(image: Int?) {
        image?.let { binding.ivMenuImg.setImageResource(it) }
    }
}