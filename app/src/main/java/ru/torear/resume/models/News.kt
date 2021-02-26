package ru.torear.resume.models

data class News(
    val id: Int,
    val title: String,
    val text: String,
    val createDate: String,
    val imgRes: Int,
    val isExpand: Boolean
)
