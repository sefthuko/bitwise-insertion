package com.sefthuko.bitwiseinsertion

@ExperimentalUnsignedTypes
fun doBitwiseInsertion(N: UInt, M: UInt, i: Int, j: Int): UInt {
    // insert M into N such that M starts at bit j and ends at bit i.
    val numberOfBits = j - i + 1
    val bitmask = 0u.inv() shr (32 - numberOfBits) shl i
    val invBitMask = bitmask.inv()

    val clearedN = N and invBitMask
    val shiftedM = M shl i
    return clearedN or shiftedM
}
