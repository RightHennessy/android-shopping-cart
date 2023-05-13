package woowacourse.shopping.view.shoppingmain

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import woowacourse.shopping.uimodel.ProductUIModel
import woowacourse.shopping.uimodel.RecentProductUIModel

class RecentProductAdapter(
    private var recentProducts: List<RecentProductUIModel>,
    private val productOnClick: (ProductUIModel) -> Unit,
) : RecyclerView.Adapter<RecentProductViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecentProductViewHolder {
        return RecentProductViewHolder(parent, productOnClick)
    }

    override fun getItemViewType(position: Int): Int {
        return RECENT_PRODUCT_VIEW_TYPE
    }

    override fun getItemCount(): Int = recentProducts.size

    override fun onBindViewHolder(holder: RecentProductViewHolder, position: Int) {
        holder.bind(recentProducts[position].productUIModel)
    }

    fun update(updatedRecentProducts: List<RecentProductUIModel>) {
        recentProducts = updatedRecentProducts
        notifyDataSetChanged()
    }

    companion object {
        const val RECENT_PRODUCT_VIEW_TYPE = 22
    }
}