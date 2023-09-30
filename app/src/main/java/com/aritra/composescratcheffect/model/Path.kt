package com.aritra.composescratcheffect.model

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path

data class Path(
    val path: Path,
    val color: Color = Color.White,
    val width: Float = 60f
)