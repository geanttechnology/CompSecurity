// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.apache.commons.math.util;

import org.apache.commons.math.MathRuntimeException;

public final class MathUtils
{

    static final boolean $assertionsDisabled;
    private static final long factorials[] = {
        1L, 1L, 2L, 6L, 24L, 120L, 720L, 5040L, 40320L, 0x58980L, 
        0x375f00L, 0x2611500L, 0x1c8cfc00L, 0x17328cc00L, 0x144c3b2800L, 0x13077775800L, 0x130777758000L, 0x1437eeecd8000L, 0x16beecca730000L, 0x1b02b9306890000L, 
        0x21c3677c82b40000L
    };

    private MathUtils()
    {
    }

    public static int pow(int i, int j)
        throws IllegalArgumentException
    {
        if (j < 0)
        {
            throw MathRuntimeException.createIllegalArgumentException("cannot raise an integral value to a negative power ({0}^{1})", new Object[] {
                Integer.valueOf(i), Integer.valueOf(j)
            });
        }
        int k;
        int l;
        for (k = 1; j != 0; k = l)
        {
            l = k;
            if ((j & 1) != 0)
            {
                l = k * i;
            }
            i *= i;
            j >>= 1;
        }

        return k;
    }

    static 
    {
        boolean flag;
        if (!org/apache/commons/math/util/MathUtils.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }
}
