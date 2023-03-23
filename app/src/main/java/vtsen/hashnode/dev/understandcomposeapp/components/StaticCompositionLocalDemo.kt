package vtsen.hashnode.dev.understandcomposeapp.components

import android.util.Log
import androidx.compose.runtime.*

private val LocalInt = staticCompositionLocalOf { 0 }

@Composable
fun StaticCompositionLocalDemo() {

    var counter by remember {
        mutableStateOf(0)
    }

    MyButton(onClick = { ++counter }, text = "CompositionLocal Demo")

    CompositionLocalProvider(
        LocalInt provides counter,
    ) {
        Parent()
    }
}

@Composable
private fun Parent() {
    Log.d("LocalInt", "Enter Parent - LocalInt: ${LocalInt.current} ")

    CompositionLocalProvider(
        LocalInt provides LocalInt.current + 1,
    ) {
        Child()
    }

    Log.d("LocalInt", "Exit Parent - LocalInt: ${LocalInt.current}")
}

@Composable
private fun Child() {
    Log.d("LocalInt", "Child - LocalInt: ${LocalInt.current} ")

    GrandChild()
}

@Composable
private fun GrandChild() {
    Log.d("LocalInt", "GarndChild")
}