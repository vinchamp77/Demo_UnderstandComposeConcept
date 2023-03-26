package vtsen.hashnode.dev.understandcomposeapp.components.compositionlocal

import android.util.Log
import androidx.compose.runtime.*
import vtsen.hashnode.dev.understandcomposeapp.components.MyButton

private val LocalInt = staticCompositionLocalOf { 0 }
private val tag = "CompLocal"

@Composable
fun StaticCompositionLocalDemo() {

    var counter by remember {
        mutableStateOf(-1)
    }

    MyButton(onClick = { ++counter }, text = "StaticCompositionLocal Demo")

    if(counter < 0) return

    Log.d(tag, "************** Using StaticCompositionLocal **************")
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
    Log.d(tag, "End Child - LocalInt: ${LocalInt.current} ")
}

@Composable
private fun GrandChild() {
    Log.d(tag, "Start GrandChild")
    Log.d(tag, "End GrandChild")
}