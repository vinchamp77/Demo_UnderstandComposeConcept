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
    Log.d(tag, "************** Pass by Value **************")

    Parent(counter)
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

@Composable
private fun Parent(value: Int) {
    Log.d(tag, "Enter Parent - value: $value")

    Child(value + 1)

    Log.d(tag, "Exit Parent - value: $value")
}

@Composable
private fun Child(value: Int) {
    Log.d(tag, "Enter Child - value: $value")

    GrandChild()

    Log.d(tag, "Exit Child - value: $value")
}