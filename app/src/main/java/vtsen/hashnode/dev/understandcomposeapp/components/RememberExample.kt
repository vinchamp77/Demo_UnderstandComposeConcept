package vtsen.hashnode.dev.understandcomposeapp.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun RememberExample() {
    var countNormal = getInitValue()
    var countRemember = remember { getInitValue() }
    var countRememberMutableState by remember { mutableStateOf(getInitValue()) }

    Column {
        Text(text = "countNormal: $countNormal")
        Text(text = "countRemember: $countRemember")
        Text(text = "countRememberMutableState: ${countRememberMutableState}")

        Button(onClick = {
            ++countNormal
        }) { Text(text = "++countWithoutRemember") }

        Button(onClick = {
            ++countRemember

        }) { Text(text = "++countWithRemember") }

        Button(onClick = {
            ++countRememberMutableState
        }) { Text(text = "++countWithRememberMutableState.value") }
    }
}

fun getInitValue(): Int {
    Log.d("RememberExample", "getInitValue() is called!")
    return 0
}
