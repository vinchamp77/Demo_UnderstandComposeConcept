package vtsen.hashnode.dev.understandcomposeapp.components

import android.util.Log
import androidx.compose.runtime.*

val LocalInt = compositionLocalOf { 0 }
val LocalStaticInt = staticCompositionLocalOf { 0 }

@Composable
fun CompositionLocalDemo() {

    var run by remember {
        mutableStateOf(false)
    }

    MyButton(onClick = { run = !run }, text = "CompositionLocal Demo")

    if (run) {
        CompositionLocalProvider(
            LocalInt provides 1,
            LocalStaticInt provides 1
        ) {
            Parent()
        }
    }
}

@Composable
fun Parent() {
    Log.d("LocalInt", "Parent - LocalInt: ${LocalInt.current} LocalStaticInt: ${LocalStaticInt.current}")

    CompositionLocalProvider(
        LocalInt provides 2,
        LocalStaticInt provides 2
    ) {
        Child()
    }

    Log.d("LocalInt", "Parent - LocalInt: ${LocalInt.current} LocalStaticInt: ${LocalStaticInt.current}")
}

@Composable
fun Child() {
    Log.d("LocalInt", "Child - LocalInt: ${LocalInt.current} LocalStaticInt: ${LocalStaticInt.current}")
}