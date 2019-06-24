package com.sefthuko.bitwiseinsertion

import io.kotlintest.properties.Gen
import io.kotlintest.properties.assertAll
import io.kotlintest.shouldBe
import io.kotlintest.specs.StringSpec
import kotlin.math.absoluteValue

@ExperimentalUnsignedTypes
data class BitSpan(val M: UInt, val i: Int, val j: Int)

@ExperimentalUnsignedTypes
class GenBitSpan: Gen<BitSpan> {
    override fun constants() = emptyList<BitSpan>()
    override fun random() = generateSequence {
        val i = Gen.int().random().first().absoluteValue % 32
        val j = when (i) {
            31 -> 31
            else -> (Gen.int().random().first().absoluteValue % (31 - i)) + i
        }
        val M = GenUInt().random().first() shr (31 - (j - i))

        BitSpan(M, i, j)
    }
}

@ExperimentalUnsignedTypes
class GenUInt: Gen<UInt> {
    override fun constants() = emptyList<UInt>()
    override fun random() = generateSequence {
        Gen.long().random().first().toUInt()
    }
}

@ExperimentalUnsignedTypes
class BitwiseInsertionTests: StringSpec() {
    init {
        "Bitwise Insertion" {
            assertAll(GenUInt(), GenBitSpan()) { N: UInt, b: BitSpan ->
                b.run {
                    val result = doBitwiseInsertion(N, M, i, j)

                    val bitmask = (0u.inv() shr (31 - j + i)) shl i
                    val invBitmask = bitmask.inv()

                    (result and bitmask) shr i shouldBe M
                    (result and invBitmask) shouldBe (N and invBitmask)
                }
            }
        }
    }
}