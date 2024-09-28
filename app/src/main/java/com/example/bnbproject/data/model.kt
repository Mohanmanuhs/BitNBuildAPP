package com.example.bnbproject.data


data class Item(
    val name:String,
    val type:String,
    val owner:String,
    val price:String,
    val details: String?=null,
    val used:String,
    val rent:String,
    val selling_price:String,
    val contact: Long
)

val sampleItems= listOf(
    Item(
        "Samsung f12 mobile","Electonics","Mohan h s","$10",
        used ="",
        rent ="", selling_price = "", contact = 7249874923
    ),
    Item(
        "Samsung f12 mobile","Electonics","Mohan h s","$10",
        used ="",
        rent ="", selling_price = "", contact = 7249874923
    ),
    Item(
        "Samsung f12 mobile","Electonics","Mohan h s","$10",
        used ="",
        rent ="", selling_price = "", contact = 7249874923
    ),
    Item(
        "Samsung f12 mobile","Electonics","Mohan h s","$10",
        used ="",
        rent ="", selling_price = "", contact = 7249874923
    ),
    Item(
        "Samsung f12 mobile","Electonics","Mohan h s","$10",
        used ="",
        rent ="", selling_price = "", contact = 7249874923
    ),
    Item(
        "Samsung f12 mobile","Electonics","Mohan h s","$10",
        used ="",
        rent ="", selling_price = "", contact = 7249874923
    ),
    Item(
        "Samsung f12 mobile","Electonics","Mohan h s","$10",
        used ="",
        rent ="", selling_price = "", contact = 7249874923
    ),
    Item(
        "Samsung f12 mobile","Electonics","Mohan h s","$10",
        used ="",
        rent ="", selling_price = "", contact = 7249874923
    ),
)


