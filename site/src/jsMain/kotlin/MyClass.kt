import androidx.compose.runtime.*
import org.jetbrains.compose.web.dom.Div
import org.jetbrains.compose.web.dom.Text

internal class MyClass {
    @Composable
    fun test() {
        Div {
            Text("Error")
        }
    }
}

internal val MyCompositionLocal = staticCompositionLocalOf<MyClass?> { null }