// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.math;

import com.google.common.primitives.UnsignedLongs;

// Referenced classes of package com.google.common.math:
//            LongMath

static final class nit> extends nit>
{

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

    _cls9(String s, int i)
    {
        super(s, i, null);
    }
}
