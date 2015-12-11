// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.c.a.b.d;

import java.util.Locale;

public final class c extends Enum
{

    public static final c a;
    public static final c b;
    public static final c c;
    public static final c d;
    public static final c e;
    public static final c f;
    public static final c g;
    private static final c j[];
    private String h;
    private String i;

    private c(String s, int k, String s1)
    {
        super(s, k);
        h = s1;
        i = (new StringBuilder()).append(s1).append("://").toString();
    }

    public static c a(String s)
    {
        if (s != null)
        {
            c ac[] = values();
            int l = ac.length;
            for (int k = 0; k < l; k++)
            {
                c c1 = ac[k];
                if (c1.d(s))
                {
                    return c1;
                }
            }

        }
        return g;
    }

    private boolean d(String s)
    {
        return s.toLowerCase(Locale.US).startsWith(i);
    }

    public static c valueOf(String s)
    {
        return (c)Enum.valueOf(com/c/a/b/d/c, s);
    }

    public static c[] values()
    {
        return (c[])j.clone();
    }

    public String b(String s)
    {
        return (new StringBuilder()).append(i).append(s).toString();
    }

    public String c(String s)
    {
        if (!d(s))
        {
            throw new IllegalArgumentException(String.format("URI [%1$s] doesn't have expected scheme [%2$s]", new Object[] {
                s, h
            }));
        } else
        {
            return s.substring(i.length());
        }
    }

    static 
    {
        a = new c("HTTP", 0, "http");
        b = new c("HTTPS", 1, "https");
        c = new c("FILE", 2, "file");
        d = new c("CONTENT", 3, "content");
        e = new c("ASSETS", 4, "assets");
        f = new c("DRAWABLE", 5, "drawable");
        g = new c("UNKNOWN", 6, "");
        j = (new c[] {
            a, b, c, d, e, f, g
        });
    }
}
