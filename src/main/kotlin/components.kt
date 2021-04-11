import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp


@Composable
fun rowDropdown(
    title: String,
    items: List<String>,
    listener: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.weight(1f)
                .align(alignment = Alignment.CenterVertically)
        )
        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text = items[selectedIndex],
                modifier = Modifier.clickable(onClick = { expanded = true })
            )
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
            ) {
                items.forEachIndexed { index, data ->
                    DropdownMenuItem(
                        onClick = {
                            selectedIndex = index
                            expanded = false
                            listener(items[selectedIndex])
                        }
                    ) {
                        Text(
                            text = data,
                            style = MaterialTheme.typography.body1,
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun rowTextField(
    title: String,
    listener: (String) -> Unit
) {
    var price by remember { mutableStateOf("") }
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.weight(1f)
                .align(alignment = Alignment.CenterVertically)
        )
        TextField(
            value = price,
            onValueChange = {
                price = it
                listener(it)
            },
            modifier = Modifier.weight(1f),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
    }
}

@Composable
fun rowText(
    title: String,
    content: String
) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            style = MaterialTheme.typography.h6,
            modifier = Modifier.weight(1f)
                .align(alignment = Alignment.CenterVertically)
        )
        Text(
            text = content,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.weight(1f)
                .align(alignment = Alignment.CenterVertically)
        )
    }
}

@Composable
fun rowSpacer() = Column {
    verticalSpacer()
    Divider()
    verticalSpacer()
}

@Composable
private fun verticalSpacer() = Spacer(
    modifier = Modifier.size(
        width = 0.dp,
        height = 15.dp
    )
)
