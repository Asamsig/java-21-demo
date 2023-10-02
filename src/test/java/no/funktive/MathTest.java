package no.funktive;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * added methods to `Math` class:
 * <ul>
 *      <li> ceilDiv() </li>
 *      <li> ceilDivExact() throws `ArithmeticException` in case of overflow, otherwise identical to ceilDiv()</li>
 *      <li> ceilMod() </li>
 *      <li> clamp(value, min, max) </li>
 * </ul>
 * Added method BigInteger::parallelMultiply(BigInteger)
 */
class MathTest {

    @Test
    void clamp() {
        var allowedRangeOld = manualClamp(17, 18, 30);
        var allowedRangeNew = Math.clamp(17, 18, 30);

        assertEquals(18, allowedRangeNew);
        assertEquals(allowedRangeOld, allowedRangeNew);
    }

    private static int manualClamp(int value, int min, int max) {
        return Math.min(max, Math.max(value, min));
    }

    @Test
    void ceilDiv() {
        var div = 17d / 18;
        var ceilDiv = Math.ceilDiv(17, 18);
        var floorDiv = Math.floorDiv(17, 18);

        assertEquals(0.9444444444444444d, div);
        assertEquals(0, floorDiv);
        assertEquals(1, ceilDiv);
    }

}
