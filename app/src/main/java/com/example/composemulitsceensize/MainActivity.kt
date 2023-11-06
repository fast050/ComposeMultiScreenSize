package com.example.composemulitsceensize

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.composemulitsceensize.data.DataProvider
import com.example.composemulitsceensize.ui.theme.ComposeMulitSceenSizeTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeMulitSceenSizeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val windowSizeClass = calculateWindowSizeClass(activity = this)
                    MySootheApp(windowSizeClass)
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun PreviewSearchBar() {
    MySootheAppPortrait()
}

@Composable
private fun MySootheAppLandscape(){
    ComposeMulitSceenSizeTheme() {
        Row {
            BottomNavigationRailPart()
            Column {
                SearchBar()
                HomeScreen()
            }

        }
    }
}

@Composable
private fun MySootheApp(windowSize : WindowSizeClass){
    when(windowSize.widthSizeClass){
        WindowWidthSizeClass.Compact -> {
            MySootheAppPortrait()
        }

        WindowWidthSizeClass.Expanded->{
            MySootheAppLandscape()
        }
    }
}

@Composable
private fun MySootheAppPortrait() {
    ComposeMulitSceenSizeTheme() {
        Scaffold(
            bottomBar = { BottomNavigationPart() },
            topBar = { SearchBar() },
            content = { paddingValues ->
                HomeScreen(Modifier.padding(paddingValues))
            }
        )

    }
}

@Composable
private fun HomeScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.verticalScroll(rememberScrollState())) {
        HomeSection(
            title = R.string.align_your_body
        ) {
            AlignYourBodyRow()
        }

        HomeSection(
            title = R.string.favorite_collections
        ) {
            FavoriteCollectionGrid()
        }

        HomeSection(
            title = R.string.align_your_body
        ) {
            AlignYourBodyRow()
        }

        HomeSection(
            title = R.string.favorite_collections
        ) {
            FavoriteCollectionGrid()
        }

        Spacer(Modifier.height(16.dp))
    }

}

@Composable
private fun BottomNavigationRailPart(modifier: Modifier = Modifier) {
    NavigationRail(
        backgroundColor = Color.LightGray,
        contentColor = Color.White,

        ) {
        Column(
            modifier = modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_home))
                },
                selected = true,
                onClick = {}
            )
            Spacer(modifier = Modifier.height(8.dp))
            NavigationRailItem(
                icon = {
                    Icon(
                        imageVector = Icons.Default.AccountCircle,
                        contentDescription = null
                    )
                },
                label = {
                    Text(stringResource(R.string.bottom_navigation_profile))
                },
                selected = false,
                onClick = {}
            )
        }
    }
}

@Composable
private fun BottomNavigationPart(
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        modifier = modifier,
        contentColor = Color.White,
        backgroundColor = Color.LightGray
    ) {
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.Star,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_home)
                )
            },
            selected = true,
            onClick = {}
        )
        BottomNavigationItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = null
                )
            },
            label = {
                Text(
                    text = stringResource(R.string.bottom_navigation_profile)
                )
            },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
private fun HomeSection(
    @StringRes title: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column {
        Text(
            text = stringResource(id = title),
            modifier = modifier
                .paddingFromBaseline(top = 40.dp, bottom = 16.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
fun SearchBar(modifier: Modifier = Modifier) {

    TextField(value = "",
        onValueChange = {},
        modifier = modifier
            .fillMaxWidth()
            .heightIn(56.dp)
            .padding(20.dp),
        colors = TextFieldDefaults.textFieldColors(
            focusedIndicatorColor = MaterialTheme.colors.surface,
            unfocusedIndicatorColor = MaterialTheme.colors.surface
        ),
        leadingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.search_icon),
                contentDescription = stringResource(id = R.string.search_description_label)
            )
        },
        placeholder = { Text(text = stringResource(id = R.string.place_holder_search)) }
    )

}

@Composable
fun AlignYourBodyRow(modifier: Modifier = Modifier) {
    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(16.dp)

    ) {
        items(DataProvider.AlignYourBodyList) { item ->
            AlignYourBodyElement(
                name = item.name,
                imageRes = item.imageRes
            )
        }
    }
}

@Composable
fun FavoriteCollectionGrid(
    modifier: Modifier = Modifier
) {
    LazyHorizontalGrid(
        rows = GridCells.Fixed(2),
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        modifier = modifier.height(168.dp),
        content = {
            items(DataProvider.favoriteCollectionsList) { item ->
                FavoriteCollectionCard(name = item.name, imageRes = item.imageRes)
            }
        }
    )


}

@Composable
fun AlignYourBodyElement(
    modifier: Modifier = Modifier,
    @DrawableRes imageRes: Int = R.drawable.ab5_hiit,
    @StringRes name: Int = R.string.ab5_hiit
) {

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "",
            modifier = modifier
                .clip(CircleShape)
                .size(88.dp),
            contentScale = ContentScale.Crop
        )

        Text(
            text = stringResource(id = name),
            style = MaterialTheme.typography.body1,
            modifier = Modifier.paddingFromBaseline(top = 24.dp, bottom = 8.dp)
        )
    }
}

@Composable
fun FavoriteCollectionCard(
    modifier: Modifier = Modifier,
    @DrawableRes imageRes: Int = R.drawable.fc2_nature_meditations,
    @StringRes name: Int = R.string.fc2_nature_meditations
) {
    Surface(
        shape = MaterialTheme.shapes.medium,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.width(255.dp)
        ) {
            Image(
                painter = painterResource(id = imageRes),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(80.dp)
            )
            Text(
                text = stringResource(id = name),
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
    }

}
