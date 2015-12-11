// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.b;


public final class ap extends Enum
{

    public static final ap a;
    public static final ap b;
    private static final ap d[];
    private final int c;

    private ap(String s, int i, int j)
    {
        super(s, i);
        c = j;
    }

    public static ap a(int i)
    {
        ap aap[] = values();
        int k = aap.length;
        for (int j = 0; j < k; j++)
        {
            ap ap1 = aap[j];
            if (ap1.c == i)
            {
                return ap1;
            }
        }

        return b;
    }

    public static ap valueOf(String s)
    {
        return (ap)Enum.valueOf(com/wishabi/flipp/b/ap, s);
    }

    public static ap[] values()
    {
        return (ap[])d.clone();
    }

    static 
    {
        a = new ap("SUCCESS", 0, 200);
        b = new ap("ERROR", 1, -1);
        d = (new ap[] {
            a, b
        });
    }
}
