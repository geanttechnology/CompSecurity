// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;


public final class Y extends Enum
{

    public static final b a;
    public static final b b;
    private static final b c[];

    public static Y valueOf(String s)
    {
        return (Y)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/palettesPanel/PalettesPanel$DismissType, s);
    }

    public static Y[] values()
    {
        return (Y[])c.clone();
    }

    static 
    {
        a = new <init>("USER_CANCELLED", 0);
        b = new <init>("SELECT_PALETTE", 1);
        c = (new c[] {
            a, b
        });
    }

    private Y(String s, int i)
    {
        super(s, i);
    }
}
