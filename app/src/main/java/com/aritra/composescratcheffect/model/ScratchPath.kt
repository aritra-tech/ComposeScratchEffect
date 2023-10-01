package com.aritra.composescratcheffect.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

/**
 * Data class representing the properties of a scratch path in a scratch card effect.
 *
 * @param path The Android `Path` that defines the shape of the scratch.
 * @param color The color of the scratch path. Default is [Color.White].
 * @param width The width of the scratch path. Default is 60f.
 */

data class ScratchPath(
    val path: Path,
    val color: Color = Color.White,
    val width: Float = 60f
)