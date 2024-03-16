package com.example.challange2foodapp.presentation.menulist.adapter

import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.challange2foodapp.base.ViewHolderBinder
import com.example.challange2foodapp.databinding.ItemMenuListBinding
import com.example.challange2foodapp.data.model.Menu
import com.example.challange2foodapp.data.utils.toIndonesianFormat

class MenuListItemViewHolder (
    private val binding: ItemMenuListBinding,
    private val listener: OnItemClickedListener<Menu>
) : ViewHolder(binding.root), ViewHolderBinder<Menu> {

    override fun bind(item: Menu) {
        item.let {
            setMenuImage(it.imageMenu)
            binding.tvMenuName.text = it.name
            binding.tvMenuPrice.text = it.price.toIndonesianFormat()
            itemView.setOnClickListener{
                listener.onItemClicked(item)
            }
        }
    }

    private fun setMenuImage(image: Int?) {
        image?.let { binding.ivMenuImg.setImageResource(it) }
    }

}