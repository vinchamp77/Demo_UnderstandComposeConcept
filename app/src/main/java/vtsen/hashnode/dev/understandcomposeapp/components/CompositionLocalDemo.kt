package vtsen.hashnode.dev.understandcomposeapp.components

import android.util.Log
import androidx.compose.runtime.*

private val LocalInt = compositionLocalOf { 0 }
private val tag = "CompLocal"

@Composable
fun CompositionLocalDemo() {

    var counter by remember {
        mutableStateOf(0)
    }

    MyButton(onClick = { ++counter }, text = "CompositionLocal Demo")

    Log.d(tag, "************** Using CompositionLocal **************")
    CompositionLocalProvider(
        LocalInt provides counter,
    ) {
        Parent()
    }
}

@Composable
private fun Parent() {
    Log.d(tag, "Enter Parent - LocalInt: ${LocalInt.current} ")

    CompositionLocalProvider(
        LocalInt provides LocalInt.current + 1,
    ) {
        Child()
    }

    Log.d(tag, "Exit Parent - LocalInt: ${LocalInt.current}")
}

@Composable
private fun Child() {
    Log.d(tag, "Enter Child - LocalInt: ${LocalInt.current} ")

    GrandChild()

    Log.d(tag, "Exit Child - LocalInt: ${LocalInt.current} ")
}

@Composable
private fun GrandChild() {
    Log.d(tag, "Enter GrandChild")
}