// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.f;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    private static final b e[];
    private final int d;

    private b(String s, int i, int j)
    {
        super(s, i);
        d = j;
    }

    public static b a(int i)
    {
        b ab[] = values();
        int k = ab.length;
        for (int j = 0; j < k; j++)
        {
            b b1 = ab[j];
            if (b1.a() == i)
            {
                return b1;
            }
        }

        throw new RuntimeException((new StringBuilder()).append("Invalid value: ").append(i).toString());
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/smule/android/f/b, s);
    }

    public static b[] values()
    {
        return (b[])e.clone();
    }

    public int a()
    {
        return d;
    }

    static 
    {
        a = new b("NEVER_ASKED", 0, -1);
        b = new b("NO", 1, 0);
        c = new b("YES", 2, 1);
        e = (new b[] {
            a, b, c
        });
    }
}
