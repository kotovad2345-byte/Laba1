package com.example.myapplication

import androidx.compose.foundation.background
import androidx.compose.material3.MaterialTheme
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.safeDrawing

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = colorResource(R.color.background)
            ) {
                BusinessCard()
            }
        }
    }
}

@Composable
fun BusinessCard() {
    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .padding(WindowInsets.safeDrawing.asPaddingValues())
    ) {
        if (maxWidth < maxHeight) {
            PortraitLayout()
        } else {
            LandscapeLayout()
        }
    }
}





@Composable
fun PortraitLayout() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Avatar()
        Info()
    }
}

@Composable
fun LandscapeLayout() {
    Row(
        modifier = Modifier.fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Avatar()
        Info()
    }
}

@Composable
fun Avatar() {
    Image(
        painter = painterResource(R.drawable.android_logo),
        contentDescription = null,
        modifier = Modifier.size(dimensionResource(R.dimen.avatar_size))
    )
}

@Composable
fun Info() {
    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.space_medium)))

    Text(
        text = stringResource(R.string.name),
        style = MaterialTheme.typography.headlineSmall
    )

    Text(
        text = stringResource(R.string.group),
        style = MaterialTheme.typography.bodyMedium
    )

    Spacer(modifier = Modifier.height(dimensionResource(R.dimen.space_small)))

    Text(text = stringResource(R.string.email))
    Text(text = stringResource(R.string.phone))

}
//laba1
