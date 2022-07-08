package hk.adell.android.googleplayinstant

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import hk.adell.android.googleplayinstant.ui.theme.GooglePlayInstantSandboxTheme

class MainActivity : ComponentActivity() {
  @RequiresApi(Build.VERSION_CODES.O)
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      GooglePlayInstantSandboxTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
          Column {
            Greeting("Android")
            IsInstantMessage(packageManager.isInstantApp)
          }
        }
      }
    }
  }
}

@Composable
fun Greeting(name: String) {
  Text(text = "Hello $name!")
}

@Composable
fun IsInstantMessage(isInstantApp: Boolean) {
  val message = if (isInstantApp) "Instant app experience" else "Traditional app experience"
  Text(text = message)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
  GooglePlayInstantSandboxTheme { Greeting("Android") }
}
