package com.example.lab7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolarGuitarsAppScreens()
        }
    }
}

@Composable
fun SolarGuitarsAppScreens() {
    val pagerState = rememberPagerState(pageCount = { 3 })

    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFE5E5E5))
    ) { page ->
        when (page) {
            0 -> GuitarProductCard()     // Карточка 1
            1 -> ArtistQuoteCard()       // Карточка 2
            2 -> FilterAndCatalogCard()  // Карточка 3
        }
    }
}

// КАРТОЧКА 1: Главный экран товара (A1.8C)
@Composable
fun GuitarProductCard() {
    Surface(
        modifier = Modifier.fillMaxSize().padding(12.dp),
        shape = RoundedCornerShape(28.dp),
        color = Color(0xFF141517)
    ) {
        Box(modifier = Modifier.fillMaxSize().padding(22.dp)) {
            TopBrandBar(isDarkText = false)

            Column(
                modifier = Modifier.align(Alignment.TopCenter).padding(top = 52.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "A1.8C",
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily.SansSerif,
                    letterSpacing = 2.sp
                )
                Spacer(Modifier.height(6.dp))
                Text(
                    text = "CARBON\nBLACK MATT",
                    color = Color.LightGray,
                    fontSize = 13.sp,
                    lineHeight = 17.sp,
                    letterSpacing = 1.5.sp,
                    textAlign = TextAlign.Center
                )
            }

            Image(
                painter = painterResource(id = R.drawable.image_kar1),
                contentDescription = "Solar A1.8C",
                modifier = Modifier.fillMaxHeight(0.65f).align(Alignment.Center).padding(top = 40.dp),
                contentScale = ContentScale.Fit
            )

            Text(
                text = "SPECS",
                color = Color.LightGray,
                fontSize = 13.sp,
                fontWeight = FontWeight.Medium,
                letterSpacing = 2.5.sp,
                modifier = Modifier.align(Alignment.TopStart).padding(top = 155.dp).rotate(-90f)
            )

            Column(
                modifier = Modifier.align(Alignment.CenterEnd),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(48.dp).background(Color.White, CircleShape)
                ) {
                    Text("→", color = Color.Black, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
                IconButton(
                    onClick = { },
                    modifier = Modifier.size(48.dp).background(Color(0xFF25272A), CircleShape)
                ) {
                    Text("←", color = Color.White, fontSize = 20.sp, fontWeight = FontWeight.Bold)
                }
            }

            Row(
                modifier = Modifier.fillMaxWidth().align(Alignment.BottomCenter),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.Bottom
            ) {
                Column {
                    Text(
                        text = "1.299€",
                        color = Color.White,
                        fontSize = 26.sp,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "PREORDER",
                        color = Color.Gray,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.SemiBold,
                        letterSpacing = 1.2.sp
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    Text(
                        text = "Filters",
                        color = Color.White,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Medium
                    )
                    Box(
                        modifier = Modifier.size(32.dp).background(Color.White, CircleShape),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("2", color = Color.Black, fontSize = 14.sp, fontWeight = FontWeight.Bold)
                    }
                }
            }
        }
    }
}

// КАРТОЧКА 2: Экран с основателем и цитатой
@Composable
fun ArtistQuoteCard() {
    Surface(
        modifier = Modifier.fillMaxSize().padding(12.dp),
        shape = RoundedCornerShape(28.dp),
        color = Color(0xFFDCDCDC)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = R.drawable.fon_kar2),
                contentDescription = "Ola Englund",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(modifier = Modifier.padding(22.dp)) {
                TopBrandBar(isDarkText = true)
            }

            Text(
                text = "COMPARE SOLAR GUITARS",
                color = Color.White,
                fontSize = 12.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 2.sp,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .offset(x = (-75).dp, y = (-30).dp)
                    .rotate(-90f)
            )

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.BottomCenter)
                    .padding(14.dp),
                shape = RoundedCornerShape(22.dp),
                color = Color(0xFF141517).copy(alpha = 0.92f)
            ) {
                Column(
                    modifier = Modifier.padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "«We have put every\npossible effort into\ndesigning the finest looking,\nmost comfortable playing\nand stellar sounding guitars\non the market today»",
                        color = Color.White,
                        fontSize = 16.sp,
                        lineHeight = 23.sp,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(24.dp))
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = "Ola Englund",
                            color = Color.LightGray,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.SemiBold
                        )
                        Text(
                            text = "Signature",
                            color = Color.Gray,
                            fontSize = 14.sp,
                            fontStyle = FontStyle.Italic
                        )
                    }
                }
            }
        }
    }
}
// КАРТОЧКА 3: Шторка фильтров и каталог Type V
@Composable
fun FilterAndCatalogCard() {
    val filterItems = listOf("Type V", "Scale", "Number of Strings", "Shipping Around", "Color Body", "Body Wood")

    Surface(
        modifier = Modifier.fillMaxSize().padding(12.dp),
        shape = RoundedCornerShape(28.dp),
        color = Color(0xFF141517)
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Surface(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(bottomStart = 28.dp, bottomEnd = 28.dp),
                color = Color(0xFFF3F3F3)
            ) {
                Column(modifier = Modifier.padding(horizontal = 24.dp, vertical = 26.dp)) {
                    Text(
                        text = "Filter options",
                        color = Color.Black,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.ExtraBold,
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Spacer(modifier = Modifier.height(20.dp))

                    filterItems.forEach { item ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable { }
                                .padding(vertical = 9.dp),
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text = item,
                                color = Color.Black,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Medium
                            )
                            Text(
                                text = "⌄",
                                color = Color.Black,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "GUITARS",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.ExtraBold,
                    letterSpacing = 2.sp
                )
                Text(
                    text = "TYPE V",
                    color = Color.Gray,
                    fontSize = 13.sp,
                    fontWeight = FontWeight.SemiBold,
                    letterSpacing = 1.5.sp
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(
                    modifier = Modifier.fillMaxSize(),
                    horizontalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    Column(
                        modifier = Modifier.weight(1f).fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image1_kar3),
                            contentDescription = "V2.6MDS",
                            modifier = Modifier.weight(1f).padding(vertical = 6.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("V2.6MDS", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                            Text("749€", color = Color.LightGray, fontSize = 15.sp)
                        }
                    }

                    Column(
                        modifier = Modifier.weight(1f).fillMaxHeight(),
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.SpaceBetween
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.image2_kar3),
                            contentDescription = "V1.7FBB",
                            modifier = Modifier.weight(1f).padding(vertical = 6.dp),
                            contentScale = ContentScale.Fit
                        )
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text("V1.7FBB", color = Color.White, fontSize = 15.sp, fontWeight = FontWeight.Bold)
                            Text(
                                text = "1.299€",
                                color = Color.Gray,
                                fontSize = 15.sp,
                                textDecoration = TextDecoration.LineThrough
                            )
                        }
                    }
                }
            }
        }
    }
}

// Общий компонент верхней панели (Лого + Меню)
@Composable
fun TopBrandBar(isDarkText: Boolean) {
    val contentColor = if (isDarkText) Color.Black else Color.White
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "SOLAR",
            color = contentColor,
            fontSize = 22.sp,
            fontWeight = FontWeight.Black,
            fontStyle = FontStyle.Italic,
            letterSpacing = 2.5.sp
        )
        Column(horizontalAlignment = Alignment.End) {
            Box(Modifier.width(24.dp).height(2.5.dp).background(contentColor))
            Spacer(Modifier.height(5.dp))
            Box(Modifier.width(14.dp).height(2.5.dp).background(contentColor))
        }
    }
}
