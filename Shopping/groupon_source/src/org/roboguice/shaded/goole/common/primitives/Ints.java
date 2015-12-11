// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.roboguice.shaded.goole.common.primitives;


public final class Ints
{

    public static int compare(int i, int j)
    {
        if (i < j)
        {
            return -1;
        }
        return i <= j ? 0 : 1;
    }

    public static int saturatedCast(long l)
    {
        if (l > 0x7fffffffL)
        {
            return 0x7fffffff;
        }
        if (l < 0xffffffff80000000L)
        {
            return 0x80000000;
        } else
        {
            return (int)l;
        }
    }
}
