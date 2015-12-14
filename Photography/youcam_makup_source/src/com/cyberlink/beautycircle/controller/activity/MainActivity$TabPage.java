// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.beautycircle.controller.activity;


public final class index extends Enum
{

    public static final g a;
    public static final g b;
    public static final g c;
    public static final g d;
    public static final g e;
    public static final g f;
    public static final g g;
    private static final g h[];
    public final int index;

    public static index valueOf(String s)
    {
        return (index)Enum.valueOf(com/cyberlink/beautycircle/controller/activity/MainActivity$TabPage, s);
    }

    public static index[] values()
    {
        return (index[])h.clone();
    }

    static 
    {
        a = new <init>("INVALID", 0, -1);
        b = new <init>("FEED", 1, 0);
        c = new <init>("DISCOVERY", 2, 1);
        d = new <init>("PRODUCTS", 3, 2);
        e = new <init>("NOTIFICATIONS", 4, 3);
        f = new <init>("ME", 5, 4);
        g = new <init>("DEVELOPER", 6, 5);
        h = (new h[] {
            a, b, c, d, e, f, g
        });
    }

    private I(String s, int i, int j)
    {
        super(s, i);
        index = j;
    }
}
