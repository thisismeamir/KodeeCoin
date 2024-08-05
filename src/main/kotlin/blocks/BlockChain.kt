package com.thisismeamir.kodeecoin.blocks

class BlockChain {

    private val chain = mutableListOf<Block>()

    val difficulty: Int get() = 12

    fun addBlock(block: Block) {
        chain.add(block)
    }

    fun lastBlock(): Block {
        return chain.last()
    }

    private val hardness: Int = 2
    private val validPrefix: String = "0".repeat(hardness)

    fun isMined(block: Block): Boolean {
        return block.hash.startsWith(validPrefix)
    }

    fun mine(block: Block): Block {

        println("Mining: $block")

        var mining: Block = block.copy()
        while (!isMined(mining)) {
            mining = block.copy(salt = mining.salt + 1)
        }
        println("Mined: $mining")
        return mining


    }
}
