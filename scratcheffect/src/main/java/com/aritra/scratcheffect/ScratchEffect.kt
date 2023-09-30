package com.aritra.scratcheffect

import android.view.MotionEvent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.ClipOp
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.input.pointer.pointerInteropFilter
import androidx.compose.ui.unit.IntSize

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun ScratchEffect(
    overlayImage: ImageBitmap,
    modifier: Modifier = Modifier,
    movedOffset: Offset?,
    onMovedOffset: (Float, Float) -> Unit,
    currentPath: Path,
    currentPathThickness: Float,
    background: @Composable () -> Unit
) {

    Box(modifier = modifier.clipToBounds()) {
        background()
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInteropFilter {
                    when (it.action) {
                        MotionEvent.ACTION_DOWN -> {
                            println("(${it.x}, ${it.y})")
                            currentPath.moveTo(it.x, it.y)
                        }
                        MotionEvent.ACTION_MOVE -> {
                            println("(${it.x}, ${it.y})")
                            onMovedOffset(it.x, it.y)
                        }
                    }
                    true
                }
        ) {
            val canvasWidth = size.width.toInt()
            val canvasHeight = size.height.toInt()
            val imageSize = IntSize(width = canvasWidth, height = canvasHeight)

            movedOffset?.let {
                currentPath.addOval(oval = Rect(it, currentPathThickness))
            }

            clipPath(path = currentPath, clipOp = ClipOp.Difference) {
                drawImage(
                    image = overlayImage,
                    dstSize = imageSize
                )
            }
        }
    }
}