package com.example.challange2foodapp.presentation.menulist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.challange2foodapp.base.ViewHolderBinder
import com.example.challange2foodapp.data.model.Category
import com.example.challange2foodapp.databinding.ItemCategoryBinding

class CategoryListItemViewHolder (
    private val binding: ItemCategoryBinding
) : ViewHolder(binding.root), ViewHolderBinder<Category> {
    override fun bind(item: Category) {
        item.let {
            setCategoryImage(it.imageCategory)
            binding.tvCategoryName.text = it.name
            }
    }

    private fun setCategoryImage(image: Int?) {
        image?.let { binding.ivCategoryImg.setImageResource(it) }
    }
}