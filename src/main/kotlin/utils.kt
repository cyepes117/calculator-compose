import java.text.NumberFormat
import java.util.*

fun String.subtractPercentage(percentage: String) = this.apply {
    val priceWithDiscount = this.toInt()
        .minus(
            this.toInt()
                .times(
                    percentage.toFloat()
                        .div(100)
                )
        )

    val format = NumberFormat.getCurrencyInstance(Locale.getDefault()).apply {
        maximumFractionDigits = 0
    }

    return format.format(priceWithDiscount)
}
