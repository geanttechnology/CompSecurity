// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.wishabi.flipp.content;


public final class f extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    private static final f e[];
    public final String d;

    private f(String s, int i, String s1)
    {
        super(s, i);
        d = s1;
    }

    public static f a(String s)
    {
        f af[] = values();
        int j = af.length;
        for (int i = 0; i < j; i++)
        {
            f f1 = af[i];
            if (f1.d.equals(s))
            {
                return f1;
            }
        }

        return null;
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/wishabi/flipp/content/f, s);
    }

    public static f[] values()
    {
        return (f[])e.clone();
    }

    static 
    {
        a = new f("AMOUNT_OFF", 0, "amountoff");
        b = new f("PERCENT_OFF", 1, "percentoff");
        c = new f("BUY_X_GET_Y", 2, "buyxgety");
        e = (new f[] {
            a, b, c
        });
    }
}
