// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.math;

import com.google.common.primitives.UnsignedLongs;

// Referenced classes of package com.google.common.math:
//            LongMath

private static abstract class <init> extends Enum
{

    private static final LARGE $VALUES[];
    public static final LARGE LARGE;
    public static final LARGE SMALL;

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
        squareMod squaremod;
        if (l1 <= 0xb504f333L)
        {
            squaremod = SMALL;
        } else
        {
            squaremod = LARGE;
        }
        return squaremod.testWitness(l, l1);
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

    public static squareMod valueOf(String s)
    {
        return (squareMod)Enum.valueOf(com/google/common/math/LongMath$MillerRabinTester, s);
    }

    public static squareMod[] values()
    {
        return (squareMod[])$VALUES.clone();
    }

    abstract long mulMod(long l, long l1, long l2);

    abstract long squareMod(long l, long l1);

    static 
    {
        SMALL = new LongMath.MillerRabinTester("SMALL", 0) {

            long mulMod(long l, long l1, long l2)
            {
                return (l * l1) % l2;
            }

            long squareMod(long l, long l1)
            {
                return (l * l) % l1;
            }

        };
        LARGE = new LongMath.MillerRabinTester("LARGE", 1) {

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
        $VALUES = (new .VALUES[] {
            SMALL, LARGE
        });
    }

    private _cls2(String s, int i)
    {
        super(s, i);
    }

    _cls2(String s, int i, _cls2 _pcls2)
    {
        this(s, i);
    }
}
