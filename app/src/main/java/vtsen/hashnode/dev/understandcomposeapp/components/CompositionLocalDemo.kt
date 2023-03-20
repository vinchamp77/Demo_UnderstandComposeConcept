package vtsen.hashnode.dev.understandcomposeapp.components

import android.util.Log
import androidx.compose.runtime.*

val LocalInt = compositionLocalOf { 0 }

@Composable
fun CompositionLocalDemo() {

    var run by remember {
        mutableStateOf(false)
    }

    MyButton(onClick = { run = !run }, text = "CompositionLocal Demo")

    if (run) {
        CompositionLocalProvider(LocalInt provides 1) {
            Parent1()
        }
    }
}

@Composable
fun Parent1() {
    Log.d("LocalInt", "Parent1: ${LocalInt.current}")

    CompositionLocalProvider(LocalInt provides 2) {
        Child1()
    }

    Log.d("LocalInt", "Parent1: ${LocalInt.current}")
}

@Composable
fun Child1() {
    Log.d("LocalInt", "Child1: ${LocalInt.current}")
}