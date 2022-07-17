package vtsen.hashnode.dev.understandcomposeapp.components

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*


@Composable
fun RecompositionExample() {
    var count by remember { mutableStateOf(0) }

    LogCompositions("DebugRecomposition", "DebugRecompositionExample() function scope")

    Column {

        LogCompositions("DebugRecomposition", "Column() content scope")

        MyButton(onClick = { count++ }, text = count.toString())

    }
}

@Composable
fun MyButton(

    onClick: () -> Unit,
    text: String) {

    LogCompositions("DebugRecomposition", "MyButton() function")

    Button(onClick = onClick) {

        LogCompositions("DebugRecomposition", "Button() content")

        Text(
            text = text,
        )
    }
}