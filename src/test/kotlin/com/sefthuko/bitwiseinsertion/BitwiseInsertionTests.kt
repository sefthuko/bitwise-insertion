package com.sefthuko.bitwiseinsertion

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

@UseExperimental(kotlin.ExperimentalUnsignedTypes::class)
class BitwiseInsertionTests {
    @Test
    fun shouldPassTheInterviewTest() {
        Assertions.assertEquals(0b10001001100u,
            doBitwiseInsertion(0b10000000000u, 0b10011u, 2, 6))
    }

    @Test
    fun shouldClearTheLocationFirst() {
        Assertions.assertEquals(0b10001001100u,
            doBitwiseInsertion(0b10000110000u, 0b10011u, 2, 6))
    }

    @Test
    fun shouldReplaceTheWholeThing() {
        Assertions.assertEquals(0b11111111111111111111111111111111u,
            doBitwiseInsertion(0u, 0b11111111111111111111111111111111u, 0, 31))
        Assertions.assertEquals(0u,
            doBitwiseInsertion(0b11111111111111111111111111111111u, 0u, 0, 31))
    }
}