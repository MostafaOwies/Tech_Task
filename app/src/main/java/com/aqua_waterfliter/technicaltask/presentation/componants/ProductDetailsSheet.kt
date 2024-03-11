package com.aqua_waterfliter.technicaltask.presentation.componants

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
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
fun ProductDetailsSheet(
    selectedProduct: MutableState<ProductsItem?>? = null,
    onConfirmClick: () -> Unit,
) {

    selectedProduct?.value.let { product ->

        Box(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                AsyncImage(
                    modifier = Modifier
                        .width(350.dp)
                        .height(350.dp)
                        .padding(all = 12.dp),
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(product?.image)
                        .crossfade(true)
                        .build(),
                    contentDescription = "Product_Image",
                    contentScale = ContentScale.FillBounds
                )
                Column(modifier = Modifier.padding(all = 12.dp)) {
                    product?.title?.let {
                        Text(
                            modifier = Modifier.padding(vertical = 8.dp),
                            text = it,
                            maxLines = 2,
                            overflow = TextOverflow.Ellipsis,
                            fontSize = MaterialTheme.typography.titleLarge.fontSize,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    product?.description?.let {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = it,
                            maxLines = 6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Row {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = "Price: ",
                            maxLines = 6,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold
                        )

                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = product?.price.toString(),
                            maxLines = 6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Row {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = "Rating: ",
                            maxLines = 6,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = product?.rating?.rate.toString(),
                            maxLines = 6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Row {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = "Count: ",
                            maxLines = 6,
                            overflow = TextOverflow.Ellipsis,
                            fontWeight = FontWeight.Bold
                        )
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = product?.rating?.count.toString(),
                            maxLines = 6,
                            overflow = TextOverflow.Ellipsis
                        )
                    }

                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(44.dp),
                        onClick = onConfirmClick
                    ) {
                        Text(
                            modifier = Modifier.padding(bottom = 8.dp),
                            text = "Confirm",
                        )
                    }
                }
            }
        }
    }
}