package net.example.officeclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import net.example.officeclone.core.data.ConnectivityManagerNetworkMonitor
import net.example.officeclone.navigation.ui.OfficeApp
import net.example.officeclone.navigation.ui.rememberOfficeAppState
import net.example.officeclone.ui.theme.OfficeCloneTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val networkMonitor = ConnectivityManagerNetworkMonitor(applicationContext)

        enableEdgeToEdge()
        setContent {
            val appState = rememberOfficeAppState(networkMonitor = networkMonitor)
            OfficeCloneTheme {
                OfficeApp(appState = appState)
            }
        }
    }
}
