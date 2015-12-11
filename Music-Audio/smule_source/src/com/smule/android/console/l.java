// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.console;


public final class l extends Enum
{

    public static final l a;
    public static final l b;
    public static final l c;
    public static final l d;
    private static final l f[];
    private final int e;

    private l(String s, int i, int j)
    {
        super(s, i);
        e = j;
    }

    public static l a(int i)
    {
        l al[] = values();
        int k = al.length;
        for (int j = 0; j < k; j++)
        {
            l l1 = al[j];
            if (l1.a() == i)
            {
                return l1;
            }
        }

        return a;
    }

    public static l valueOf(String s)
    {
        return (l)Enum.valueOf(com/smule/android/console/l, s);
    }

    public static l[] values()
    {
        return (l[])f.clone();
    }

    public int a()
    {
        return e;
    }

    static 
    {
        a = new l("UNKNOWN", 0, -1);
        b = new l("BIG", 1, 20);
        c = new l("MEDIUM", 2, 16);
        d = new l("SMALL", 3, 12);
        f = (new l[] {
            a, b, c, d
        });
    }
}
