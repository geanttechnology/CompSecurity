// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.ag.h;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    public static final b e;
    public static final b f;
    public static final b g;
    private static final b k[];
    public final String h;
    public final int i;
    public final boolean j;

    private b(String s, int l, String s1, int i1, boolean flag)
    {
        super(s, l);
        h = s1;
        i = i1;
        j = flag;
    }

    public static b a(String s)
    {
        b ab[] = values();
        int i1 = ab.length;
        for (int l = 0; l < i1; l++)
        {
            b b1 = ab[l];
            if (b1.h.equals(s))
            {
                return b1;
            }
        }

        return a;
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/shazam/android/ag/h/b, s);
    }

    public static b[] values()
    {
        return (b[])k.clone();
    }

    static 
    {
        a = new b("FIRST_LAUNCH", 0, "first_launch", 0x7f11015c, false);
        b = new b("TAGGING", 1, "tagging", 0x7f11015c, false);
        c = new b("MATCH", 2, "match", -1, true);
        d = new b("NO_MATCH", 3, "no_match", 0x7f11015d, true);
        e = new b("UNSUBMITTED", 4, "unsubmitted", 0x7f11015e, true);
        f = new b("ERROR", 5, "error", 0x7f11015f, true);
        g = new b("CLOSED", 6, "closed", -1, true);
        k = (new b[] {
            a, b, c, d, e, f, g
        });
    }
}
