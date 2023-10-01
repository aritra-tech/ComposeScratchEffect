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

/**
 * Composable that allows users to scratch off a portion of an overlay image using touch input.
 *
 * @param overlayImage The ImageBitmap to be used as the base image.
 * @param modifier Modifier for positioning and sizing of the ScratchEffect.
 * @param movedOffset The current Offset where the user is scratching (nullable).
 * @param onMovedOffset Callback function to update the movedOffset.
 * @param currentPath The Path representing the scratched area.
 * @param currentPathThickness The thickness of the scratch path.
 * @param background A composable function for rendering the background behind the scratch area.
 */

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