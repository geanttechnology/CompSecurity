// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.internal.util;


public final class b extends Enum
{

    public static final a a;
    private static final a c[];
    int b;

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/facebook/ads/internal/util/b$b, s);
    }

    public static b[] values()
    {
        return (b[])c.clone();
    }

    static 
    {
        a = new <init>("LOADING_AD", 0, 0);
        c = (new c[] {
            a
        });
    }

    private (String s, int i, int j)
    {
        super(s, i);
        b = j;
    }
}
