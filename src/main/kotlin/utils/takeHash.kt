package com.thisismeamir.kodeecoin.utils

import java.math.BigInteger
import java.security.MessageDigest

/**
 * Takes the Hash of a given String
 */
fun String.takeHash(algorithm: String = "SHA-256"): String {
    val digestedMessage = MessageDigest.getInstance(algorithm)
    val hashBytes = digestedMessage.digest(this.toByteArray())
    return String.format("%064x", BigInteger(1, hashBytes))
}
