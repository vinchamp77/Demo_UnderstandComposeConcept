package vtsen.hashnode.dev.understandcomposeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Divider
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import vtsen.hashnode.dev.understandcomposeapp.components.*
import vtsen.hashnode.dev.understandcomposeapp.components.compositionlocal.CompositionLocalDemo
import vtsen.hashnode.dev.understandcomposeapp.components.compositionlocal.PassByValueDemo
import vtsen.hashnode.dev.understandcomposeapp.components.compositionlocal.StaticCompositionLocalDemo

import vtsen.hashnode.dev.understandcomposeapp.ui.theme.UnderstandComposeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen(useSystemUIController: Boolean = true) {

    LogCompositions("DebugRecomposition", "MainScreen() function scope")

    UnderstandComposeAppTheme(useSystemUIController = useSystemUIController) {

        LogCompositions("DebugRecomposition", "UnderstandComposeAppTheme() content scope")

        Column {
            RecompositionExample()
            Divider(thickness = 3.dp)
            RememberExample()
            Divider(thickness = 3.dp)
            PassByValueDemo()
            CompositionLocalDemo()
            StaticCompositionLocalDemo()
        }
    }
}

