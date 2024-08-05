package com.thisismeamir.kodeecoin.blocks

import com.thisismeamir.kodeecoin.utils.takeHash
import java.time.Instant

data class Block(
    val previousHash: String,
    val data: String,
    val timestamp: Long = Instant.now().toEpochMilli(),
    val salt: Long = 0L,
    var hash: String = ""
){
    init {
        this.hash = this.blockHash()
    }

    fun blockHash(): String{
        return "${previousHash}${data}${timestamp}$salt".takeHash()
    }
}
