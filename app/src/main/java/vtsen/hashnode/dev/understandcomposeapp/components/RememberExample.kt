package vtsen.hashnode.dev.understandcomposeapp.components

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*

@Composable
fun RememberExample() {
    var countNoRemember = getInitValue()
    var countWithRemember = remember { getInitValue() }
    var countWithRememberMutableState by remember { mutableStateOf(getInitValue()) }

    Column {
        Text(text = "countWithoutRemember: $countNoRemember")
        Text(text = "countWithRemember: $countWithRemember")
        Text(text = "countWithRememberMutableState.value: ${countWithRememberMutableState}")

        Button(onClick = {
            ++countNoRemember
        }) { Text(text = "++countWithoutRemember") }

        Button(onClick = {
            ++countWithRemember

        }) { Text(text = "++countWithRemember") }

        Button(onClick = {
            ++countWithRememberMutableState
        }) { Text(text = "++countWithRememberMutableState.value") }
    }
}

fun getInitValue(): Int {
    Log.d("RememberExample", "getInitValue() is called!")
    return 0
}
