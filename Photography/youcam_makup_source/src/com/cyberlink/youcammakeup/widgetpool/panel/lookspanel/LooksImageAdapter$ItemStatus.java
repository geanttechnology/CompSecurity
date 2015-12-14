// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.lookspanel;


public final class Y extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static Y valueOf(String s)
    {
        return (Y)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/lookspanel/LooksImageAdapter$ItemStatus, s);
    }

    public static Y[] values()
    {
        return (Y[])f.clone();
    }

    static 
    {
        a = new <init>("Loading", 0);
        b = new <init>("Loaded", 1);
        c = new <init>("Canceled", 2);
        d = new <init>("Error", 3);
        e = new <init>("Init", 4);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private Y(String s, int i)
    {
        super(s, i);
    }
}
