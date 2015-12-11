// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.android.d;


public final class e extends Enum
{

    public static final e a;
    public static final e b;
    public static final e c;
    private static final e d[];

    private e(String s, int i)
    {
        super(s, i);
    }

    public static e a(int i)
    {
        e ae[] = values();
        if (i < 0 || i >= ae.length)
        {
            return b;
        } else
        {
            return ae[i];
        }
    }

    public static e valueOf(String s)
    {
        return (e)Enum.valueOf(com/smule/android/d/e, s);
    }

    public static e[] values()
    {
        return (e[])d.clone();
    }

    static 
    {
        a = new e("PURCHASED", 0);
        b = new e("CANCELED", 1);
        c = new e("REFUNDED", 2);
        d = (new e[] {
            a, b, c
        });
    }
}
