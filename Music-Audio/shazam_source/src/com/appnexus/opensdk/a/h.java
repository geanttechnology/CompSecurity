// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.a;


public final class h extends Enum
{

    public static final h a;
    public static final h b;
    public static final h c;
    public static final h d;
    private static final h e[];

    private h(String s, int i)
    {
        super(s, i);
    }

    public static h a(int i)
    {
        h ah[] = values();
        int k = ah.length;
        for (int j = 0; j < k; j++)
        {
            h h1 = ah[j];
            if (h1.ordinal() == i)
            {
                return h1;
            }
        }

        return a;
    }

    public static h valueOf(String s)
    {
        return (h)Enum.valueOf(com/appnexus/opensdk/a/h, s);
    }

    public static h[] values()
    {
        return (h[])e.clone();
    }

    static 
    {
        a = new h("UP", 0);
        b = new h("DOWN", 1);
        c = new h("RIGHT", 2);
        d = new h("LEFT", 3);
        e = (new h[] {
            a, b, c, d
        });
    }
}
