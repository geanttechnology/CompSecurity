// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.b.b;

import com.shazam.b.a.d;
import java.math.RoundingMode;
import java.util.AbstractList;
import java.util.List;

// Referenced classes of package com.shazam.b.b:
//            f

private static class a extends AbstractList
{

    final List a;
    final int b = 100;

    public Object get(int i)
    {
        int j = size();
        if (i < 0 || i >= j)
        {
            String s;
            if (i < 0)
            {
                s = String.format("%s (%s) must not be negative", new Object[] {
                    "index", Integer.valueOf(i)
                });
            } else
            {
                if (j < 0)
                {
                    throw new IllegalArgumentException((new StringBuilder("negative size: ")).append(j).toString());
                }
                s = String.format("%s (%s) must be less than size (%s)", new Object[] {
                    "index", Integer.valueOf(i), Integer.valueOf(j)
                });
            }
            throw new IndexOutOfBoundsException(s);
        } else
        {
            i = b * i;
            int k = Math.min(b + i, a.size());
            return a.subList(i, k);
        }
    }

    public boolean isEmpty()
    {
        return a.isEmpty();
    }

    public int size()
    {
        RoundingMode roundingmode;
        int i;
        boolean flag;
        boolean flag1;
        boolean flag2;
        int k;
        int i1;
        int j1;
        flag = true;
        flag1 = true;
        flag2 = false;
        i = a.size();
        i1 = b;
        roundingmode = RoundingMode.CEILING;
        d.a(roundingmode);
        if (i1 == 0)
        {
            throw new ArithmeticException("/ by zero");
        }
        k = i / i1;
        j1 = i - i1 * k;
        if (j1 == 0) goto _L2; else goto _L1
_L1:
        int l;
        l = (i ^ i1) >> 31 | 1;
        i = ((flag) ? 1 : 0);
        com.shazam.b.d.a[roundingmode.ordinal()];
        JVM INSTR tableswitch 1 8: default 136
    //                   1 144
    //                   2 171
    //                   3 173
    //                   4 183
    //                   5 195
    //                   6 207
    //                   7 207
    //                   8 207;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L9 _L9
_L6:
        break MISSING_BLOCK_LABEL_173;
_L3:
        throw new AssertionError();
_L4:
        if (j1 == 0)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 0;
        }
        if (i == 0)
        {
            throw new ArithmeticException("mode was UNNECESSARY, but rounding was necessary");
        }
_L5:
        i = 0;
_L10:
        if (i != 0)
        {
            return k + l;
        }
        break; /* Loop/switch isn't completed */
_L7:
        i = ((flag) ? 1 : 0);
        if (l <= 0)
        {
            i = 0;
        }
        continue; /* Loop/switch isn't completed */
_L8:
        i = ((flag) ? 1 : 0);
        if (l >= 0)
        {
            i = 0;
        }
        continue; /* Loop/switch isn't completed */
_L9:
        i = Math.abs(j1);
        int j = i - (Math.abs(i1) - i);
        if (j == 0)
        {
            if (roundingmode != RoundingMode.HALF_UP)
            {
                if (roundingmode == RoundingMode.HALF_EVEN)
                {
                    flag = true;
                } else
                {
                    flag = false;
                }
                if ((k & 1) != 0)
                {
                    j = 1;
                } else
                {
                    j = 0;
                }
                i = ((flag2) ? 1 : 0);
                if ((j & flag) == 0)
                {
                    continue; /* Loop/switch isn't completed */
                }
            }
            i = 1;
        } else
        {
            i = ((flag) ? 1 : 0);
            if (j <= 0)
            {
                i = 0;
            }
        }
        if (true) goto _L10; else goto _L2
_L2:
        return k;
    }

    public Error(List list)
    {
        a = list;
    }
}
