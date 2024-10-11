package com.example.composeshadowclipping

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Component()
        }
    }
}

@Composable
fun Component() {
    Column(
        verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        ItemsRow(
            leftSide = {
                Text("No clipping - background in modifier:")

                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 1.dp,
                            shape = CircleShape,
                            clip = false
                        )
                        .background(Color.Green)
                        .size(100.dp)
                )
            },
            rightSide = {
                Text("No clipping - background in child:")

                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 1.dp,
                            shape = CircleShape,
                            clip = false
                        )
                ) {
                    Spacer(
                        modifier = Modifier
                            .background(Color.Green)
                            .size(100.dp)
                    )
                }
            }
        )

        ItemsRow(
            leftSide = {
                Text("With clipping - background in modifier:")

                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 1.dp,
                            shape = CircleShape,
                            clip = true
                        )
                        .background(Color.Green)
                        .size(100.dp)
                )
            },
            rightSide = {
                Text("With clipping - background in child:")

                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 1.dp,
                            shape = CircleShape,
                            clip = true
                        )
                ) {
                    Spacer(
                        modifier = Modifier
                            .background(Color.Green)
                            .size(100.dp)
                    )
                }
            }
        )
        
        ItemsRow(
            leftSide = {
                Text("Default - background in modifier:")

                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 1.dp,
                            shape = CircleShape
                        )
                        .background(Color.Green)
                        .size(100.dp)
                )
            },
            rightSide = {
                Text("Default - background in child:")

                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 1.dp,
                            shape = CircleShape
                        )
                ) {
                    Spacer(
                        modifier = Modifier
                            .background(Color.Green)
                            .size(100.dp)
                    )
                }
            }
        )

        ItemsRow(
            leftSide = {
                Text("Default - 0 elevation - background in modifier:")

                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 0.dp,
                            shape = CircleShape
                        )
                        .background(Color.Green)
                        .size(100.dp)
                )
            },
            rightSide = {
                Text("Default - 0 elevation - background in child:")

                Box(
                    modifier = Modifier
                        .shadow(
                            elevation = 0.dp,
                            shape = CircleShape
                        )
                ) {
                    Spacer(
                        modifier = Modifier
                            .background(Color.Green)
                            .size(100.dp)
                    )
                }
            }
        )
    }
}

@Composable
fun ItemsRow(
    leftSide: @Composable () -> Unit,
    rightSide: @Composable () -> Unit,
    a: Boolean = true
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
    ) {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            leftSide()
        }

        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp, alignment = Alignment.CenterVertically),
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.weight(1f)
        ) {
            rightSide()
        }
    }
}

@Preview
@Composable
fun ComponentPreview() {
    Component()
}