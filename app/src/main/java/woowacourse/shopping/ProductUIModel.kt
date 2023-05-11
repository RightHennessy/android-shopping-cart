package woowacourse.shopping

class ProductUIModel(
    val url: String,
    val name: String,
    val price: Int,
) : java.io.Serializable {
    companion object {
        val dummy = ProductUIModel("", "", 0)
    }
}
