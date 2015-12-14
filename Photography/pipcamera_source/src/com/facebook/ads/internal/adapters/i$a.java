// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.adapters;


public final class  extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static  a(int i)
    {
        if (i == 2)
        {
            return b;
        } else
        {
            return a;
        }
    }

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/facebook/ads/internal/adapters/i$a, s);
    }

    public static a[] values()
    {
        return (a[])c.clone();
    }

    static 
    {
        a = new <init>("VERTICAL", 0);
        b = new <init>("HORIZONTAL", 1);
        c = (new c[] {
            a, b
        });
    }

    private (String s, int i)
    {
        super(s, i);
    }
}
