// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.widgetpool.panel.palettesPanel;


public final class  extends Enum
{

    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    public static final h e;
    public static final h f;
    public static final h g;
    public static final h h;
    private static final h i[];

    public static int a( )
    {
        if ( == a)
        {
            return 0;
        }
        if ( == b)
        {
            return 1;
        }
        if ( == c)
        {
            return 2;
        }
        if ( == g)
        {
            return 3;
        }
        if ( == d)
        {
            return 4;
        }
        if ( == e)
        {
            return 5;
        }
        if ( == f)
        {
            return 6;
        }
        return  != h ? -1 : 7;
    }

    public static h a(int j)
    {
        switch (j)
        {
        default:
            return h;

        case 0: // '\0'
            return a;

        case 1: // '\001'
            return b;

        case 2: // '\002'
            return c;

        case 3: // '\003'
            return g;

        case 4: // '\004'
            return d;

        case 5: // '\005'
            return e;

        case 6: // '\006'
            return f;

        case 7: // '\007'
            return h;
        }
    }

    public static boolean a(int j, int k)
    {
        return j == 5;
    }

    public static boolean b(h h1)
    {
        return h1 == d || h1 == e || h1 == f || h1 == h;
    }

    public static h valueOf(String s)
    {
        return (h)Enum.valueOf(com/cyberlink/youcammakeup/widgetpool/panel/palettesPanel/PalettesPanel$PaletteGroup, s);
    }

    public static h[] values()
    {
        return (h[])i.clone();
    }

    static 
    {
        a = new <init>("CUSTOM_FOUR", 0);
        b = new <init>("CUSTOM_THREE", 1);
        c = new <init>("CUSTOM_TWO", 2);
        d = new <init>("DEFAULT_FOUR", 3);
        e = new <init>("DEFAULT_THREE", 4);
        f = new <init>("DEFAULT_TWO", 5);
        g = new <init>("CUSTOM_ONE", 6);
        h = new <init>("DEFAULT_ONE", 7);
        i = (new i[] {
            a, b, c, d, e, f, g, h
        });
    }

    private (String s, int j)
    {
        super(s, j);
    }
}
