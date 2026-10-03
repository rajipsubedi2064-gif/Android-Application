package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class CardActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CardBody()
        }
    }
}

data class DashboardCardItem(
    val title: String,
    val subtitle: String,
    val imageRes: Int
)

@Composable
fun CardBody() {

    val cardList = listOf(
        DashboardCardItem("Text", "11 items content", R.drawable.text),
        DashboardCardItem("Address", "5 items content", R.drawable.address),
        DashboardCardItem("Character", "15 items content", R.drawable.img_c),
        DashboardCardItem("Bank card", "5 items content", R.drawable.bank_card),
        DashboardCardItem("Password", "21 items content", R.drawable.password),
        DashboardCardItem("Logistics", "13 items content", R.drawable.logistics)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF00C88C))
            .verticalScroll(rememberScrollState())
            .padding(horizontal = 20.dp, vertical = 28.dp)
    ) {
        // Top Header
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 24.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(
                    text = "Card",
                    color = Color.White,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "Simple and easy to use app",
                    color = Color.White.copy(alpha = 0.9f),
                    fontSize = 16.sp
                )
            }

            Image(
                painter = painterResource(R.drawable.hjyguggy),
                contentDescription = "Profile",
                modifier = Modifier
                    .size(46.dp)
                    .clip(CircleShape)
                    .border(1.5.dp, Color.White, CircleShape),
                contentScale = ContentScale.Crop
            )
        }

        // 2-Column Grid (3 Rows)
        for (i in cardList.indices step 2) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 12.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                GridCardItem(
                    item = cardList[i],
                    modifier = Modifier.weight(1f)
                )

                if (i + 1 < cardList.size) {
                    GridCardItem(
                        item = cardList[i + 1],
                        modifier = Modifier.weight(1f)
                    )
                } else {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }

        // Bottom Settings Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 4.dp),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(R.drawable.setting),
                    contentDescription = "Settings",
                    modifier = Modifier.size(44.dp),
                    contentScale = ContentScale.Fit
                )

                Spacer(modifier = Modifier.width(16.dp))

                Column {
                    Text(
                        text = "Settings",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color(0xFF2B2B2B)
                    )
                    Spacer(modifier = Modifier.height(2.dp))
                    Text(
                        text = "Fingerprint code and so on",
                        fontSize = 12.sp,
                        color = Color(0xFFAAAAAA)
                    )
                }
            }
        }
    }
}


@Composable
fun GridCardItem(
    item: DashboardCardItem,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp, horizontal = 12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(item.imageRes),
                contentDescription = item.title,
                modifier = Modifier.size(52.dp),
                contentScale = ContentScale.Fit
            )

            Spacer(modifier = Modifier.height(12.dp))

            Text(
                text = item.title,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF2B2B2B)
            )

            Spacer(modifier = Modifier.height(4.dp))

            Text(
                text = item.subtitle,
                fontSize = 12.sp,
                color = Color(0xFFAAAAAA)
            )
        }
    }
}

@Preview
@Composable
fun CardBodyPreview() {
    CardBody()
}