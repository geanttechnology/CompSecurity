// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.math;

import com.google.common.base.Preconditions;
import com.google.common.primitives.UnsignedLongs;
import java.math.RoundingMode;

// Referenced classes of package com.google.common.math:
//            MathPreconditions, IntMath

public final class LongMath
{
    private static abstract class MillerRabinTester extends Enum
    {

        private static final MillerRabinTester $VALUES[];
        public static final MillerRabinTester LARGE;
        public static final MillerRabinTester SMALL;

        private long powMod(long l, long l1, long l2)
        {
            long l3;
            long l4;
            for (l3 = 1L; l1 != 0L; l3 = l4)
            {
                l4 = l3;
                if ((1L & l1) != 0L)
                {
                    l4 = mulMod(l3, l, l2);
                }
                l = squareMod(l, l2);
                l1 >>= 1;
            }

            return l3;
        }

        static boolean test(long l, long l1)
        {
            MillerRabinTester millerrabintester;
            if (l1 <= 0xb504f333L)
            {
                millerrabintester = SMALL;
            } else
            {
                millerrabintester = LARGE;
            }
            return millerrabintester.testWitness(l, l1);
        }

        private boolean testWitness(long l, long l1)
        {
            int j = Long.numberOfTrailingZeros(l1 - 1L);
            l %= l1;
            if (l == 0L)
            {
                return true;
            }
            l = powMod(l, l1 - 1L >> j, l1);
            if (l == 1L)
            {
                return true;
            }
            int i = 0;
            for (; l != l1 - 1L; l = squareMod(l, l1))
            {
                i++;
                if (i == j)
                {
                    return false;
                }
            }

            return true;
        }

        public static MillerRabinTester valueOf(String s)
        {
            return (MillerRabinTester)Enum.valueOf(com/google/common/math/LongMath$MillerRabinTester, s);
        }

        public static MillerRabinTester[] values()
        {
            return (MillerRabinTester[])$VALUES.clone();
        }

        abstract long mulMod(long l, long l1, long l2);

        abstract long squareMod(long l, long l1);

        static 
        {
            SMALL = new MillerRabinTester("SMALL", 0) {

                long mulMod(long l, long l1, long l2)
                {
                    return (l * l1) % l2;
                }

                long squareMod(long l, long l1)
                {
                    return (l * l) % l1;
                }

            };
            LARGE = new MillerRabinTester("LARGE", 1) {

                private long plusMod(long l, long l1, long l2)
                {
                    if (l >= l2 - l1)
                    {
                        return (l + l1) - l2;
                    } else
                    {
                        return l + l1;
                    }
                }

                private long times2ToThe32Mod(long l, long l1)
                {
                    int i = 32;
                    int j;
                    long l2;
                    do
                    {
                        j = Math.min(i, Long.numberOfLeadingZeros(l));
                        l2 = UnsignedLongs.remainder(l << j, l1);
                        j = i - j;
                        i = j;
                        l = l2;
                    } while (j > 0);
                    return l2;
                }

                long mulMod(long l, long l1, long l2)
                {
                    long l6 = l >>> 32;
                    long l3 = l1 >>> 32;
                    long l4 = l & 0xffffffffL;
                    long l5 = l1 & 0xffffffffL;
                    l1 = times2ToThe32Mod(l6 * l3, l2) + l6 * l5;
                    l = l1;
                    if (l1 < 0L)
                    {
                        l = UnsignedLongs.remainder(l1, l2);
                    }
                    return plusMod(times2ToThe32Mod(l + l4 * l3, l2), UnsignedLongs.remainder(l4 * l5, l2), l2);
                }

                long squareMod(long l, long l1)
                {
                    long l2 = l >>> 32;
                    long l3 = l & 0xffffffffL;
                    long l4 = times2ToThe32Mod(l2 * l2, l1);
                    l2 = l2 * l3 * 2L;
                    l = l2;
                    if (l2 < 0L)
                    {
                        l = UnsignedLongs.remainder(l2, l1);
                    }
                    return plusMod(times2ToThe32Mod(l4 + l, l1), UnsignedLongs.remainder(l3 * l3, l1), l1);
                }

            };
            $VALUES = (new MillerRabinTester[] {
                SMALL, LARGE
            });
        }

        private MillerRabinTester(String s, int i)
        {
            super(s, i);
        }

    }


    static final long FLOOR_SQRT_MAX_LONG = 0xb504f333L;
    static final long MAX_POWER_OF_SQRT2_UNSIGNED = 0xb504f333f9de6484L;
    static final int biggestBinomials[] = {
        0x7fffffff, 0x7fffffff, 0x7fffffff, 0x3a25db, 0x1dc79, 16175, 4337, 1733, 887, 534, 
        361, 265, 206, 169, 143, 125, 111, 101, 94, 88, 
        83, 79, 76, 74, 72, 70, 69, 68, 67, 67, 
        66, 66, 66, 66
    };
    static final int biggestSimpleBinomials[] = {
        0x7fffffff, 0x7fffffff, 0x7fffffff, 0x285146, 0x150eb, 11724, 3218, 1313, 684, 419, 
        287, 214, 169, 139, 119, 105, 95, 87, 81, 76, 
        73, 70, 68, 66, 64, 63, 62, 62, 61, 61, 
        61
    };
    static final long factorials[] = {
        1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 0x58980L, 
        0x375f00L, 0x2611500L, 0x1c8cfc00L, 0x17328cc00L, 0x144c3b2800L, 0x13077775800L, 0x130777758000L, 0x1437eeecd8000L, 0x16beecca730000L, 0x1b02b9306890000L, 
        0x21c3677c82b40000L
    };
    static final long halfPowersOf10[] = {
        3L, 31L, 316L, 3162L, 31622L, 0x4d343L, 0x3040a5L, 0x1e28678L, 0x12d940b6L, 0xbc7c871cL, 
        0x75cdd4719L, 0x49a0a4c700L, 0x2e0466fc608L, 0x1cc2c05dbc53L, 0x11f9b83a95b45L, 0xb3c13249d90bbL, 0x7058bf6e27a751L, 0x463777a4d8c892dL, 0x2be2aac7077d5bc3L
    };
    static final byte maxLog10ForLeadingZeros[] = {
        19, 18, 18, 18, 18, 17, 17, 17, 16, 16, 
        16, 15, 15, 15, 15, 14, 14, 14, 13, 13, 
        13, 12, 12, 12, 12, 11, 11, 11, 10, 10, 
        10, 9, 9, 9, 9, 8, 8, 8, 7, 7, 
        7, 6, 6, 6, 6, 5, 5, 5, 4, 4, 
        4, 3, 3, 3, 3, 2, 2, 2, 1, 1, 
        1, 0, 0, 0
    };
    private static final long millerRabinBaseSets[][];
    static final long powersOf10[] = {
        1L, 10L, 100L, 1000L, 10000L, 0x186a0L, 0xf4240L, 0x989680L, 0x5f5e100L, 0x3b9aca00L, 
        0x2540be400L, 0x174876e800L, 0xe8d4a51000L, 0x9184e72a000L, 0x5af3107a4000L, 0x38d7ea4c68000L, 0x2386f26fc10000L, 0x16345785d8a0000L, 0xde0b6b3a7640000L
    };

    private LongMath()
    {
    }

    public static long binomial(int i, int j)
    {
        int k;
        long l3;
        MathPreconditions.checkNonNegative("n", i);
        MathPreconditions.checkNonNegative("k", j);
        boolean flag;
        if (j <= i)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "k (%s) > n (%s)", new Object[] {
            Integer.valueOf(j), Integer.valueOf(i)
        });
        k = j;
        if (j > i >> 1)
        {
            k = i - j;
        }
        k;
        JVM INSTR tableswitch 0 1: default 88
    //                   0 126
    //                   1 128;
           goto _L1 _L2 _L3
_L1:
        if (i >= factorials.length) goto _L5; else goto _L4
_L4:
        l3 = factorials[i] / (factorials[k] * factorials[i - k]);
_L7:
        return l3;
_L2:
        return 1L;
_L3:
        return (long)i;
_L5:
        if (k >= biggestBinomials.length || i > biggestBinomials[k])
        {
            return 0x7fffffffffffffffL;
        }
        if (k >= biggestSimpleBinomials.length || i > biggestSimpleBinomials[k])
        {
            break; /* Loop/switch isn't completed */
        }
        long l1 = i;
        byte byte0 = 2;
        j = i - 1;
        i = byte0;
        do
        {
            l3 = l1;
            if (i > k)
            {
                break;
            }
            l1 = (l1 * (long)j) / (long)i;
            j--;
            i++;
        } while (true);
        if (true) goto _L7; else goto _L6
_L6:
        j = log2(i, RoundingMode.CEILING);
        long l5 = 1L;
        long l4 = i;
        long l2 = 1L;
        int i1 = j;
        byte byte1 = 2;
        int l = i - 1;
        i = i1;
        i1 = byte1;
        while (i1 <= k) 
        {
            if (i + j < 63)
            {
                l4 *= l;
                l2 *= i1;
                i += j;
            } else
            {
                l5 = multiplyFraction(l5, l4, l2);
                l4 = l;
                l2 = i1;
                i = j;
            }
            i1++;
            l--;
        }
        return multiplyFraction(l5, l4, l2);
    }

    public static long checkedAdd(long l, long l1)
    {
        boolean flag1 = true;
        long l2 = l + l1;
        boolean flag;
        if ((l ^ l1) < 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((l ^ l2) < 0L)
        {
            flag1 = false;
        }
        MathPreconditions.checkNoOverflow(flag1 | flag);
        return l2;
    }

    public static long checkedMultiply(long l, long l1)
    {
label0:
        {
            boolean flag2 = false;
            int i = Long.numberOfLeadingZeros(l) + Long.numberOfLeadingZeros(~l) + Long.numberOfLeadingZeros(l1) + Long.numberOfLeadingZeros(~l1);
            if (i > 65)
            {
                return l * l1;
            }
            boolean flag;
            long l2;
            boolean flag1;
            if (i >= 64)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            MathPreconditions.checkNoOverflow(flag1);
            if (l >= 0L)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            if (l1 != 0x8000000000000000L)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            MathPreconditions.checkNoOverflow(flag | i);
            l2 = l * l1;
            if (l != 0L)
            {
                flag1 = flag2;
                if (l2 / l != l1)
                {
                    break label0;
                }
            }
            flag1 = true;
        }
        MathPreconditions.checkNoOverflow(flag1);
        return l2;
    }

    public static long checkedPow(long l, int i)
    {
        boolean flag2;
        flag2 = true;
        MathPreconditions.checkNonNegative("exponent", i);
        boolean flag;
        boolean flag1;
        if (l >= -2L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if (l <= 2L)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (!(flag1 & flag)) goto _L2; else goto _L1
_L1:
        (int)l;
        JVM INSTR tableswitch -2 2: default 76
    //                   -2 137
    //                   -1 103
    //                   0 95
    //                   1 99
    //                   2 113;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        throw new AssertionError();
_L6:
        if (i != 0) goto _L9; else goto _L7
_L7:
        return 1L;
_L9:
        return 0L;
_L5:
        if ((i & 1) == 0) goto _L7; else goto _L10
_L10:
        return -1L;
_L8:
        if (i < 63)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        MathPreconditions.checkNoOverflow(flag2);
        return 1L << i;
_L4:
        if (i >= 64)
        {
            flag2 = false;
        }
        MathPreconditions.checkNoOverflow(flag2);
        if ((i & 1) == 0)
        {
            return 1L << i;
        } else
        {
            return -1L << i;
        }
_L2:
        long l1 = 1L;
        do
        {
            switch (i)
            {
            default:
                long l2 = l1;
                if ((i & 1) != 0)
                {
                    l2 = checkedMultiply(l1, l);
                }
                int j = i >> 1;
                l1 = l2;
                i = j;
                if (j > 0)
                {
                    boolean flag3;
                    if (0xffffffff4afb0ccdL <= l && l <= 0xb504f333L)
                    {
                        flag3 = true;
                    } else
                    {
                        flag3 = false;
                    }
                    MathPreconditions.checkNoOverflow(flag3);
                    l *= l;
                    l1 = l2;
                    i = j;
                }
                break;

            case 0: // '\0'
                return l1;

            case 1: // '\001'
                return checkedMultiply(l1, l);
            }
        } while (true);
    }

    public static long checkedSubtract(long l, long l1)
    {
        boolean flag1 = true;
        long l2 = l - l1;
        boolean flag;
        if ((l ^ l1) >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((l ^ l2) < 0L)
        {
            flag1 = false;
        }
        MathPreconditions.checkNoOverflow(flag1 | flag);
        return l2;
    }

    public static long divide(long l, long l1, RoundingMode roundingmode)
    {
        long l2;
        long l3;
        Preconditions.checkNotNull(roundingmode);
        l2 = l / l1;
        l3 = l - l1 * l2;
        if (l3 != 0L) goto _L2; else goto _L1
_L1:
        return l2;
_L2:
        int i = (int)((l ^ l1) >> 63) | 1;
        static class _cls1
        {

            static final int $SwitchMap$java$math$RoundingMode[];

            static 
            {
                $SwitchMap$java$math$RoundingMode = new int[RoundingMode.values().length];
                try
                {
                    $SwitchMap$java$math$RoundingMode[RoundingMode.UNNECESSARY.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror7) { }
                try
                {
                    $SwitchMap$java$math$RoundingMode[RoundingMode.DOWN.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror6) { }
                try
                {
                    $SwitchMap$java$math$RoundingMode[RoundingMode.FLOOR.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror5) { }
                try
                {
                    $SwitchMap$java$math$RoundingMode[RoundingMode.UP.ordinal()] = 4;
                }
                catch (NoSuchFieldError nosuchfielderror4) { }
                try
                {
                    $SwitchMap$java$math$RoundingMode[RoundingMode.CEILING.ordinal()] = 5;
                }
                catch (NoSuchFieldError nosuchfielderror3) { }
                try
                {
                    $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_DOWN.ordinal()] = 6;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_UP.ordinal()] = 7;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    $SwitchMap$java$math$RoundingMode[RoundingMode.HALF_EVEN.ordinal()] = 8;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        _cls1..SwitchMap.java.math.RoundingMode[roundingmode.ordinal()];
        JVM INSTR tableswitch 1 8: default 96
    //                   1 104
    //                   2 119
    //                   3 163
    //                   4 140
    //                   5 146
    //                   6 180
    //                   7 180
    //                   8 180;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L9 _L9
_L9:
        break MISSING_BLOCK_LABEL_180;
_L7:
        break; /* Loop/switch isn't completed */
_L3:
        throw new AssertionError();
_L4:
        boolean flag;
        boolean flag3;
        if (l3 == 0L)
        {
            flag3 = true;
        } else
        {
            flag3 = false;
        }
        MathPreconditions.checkRoundingUnnecessary(flag3);
_L5:
        flag = false;
_L11:
        if (flag)
        {
            return l2 + (long)i;
        }
        if (true) goto _L1; else goto _L10
_L10:
        flag = true;
          goto _L11
_L8:
        if (i > 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L11
_L6:
        if (i < 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L11
        l = Math.abs(l3);
        l -= Math.abs(l1) - l;
        if (l == 0L)
        {
            boolean flag1;
            boolean flag2;
            if (roundingmode == RoundingMode.HALF_UP)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            if (roundingmode == RoundingMode.HALF_EVEN)
            {
                flag1 = true;
            } else
            {
                flag1 = false;
            }
            if ((1L & l2) != 0L)
            {
                flag2 = true;
            } else
            {
                flag2 = false;
            }
            flag |= flag2 & flag1;
        } else
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
          goto _L11
    }

    public static long factorial(int i)
    {
        MathPreconditions.checkNonNegative("n", i);
        if (i < factorials.length)
        {
            return factorials[i];
        } else
        {
            return 0x7fffffffffffffffL;
        }
    }

    static boolean fitsInInt(long l)
    {
        return (long)(int)l == l;
    }

    public static long gcd(long l, long l1)
    {
        MathPreconditions.checkNonNegative("a", l);
        MathPreconditions.checkNonNegative("b", l1);
        long l2;
        if (l == 0L)
        {
            l2 = l1;
        } else
        {
            l2 = l;
            if (l1 != 0L)
            {
                int i = Long.numberOfTrailingZeros(l);
                long l3 = l >> i;
                int j = Long.numberOfTrailingZeros(l1);
                l = l1 >> j;
                for (l1 = l3; l1 != l; l1 = l3 >> Long.numberOfTrailingZeros(l3))
                {
                    l3 = l1 - l;
                    l1 = l3 & l3 >> 63;
                    l3 = l3 - l1 - l1;
                    l += l1;
                }

                return l1 << Math.min(i, j);
            }
        }
        return l2;
    }

    public static boolean isPowerOfTwo(long l)
    {
        boolean flag1 = true;
        boolean flag;
        if (l > 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        if ((l - 1L & l) != 0L)
        {
            flag1 = false;
        }
        return flag1 & flag;
    }

    static int lessThanBranchFree(long l, long l1)
    {
        return (int)(~~(l - l1) >>> 63);
    }

    public static int log10(long l, RoundingMode roundingmode)
    {
        MathPreconditions.checkPositive("x", l);
        int i = log10Floor(l);
        long l1 = powersOf10[i];
        switch (_cls1..SwitchMap.java.math.RoundingMode[roundingmode.ordinal()])
        {
        default:
            throw new AssertionError();

        case 1: // '\001'
            boolean flag;
            if (l == l1)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            MathPreconditions.checkRoundingUnnecessary(flag);
            // fall through

        case 2: // '\002'
        case 3: // '\003'
            return i;

        case 4: // '\004'
        case 5: // '\005'
            return i + lessThanBranchFree(l1, l);

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            return i + lessThanBranchFree(halfPowersOf10[i], l);
        }
    }

    static int log10Floor(long l)
    {
        byte byte0 = maxLog10ForLeadingZeros[Long.numberOfLeadingZeros(l)];
        return byte0 - lessThanBranchFree(l, powersOf10[byte0]);
    }

    public static int log2(long l, RoundingMode roundingmode)
    {
        MathPreconditions.checkPositive("x", l);
        int i;
        switch (_cls1..SwitchMap.java.math.RoundingMode[roundingmode.ordinal()])
        {
        default:
            throw new AssertionError("impossible");

        case 1: // '\001'
            MathPreconditions.checkRoundingUnnecessary(isPowerOfTwo(l));
            // fall through

        case 2: // '\002'
        case 3: // '\003'
            return 63 - Long.numberOfLeadingZeros(l);

        case 4: // '\004'
        case 5: // '\005'
            return 64 - Long.numberOfLeadingZeros(l - 1L);

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            i = Long.numberOfLeadingZeros(l);
            break;
        }
        return lessThanBranchFree(0xb504f333f9de6484L >>> i, l) + (63 - i);
    }

    public static long mean(long l, long l1)
    {
        return (l & l1) + ((l ^ l1) >> 1);
    }

    public static int mod(long l, int i)
    {
        return (int)mod(l, i);
    }

    public static long mod(long l, long l1)
    {
        if (l1 <= 0L)
        {
            throw new ArithmeticException("Modulus must be positive");
        }
        l %= l1;
        if (l >= 0L)
        {
            return l;
        } else
        {
            return l + l1;
        }
    }

    static long multiplyFraction(long l, long l1, long l2)
    {
        if (l == 1L)
        {
            return l1 / l2;
        } else
        {
            long l3 = gcd(l, l2);
            l /= l3;
            return (l1 / (l2 / l3)) * l;
        }
    }

    public static long pow(long l, int i)
    {
        long l1;
        l1 = 0L;
        MathPreconditions.checkNonNegative("exponent", i);
        if (-2L > l || l > 2L) goto _L2; else goto _L1
_L1:
        (int)l;
        JVM INSTR tableswitch -2 2: default 64
    //                   -2 104
    //                   -1 80
    //                   0 72
    //                   1 76
    //                   2 90;
           goto _L3 _L4 _L5 _L6 _L7 _L8
_L3:
        throw new AssertionError();
_L6:
        if (i != 0) goto _L9; else goto _L7
_L7:
        return 1L;
_L9:
        return 0L;
_L5:
        if ((i & 1) == 0) goto _L7; else goto _L10
_L10:
        return -1L;
_L8:
        l = l1;
        if (i < 64)
        {
            l = 1L << i;
        }
        return l;
_L4:
        if (i < 64)
        {
            if ((i & 1) == 0)
            {
                return 1L << i;
            } else
            {
                return -(1L << i);
            }
        } else
        {
            return 0L;
        }
_L2:
        long l2 = 1L;
        do
        {
            switch (i)
            {
            default:
                long l3;
                if ((i & 1) == 0)
                {
                    l3 = 1L;
                } else
                {
                    l3 = l;
                }
                l2 *= l3;
                l *= l;
                i >>= 1;
                break;

            case 0: // '\0'
                return l2;

            case 1: // '\001'
                return l2 * l;
            }
        } while (true);
    }

    public static long sqrt(long l, RoundingMode roundingmode)
    {
        MathPreconditions.checkNonNegative("x", l);
        if (!fitsInInt(l)) goto _L2; else goto _L1
_L1:
        long l1 = IntMath.sqrt((int)l, roundingmode);
_L4:
        return l1;
_L2:
        long l3 = (long)Math.sqrt(l);
        long l4 = l3 * l3;
        switch (_cls1..SwitchMap.java.math.RoundingMode[roundingmode.ordinal()])
        {
        default:
            throw new AssertionError();

        case 1: // '\001'
            boolean flag;
            if (l4 == l)
            {
                flag = true;
            } else
            {
                flag = false;
            }
            MathPreconditions.checkRoundingUnnecessary(flag);
            return l3;

        case 2: // '\002'
        case 3: // '\003'
            l1 = l3;
            if (l < l4)
            {
                return l3 - 1L;
            }
            break;

        case 4: // '\004'
        case 5: // '\005'
            l1 = l3;
            if (l > l4)
            {
                return l3 + 1L;
            }
            break;

        case 6: // '\006'
        case 7: // '\007'
        case 8: // '\b'
            int i;
            long l2;
            if (l < l4)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            l2 = l3 - (long)i;
            return l2 + (long)lessThanBranchFree(l2 * l2 + l2, l);
        }
        if (true) goto _L4; else goto _L3
_L3:
    }

    static 
    {
        long al[] = {
            0x2b5343fd6a30L, 2L, 0x273abcL, 0xca2b9d9L, 0xdf8286ccL
        };
        millerRabinBaseSets = (new long[][] {
            new long[] {
                0x473f6L, 0x1c1111acd0b9428L
            }, new long[] {
                0x34c91838L, 0xa10ad7d5c6610c1L, 0x318a8c12ce9c70e7L
            }, new long[] {
                0x3fc6e038e0L, 15L, 0x1b6ebec62L, 0x386c87553e12cL
            }, al, new long[] {
                0x1c6b470864f682L, 2L, 0x3c1c7396f6dL, 0x2142e2e3f22de5cL, 0x297105b6b7b29ddL, 0x370eb221a5f176ddL
            }, new long[] {
                0x81f23f390affe88L, 2L, 0x70722e8f5cd0L, 0x20cd6bd5ace2d1L, 0x9bbc940c751630L, 0xa90404784bfcb4dL, 0x1189b3f265c2b0c7L
            }, new long[] {
                0x7fffffffffffffffL, 2L, 325L, 9375L, 28178L, 0x6e0d7L, 0x953d18L, 0x6b0191feL
            }
        });
    }
}
