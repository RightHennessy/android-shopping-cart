package com.shopping.repository

import com.shopping.domain.CartProduct

interface CartProductRepository {
    fun getAll(): List<CartProduct>
    fun getAllProductsCount(): Int
    fun insert(cartProduct: CartProduct)
    fun remove(cartProduct: CartProduct)
    fun loadCartProducts(index: Pair<Int, Int>): List<CartProduct>
    fun update(cartProduct: CartProduct)
    fun add(cartProduct: CartProduct)
}
