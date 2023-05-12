package woowacourse.shopping.view.productcatalogue

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import woowacourse.shopping.R
import woowacourse.shopping.data.BundleKeys
import woowacourse.shopping.data.ProductMockData
import woowacourse.shopping.data.db.ProductDBHelper
import woowacourse.shopping.data.db.ProductDBRepository
import woowacourse.shopping.databinding.ActivityProductCatalogueBinding
import woowacourse.shopping.uimodel.MainProductCatalogueUIModel
import woowacourse.shopping.uimodel.ProductUIModel
import woowacourse.shopping.uimodel.RecentProductCatalogueUIModel
import woowacourse.shopping.view.shoppingcart.ShoppingCartActivity
import woowacourse.shopping.view.productdetail.ProductDetailActivity

class ProductCatalogueActivity : AppCompatActivity(), ProductCatalogueContract.View {
    private lateinit var binding: ActivityProductCatalogueBinding
    override lateinit var presenter: ProductCatalogueContract.Presenter
    private val adapter: MainProductCatalogueAdapter = MainProductCatalogueAdapter(
        ProductMockData.mainProductMockData,
        ProductMockData.recentProductMockData,
        showProductDetailPage(),
    )

    override fun showProductDetailPage(): (ProductUIModel) -> Unit = {
        val intent = ProductDetailActivity.intent(this)
        intent.putExtra(BundleKeys.KEY_PRODUCT, it)
        startActivity(intent)
    }

    override fun onResume() {
        super.onResume()
        val dbHelper = ProductDBHelper(this)
        val db = dbHelper.writableDatabase
        val repository = ProductDBRepository(db)
        val recentProducts = repository.getAll(ProductDBHelper.TABLE_NAME)

        adapter.update(
            RecentProductCatalogueUIModel(
                MainProductCatalogueUIModel(recentProducts)
            )
        )
        adapter.notifyDataSetChanged()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_catalogue)

        setSupportActionBar(binding.tbProductCatalogue)

        presenter = ProductCataloguePresenter(this)

        binding.rvProductCatalogue.adapter = adapter
        val gridLayoutManager = GridLayoutManager(binding.root.context, 2)
        gridLayoutManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup() {
            override fun getSpanSize(position: Int): Int {
                if (position == 0) return 2
                return 1
            }
        }

        binding.rvProductCatalogue.layoutManager = gridLayoutManager

        adapter.notifyDataSetChanged()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.tool_bar_product_catalogue, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.menu_cart -> {
                startActivity(ShoppingCartActivity.intent(this))
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}