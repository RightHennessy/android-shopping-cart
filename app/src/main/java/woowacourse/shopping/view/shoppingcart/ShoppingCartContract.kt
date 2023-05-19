package woowacourse.shopping.view.shoppingcart

import com.shopping.domain.Count
import woowacourse.shopping.model.Paging
import woowacourse.shopping.model.uimodel.CartProductUIModel

interface ShoppingCartContract {
    interface View {
        var presenter: Presenter
        fun updateCartProduct(cartProducts: List<CartProductUIModel>)
        fun activatePageUpCounter()
        fun deactivatePageUpCounter()
        fun activatePageDownCounter()
        fun deactivatePageDownCounter()
        fun updatePageCounter(count: Int)
    }

    interface Presenter {
        val paging: Paging
        fun loadCartProducts(): List<CartProductUIModel>
        fun removeCartProduct(cartProductUIModel: CartProductUIModel)
        fun loadNextPage(isActivated: Boolean)
        fun loadPreviousPage(isActivated: Boolean)
        fun updateCartProductCount(cartProductUIModel: CartProductUIModel)
    }
}
