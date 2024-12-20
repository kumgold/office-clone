package net.example.officeclone.core.network.data

import net.example.officeclone.core.database.model.MemberEntity

data class NetworkMember(
    val id: String,
    val name: String,
    val number: String,
    val statusMessage: String,
    val group: String = "",
    val isFavorite: Boolean = false
)

fun NetworkMember.asEntity() = MemberEntity(
    id = id,
    name = name,
    number = number,
    statusMessage = statusMessage,
    group = group,
    isFavorite = isFavorite
)