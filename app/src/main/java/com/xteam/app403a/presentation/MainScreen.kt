package com.xteam.app403a.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.tab.CurrentTab
import cafe.adriel.voyager.navigator.tab.LocalTabNavigator
import cafe.adriel.voyager.navigator.tab.Tab
import cafe.adriel.voyager.navigator.tab.TabNavigator
import com.xteam.app403a.ui.theme.PrimaryColor

private val selectedIndex: MutableState<Int> = mutableStateOf(1)

class MainScreen: Screen {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    override fun Content() {
        Scaffold(bottomBar = {

        }) {
            Content2()
        }
    }
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun Content2() {
        TabNavigator(HomeTab) { tabNavigator ->
            Scaffold(
                content = {
                    CurrentTab()
                },
                bottomBar = {
                    BottomNavigation {
                        TabNavigationItem(HomeTab)
                        TabNavigationItem(CategoryTab)
                        TabNavigationItem(BasketTab)
                        TabNavigationItem(MenuTab)
                    }
                }
            )
        }
    }

    @Composable
    private fun RowScope.TabNavigationItem(tab: Tab) {
        val tabNavigator = LocalTabNavigator.current
        BottomNavigationItem(
            selected = tabNavigator.current.key == tab.key,
            onClick = { tabNavigator.current = tab },
            icon = { Icon(painter = tab.options.icon!!, contentDescription = tab.options.title) },
            selectedContentColor = Color.White,
            unselectedContentColor = Color.Black,
            modifier = Modifier.background(if(tabNavigator.current.key == tab.key){
                PrimaryColor
            } else {
                Color.White
            })
        )
    }
}
@Preview (showBackground = true)
@Composable
fun CustomPreview(){
    MainScreen().Content()
}