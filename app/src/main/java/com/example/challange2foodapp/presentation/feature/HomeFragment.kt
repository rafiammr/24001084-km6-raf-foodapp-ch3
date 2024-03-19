package com.example.challange2foodapp.presentation.feature

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.challange2foodapp.R
import com.example.challange2foodapp.data.datasource.CategoryDataSource
import com.example.challange2foodapp.data.datasource.CategoryDataSourceImpl
import com.example.challange2foodapp.databinding.FragmentHomeBinding
import com.example.challange2foodapp.data.datasource.MenuDataSource
import com.example.challange2foodapp.data.datasource.MenuDataSourceImpl
import com.example.challange2foodapp.data.model.Menu
import com.example.challange2foodapp.presentation.menudetail.DetailMenuActivity
import com.example.challange2foodapp.presentation.menulist.adapter.CategoryAdapter
import com.example.challange2foodapp.presentation.menulist.adapter.MenuAdapter
import com.example.challange2foodapp.presentation.menulist.adapter.OnItemClickedListener


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private var adapterMenu: MenuAdapter? = null
    private var adapterCategory: CategoryAdapter? = null
    private val dataSourceMenu: MenuDataSource by lazy { MenuDataSourceImpl() }
    private val dataSourceCategory: CategoryDataSource by lazy { CategoryDataSourceImpl() }
    private var isUsingGridMode: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapterCategory = CategoryAdapter()
        setListCategory()
        bindMenuList(isUsingGrid = false)
        setClickAction()
    }

    private fun setListCategory() {
        binding.rvCategory.apply {
            adapter = this@HomeFragment.adapterCategory
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
        adapterCategory?.submitData(dataSourceCategory.getCategoryData())
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
        adapterMenu = MenuAdapter(
            listMode = listMode,
            listener = object : OnItemClickedListener<Menu> {
                override fun onItemClicked(item: Menu) {
                    navigateToDetail(item)
                }
            }
        )
        binding.rvMenu.apply {
            adapter = this@HomeFragment.adapterMenu
            layoutManager = GridLayoutManager(requireContext(), if (isUsingGrid) 2 else 1)
        }
        adapterMenu?.submitData(dataSourceMenu.getMenuData())
    }

    private fun navigateToDetail(item: Menu) {
        val navController = findNavController()
        val bundle = bundleOf(Pair(DetailMenuActivity.EXTRAS_ITEM, item))
        navController.navigate(R.id.action_home_fragment_to_detail_menu_activity, bundle)
    }

}
