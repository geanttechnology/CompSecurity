// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.shazam.android.advert.a;


public final class f extends Enum
{

    public static final f a;
    public static final f b;
    public static final f c;
    public static final f d;
    private static final f f[];
    private final String e;

    private f(String s, int i, String s1)
    {
        super(s, i);
        e = s1;
    }

    public static f a(String s)
    {
        f af[] = values();
        int j = af.length;
        for (int i = 0; i < j; i++)
        {
            f f1 = af[i];
            if (f1.e.equals(s))
            {
                return f1;
            }
        }

        return d;
    }

    public static f valueOf(String s)
    {
        return (f)Enum.valueOf(com/shazam/android/advert/a/f, s);
    }

    public static f[] values()
    {
        return (f[])f.clone();
    }

    static 
    {
        a = new f("ACTIVE", 0, "active");
        b = new f("LOADING", 1, "loading");
        c = new f("UNKNOWN", 2, "unknown");
        d = new f("NONE", 3, "none");
        f = (new f[] {
            a, b, c, d
        });
    }
}
