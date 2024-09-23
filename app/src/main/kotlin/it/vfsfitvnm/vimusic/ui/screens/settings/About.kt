package it.vfsfitvnm.vimusic.ui.screens.settings

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.BasicText
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import it.vfsfitvnm.vimusic.BuildConfig
import it.vfsfitvnm.vimusic.LocalPlayerAwareWindowInsets
import it.vfsfitvnm.vimusic.ui.components.themed.Header
import it.vfsfitvnm.vimusic.ui.styling.LocalAppearance
import it.vfsfitvnm.vimusic.utils.secondary

@ExperimentalAnimationApi
@Composable
fun About() {
    val (colorPalette, typography) = LocalAppearance.current
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .background(colorPalette.background0)
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(
                LocalPlayerAwareWindowInsets.current
                    .only(WindowInsetsSides.Vertical + WindowInsetsSides.End)
                    .asPaddingValues()
            )
    ) {
        Header(title = "About") {
            BasicText(
                text = "v${BuildConfig.VERSION_NAME} by Ayush Sharma",
                style = typography.s.secondary
            )
        }

        SettingsEntryGroupText(title = "SOCIAL")

        SettingsEntry(
            title = "Instagram",
            text = "Follow me on Instagram..",
            onClick = {
                uriHandler.openUri("https://www.instagram.com/ayushsharma4247/")
            }
        )

        SettingsGroupSpacer()

        SettingsEntryGroupText(title = "TROUBLESHOOTING")

        SettingsEntry(
            title = "Report an issue",
            text = "You will be redirected to my Telegram",
            onClick = {
                uriHandler.openUri("https://t.me/@Ayush424")
            }
        )

        SettingsEntry(
            title = "Suggest an Idea",
            text = "You will be redirected to Telegram",
            onClick = {
                uriHandler.openUri("https://t.me/@Ayush424")
            }
        )
    }
}
