// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.a;


public final class i extends Enum
{

    public static final i a;
    public static final i b;
    public static final i c;
    public static final i d;
    public static final i e;
    public static final i f;
    private static final i g[];

    private i(String s, int j)
    {
        super(s, j);
    }

    public static i a(int j)
    {
        i ai[] = values();
        int i1 = ai.length;
        for (int l = 0; l < i1; l++)
        {
            i k = ai[l];
            if (k.ordinal() == j)
            {
                return k;
            }
        }

        return a;
    }

    public static i valueOf(String s)
    {
        return (i)Enum.valueOf(com/appnexus/opensdk/a/i, s);
    }

    public static i[] values()
    {
        return (i[])g.clone();
    }

    static 
    {
        a = new i("NONE", 0);
        b = new i("RANDOM", 1);
        c = new i("FADE", 2);
        d = new i("PUSH", 3);
        e = new i("MOVEIN", 4);
        f = new i("REVEAL", 5);
        g = (new i[] {
            a, b, c, d, e, f
        });
    }
}
