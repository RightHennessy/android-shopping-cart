package woowacourse.shopping.view.shoppingmain

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import woowacourse.shopping.R
import woowacourse.shopping.databinding.ItemProductMainBinding
import woowacourse.shopping.uimodel.ProductUIModel

class ProductsViewHolder(
    parent: ViewGroup,
    private val products: List<ProductUIModel>,
    private val productOnClick: (ProductUIModel) -> Unit,
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_product_main, parent, false)
) {
    private val binding = ItemProductMainBinding.bind(itemView)
    private lateinit var product: ProductUIModel

    init {
        binding.root.setOnClickListener {
            productOnClick(product)
        }
    }

    fun bind(item: ProductUIModel) {
        product = item
        Glide.with(itemView)
            .load(product.url)
            .into(binding.ivProductImage)
        binding.product = product
    }
}
