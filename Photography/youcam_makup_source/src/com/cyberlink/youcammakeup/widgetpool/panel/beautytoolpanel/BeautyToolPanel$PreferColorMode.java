// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.beautytoolpanel;


public final class a extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    public static final e d;
    public static final e e;
    private static final e f[];

    public static a valueOf(String s)
    {
        return (a)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/beautytoolpanel/BeautyToolPanel$PreferColorMode, s);
    }

    public static a[] values()
    {
        return (a[])f.clone();
    }

    static 
    {
        a = new <init>("SWITCHER", 0);
        b = new <init>("MAKEUP_TOOL", 1);
        c = new <init>("MENU", 2);
        d = new <init>("MENU_PATTERN", 3);
        e = new <init>("ACCESSORY_MENU", 4);
        f = (new f[] {
            a, b, c, d, e
        });
    }

    private a(String s, int i)
    {
        super(s, i);
    }
}
