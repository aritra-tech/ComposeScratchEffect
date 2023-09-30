package com.aritra.composescratcheffect.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aritra.composescratcheffect.R
import com.aritra.scratcheffect.ScratchEffect

@Composable
fun ScratchCard() {

    val outerImage = ImageBitmap.imageResource(id = R.drawable.outerimage)
    val resultImage = ImageBitmap.imageResource(id = R.drawable.resultimage)

    val pathState = remember {
        mutableStateOf(com.aritra.composescratcheffect.model.Path(path = Path()))
    }
    val movedState = remember {
        mutableStateOf<Offset?>(null)
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize().background(Color.Black)
    ) {
        ScratchEffect(
            overlayImage = outerImage,
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(size = 16.dp)),
            movedOffset = movedState.value,
            onMovedOffset = { x,y ->
                movedState.value = Offset(x,y)
            },
            currentPath = pathState.value.path,
            currentPathThickness = pathState.value.width,
            background = {
                Image(bitmap = resultImage, contentDescription = "", modifier = Modifier.size(200.dp))
            }
        )
    }

}

@Preview
@Composable
fun ScratchCardPreview() {
    ScratchCard()
}