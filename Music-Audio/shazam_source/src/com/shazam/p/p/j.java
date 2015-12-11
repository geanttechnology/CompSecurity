// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.p.p;

import com.shazam.b.e.a;

public final class j extends Enum
{

    public static final j a;
    public static final j b;
    private static final j e[];
    public final String c;
    public final String d;

    private j(String s, int i, String s1, String s2)
    {
        super(s, i);
        c = s1;
        d = s2;
    }

    public static j a(String s)
    {
        if (!com.shazam.b.e.a.a(s))
        {
            j aj[] = values();
            int k = aj.length;
            int i = 0;
            while (i < k) 
            {
                j j1 = aj[i];
                if (j1.c.equalsIgnoreCase(s))
                {
                    return j1;
                }
                i++;
            }
        }
        return null;
    }

    public static j valueOf(String s)
    {
        return (j)Enum.valueOf(com/shazam/p/p/j, s);
    }

    public static j[] values()
    {
        return (j[])e.clone();
    }

    static 
    {
        a = new j("SHOW_MORE_ARTISTS", 0, "more_artists", "moreartists");
        b = new j("SHOW_MORE_SONGS", 1, "more_songs", "moresongs");
        e = (new j[] {
            a, b
        });
    }
}
