package woowacourse.shopping.view.shoppingmain

import woowacourse.shopping.uimodel.ProductUIModel
import woowacourse.shopping.uimodel.RecentProductUIModel

interface ShoppingMainContract {
    interface View {
        var presenter: Presenter
        fun showProductDetailPage(): (ProductUIModel) -> Unit
        fun showMoreProducts()
        fun deActivateButton()
        fun activateButton()
    }

    interface Presenter {
        val isPossibleLoad: Boolean
        fun loadProducts(): List<ProductUIModel>
        fun getRecentProducts(): List<RecentProductUIModel>
        fun setProductOnClick()
        fun setLoadMoreOnClick()
    }
}
