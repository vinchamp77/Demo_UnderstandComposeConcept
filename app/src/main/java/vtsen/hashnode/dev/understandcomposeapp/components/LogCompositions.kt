package vtsen.hashnode.dev.understandcomposeapp.components

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentRecomposeScope
import androidx.compose.runtime.remember
import vtsen.hashnode.dev.understandcomposeapp.BuildConfig

class RecompositionCounter(var value: Int)

@Composable
inline fun LogCompositions(tag: String, msg: String) {
    if (BuildConfig.DEBUG) {
        val recompositionCounter = remember { RecompositionCounter(0) }

        Log.d(tag, "$msg ${recompositionCounter.value} $currentRecomposeScope")
        recompositionCounter.value++
    }
}