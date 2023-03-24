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
    Log.d(tag, "Start Parent - LocalInt: ${LocalInt.current} ")

    CompositionLocalProvider(
        LocalInt provides LocalInt.current + 1,
    ) {
        Child()
    }

    Log.d(tag, "End Parent - LocalInt: ${LocalInt.current}")
}

@Composable
private fun Child() {
    Log.d(tag, "Start Child - LocalInt: ${LocalInt.current} ")

    GrandChild()

    Log.d(tag, "Emd Child - LocalInt: ${LocalInt.current} ")
}

@Composable
private fun GrandChild() {
    Log.d(tag, "Start GrandChild")
    Log.d(tag, "End GrandChild")
}