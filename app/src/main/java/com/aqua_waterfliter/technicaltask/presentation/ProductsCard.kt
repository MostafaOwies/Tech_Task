package com.aqua_waterfliter.technicaltask.presentation

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.aqua_waterfliter.technicaltask.domain.entities.ProductsItem


@Composable
fun ProductsCard(
    products: ProductsItem,
    onProductsClick: () -> Unit,
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(onClick = onProductsClick),
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center,
        ) {
            AsyncImage(
                modifier = Modifier
                    .width(350.dp)
                    .height(350.dp)
                    .padding(all = 12.dp),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(products.image)
                    .crossfade(true)
                    .build(),
                contentDescription = "Product_Image",
                contentScale = ContentScale.FillBounds
            )
            Column(modifier = Modifier.padding(all = 12.dp)) {
                Text(
                    modifier = Modifier.padding(vertical = 8.dp),
                    text = products.title,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontSize = MaterialTheme.typography.titleLarge.fontSize,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    modifier = Modifier.padding(bottom = 8.dp),
                    text = products.price.toString(),
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis
                )
            }
        }
    }
}