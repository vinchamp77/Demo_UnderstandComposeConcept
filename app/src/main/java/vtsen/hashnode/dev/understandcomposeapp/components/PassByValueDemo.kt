package vtsen.hashnode.dev.understandcomposeapp.components

import android.util.Log
import androidx.compose.runtime.*

private val tag = "CompLocal"

@Composable
fun PassByValueDemo() {

    var counter by remember {
        mutableStateOf(0)
    }

    MyButton(onClick = { ++counter }, text = "PassByValue Demo")

    Log.d(tag, "************** Pass by Value **************")

    Parent(counter)
}

@Composable
private fun Parent(value: Int) {
    Log.d(tag, "Start Parent - value: $value")

    Child(value + 1)

    Log.d(tag, "End Parent - value: $value")
}

@Composable
private fun Child(value: Int) {
    Log.d(tag, "Start Child - value: $value")

    GrandChild()

    Log.d(tag, "End Child - value: $value")
}


@Composable
private fun GrandChild() {
    Log.d(tag, "Start GrandChild")
    Log.d(tag, "End GrandChild")
}