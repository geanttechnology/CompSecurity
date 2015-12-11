// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;


public final class v extends Enum
{

    public static final v a;
    public static final v b;
    private static final v c[];

    private v(String s, int i)
    {
        super(s, i);
    }

    static 
    {
        a = new v("WhiteXOnOpaqueBlack", 0);
        b = new v("WhiteXOnTransparentGrey", 1);
        c = (new v[] {
            a, b
        });
    }
}
