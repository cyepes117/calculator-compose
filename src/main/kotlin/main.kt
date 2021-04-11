import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp


fun main() {
    Window(
        title = APP_TITLE,
        size = APP_SIZE
    ) {
        MaterialTheme {
            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                // PRICE
                var price by remember { mutableStateOf("") }
                rowTextField(
                    title = PRICE_TITLE,
                    listener = { price = it }
                )

                rowSpacer()

                // REPUTATION
                var discountPercentage by remember { mutableStateOf(REPUTATION_MAP.values.first()) }
                rowDropdown(
                    title = REPUTATION_TITLE,
                    items = REPUTATION_MAP.keys.toList(),
                    listener = { discountPercentage = REPUTATION_MAP[it]!! }
                )

                rowSpacer()

                // WEIGHTS
                var shippingPrice by remember { mutableStateOf(WEIGHT_MAP.values.first()) }
                rowDropdown(
                    title = WEIGHT_TITLE,
                    items = WEIGHT_MAP.keys.toList(),
                    listener = { shippingPrice = WEIGHT_MAP[it]!! }
                )

                rowSpacer()

                // SHIPPING PRICE
                rowText(
                    title = SHIPPING_PRICE_TITLE,
                    content = shippingPrice.subtractPercentage(discountPercentage)
                )


            }
        }

    }
}

private const val APP_TITLE = "CALCULATOR"
private val APP_SIZE = IntSize(960, 720)
private const val PRICE_TITLE = "PRICE"
private const val WEIGHT_TITLE = "WEIGHT"
private val WEIGHT_MAP = mapOf(
    "Hasta 3 Kg" to "10900",
    "De 3 a 5 Kg" to "11400",
    "De 5 a 10 Kg" to "17700",
    "De 10 a 20 Kg" to "27000",
    "De 20 a 30 Kg" to "39000",
    "De 30 a 40 Kg" to "44000",
    "De 40 a 50 Kg" to "63000",
    "De 50 a 90 Kg" to "65000",
    "Más de 90 Kg" to "120000",
)
private const val REPUTATION_TITLE = "REPUTATION"
private val REPUTATION_MAP = mapOf(
    "Naranja / Roja" to "0",
    "Amarilla / Sin reputación" to "40",
    "Verde / MercadoLíderes / Tiendas Oficiales" to "50",
)
private const val SHIPPING_PRICE_TITLE = "SHIPPING PRICE"
