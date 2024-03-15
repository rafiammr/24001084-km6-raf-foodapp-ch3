package com.example.challange2foodapp.data.datasource

import com.example.challange2foodapp.R
import com.example.challange2foodapp.data.model.Menu

interface MenuDataSource {
    fun getMenuData(): List<Menu>
}

class MenuDataSourceImpl() : MenuDataSource {
    override fun getMenuData(): List<Menu> {
        return mutableListOf(
            Menu(
                image = R.drawable.img_menu_dimsum,
                name = "Dimsum Mix",
                price = 20000.00,
                shortDesc = "ini makanan",
                location = "ini lokasi",
                urlLocation = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                image = R.drawable.img_menu_pukis,
                name = "Kue pukis pandan",
                price = 15000.00,
                shortDesc = "ini makanan",
                location = "ini lokasi",
                urlLocation = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                image = R.drawable.img_menu_martabak_manis,
                name = "Martabak manis",
                price = 23000.00,
                shortDesc = "ini makanan",
                location = "ini lokasi",
                urlLocation = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                image = R.drawable.img_menu_martabak_telur,
                name = "Martabak telur",
                price = 30000.00,
                shortDesc = "ini makanan",
                location = "ini lokasi",
                urlLocation = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                image = R.drawable.img_menu_takoyaki,
                name = "Takoyaki",
                price = 13000.00,
                shortDesc = "ini makanan",
                location = "ini lokasi",
                urlLocation = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                image = R.drawable.img_menu_corndog,
                name = "Corndog",
                price = 10000.00,
                shortDesc = "ini makanan",
                location = "ini lokasi",
                urlLocation = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                image = R.drawable.img_menu_topokki,
                name = "Topokki",
                price = 15000.00,
                shortDesc = "ini makanan",
                location = "ini lokasi",
                urlLocation = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
            Menu(
                image = R.drawable.img_menu_pempek,
                name = "Pempek",
                price = 25000.00,
                shortDesc = "ini makanan",
                location = "ini lokasi",
                urlLocation = "https://maps.app.goo.gl/h4wQKqaBuXzftGK77"
            ),
        )
    }
}