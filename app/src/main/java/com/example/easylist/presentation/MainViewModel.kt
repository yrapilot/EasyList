package com.example.easylist.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.easylist.data.ShopListRepositoryImpl
import com.example.easylist.domain.DeleteShopItemUseCase
import com.example.easylist.domain.EditShopItemUseCase
import com.example.easylist.domain.GetShopListUseCase
import com.example.easylist.domain.ShopItem

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}