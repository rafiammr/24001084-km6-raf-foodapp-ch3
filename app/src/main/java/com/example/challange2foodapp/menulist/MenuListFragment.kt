package com.example.challange2foodapp.menulist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.example.challange2foodapp.R
import com.example.challange2foodapp.databinding.FragmentMenuListBinding
import com.example.challange2foodapp.data.datasource.MenuDataSource
import com.example.challange2foodapp.data.datasource.MenuDataSourceImpl
import com.example.challange2foodapp.menulist.adapter.MenuAdapter


class MenuListFragment : Fragment() {

    private lateinit var binding: FragmentMenuListBinding
    private var adapter: MenuAdapter? = null
    private val dataSource: MenuDataSource by lazy { MenuDataSourceImpl() }
    private var isUsingGridMode: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentMenuListBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        bindMenuList(isUsingGrid = false)
        setClickAction()
    }

    private fun setClickAction() {
        binding.layoutHeaderMenu.ivIconGridList.setOnClickListener {
            isUsingGridMode = !isUsingGridMode
            setIcon(isUsingGridMode)
            bindMenuList(isUsingGridMode)
        }
    }

    private fun setIcon(usingGridMode: Boolean) {
        binding.layoutHeaderMenu.ivIconGridList.setImageResource(if (usingGridMode) R.drawable.ic_grid else R.drawable.ic_list)

    }

    private fun bindMenuList(isUsingGrid: Boolean) {
        val listMode = if (isUsingGridMode) MenuAdapter.MODE_GRID  else MenuAdapter.MODE_LIST
        adapter = MenuAdapter(
            listMode = listMode
        )
        binding.rvMenu.apply {
            adapter = this@MenuListFragment.adapter
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        adapter?.submitData(dataSource.getMenuData())
    }

}
