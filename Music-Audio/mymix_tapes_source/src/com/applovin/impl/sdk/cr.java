// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;


final class cr extends Enum
{

    public static final cr a;
    public static final cr b;
    public static final cr c;
    private static final cr d[];

    private cr(String s, int i)
    {
        super(s, i);
    }

    static 
    {
        a = new cr("MAIN", 0);
        b = new cr("BACKGROUND", 1);
        c = new cr("POSTBACKS", 2);
        d = (new cr[] {
            a, b, c
        });
    }
}
