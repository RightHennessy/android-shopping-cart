package woowacourse.shopping.view.shoppingmain

import androidx.recyclerview.widget.RecyclerView
import woowacourse.shopping.databinding.ItemProductMainBinding
import woowacourse.shopping.uimodel.ProductUIModel

class ProductsViewHolder(
    private val binding: ItemProductMainBinding,
    private val products: List<ProductUIModel>,
    private val productOnClick: (ProductUIModel) -> Unit,
) :
    RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener {
            productOnClick(products[adapterPosition - 1])
        }
    }

    fun bind(item: ProductUIModel) {
        binding.product = item
    }
}