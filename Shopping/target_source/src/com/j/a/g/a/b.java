// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.j.a.g.a;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    public static final b d;
    private static final b e[];

    private b(String s, int i)
    {
        super(s, i);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(com/j/a/g/a/b, s);
    }

    public static b[] values()
    {
        return (b[])e.clone();
    }

    static 
    {
        a = new b("finished", 0);
        b = new b("failed", 1);
        c = new b("cancelled", 2);
        d = new b("notDone", 3);
        e = (new b[] {
            a, b, c, d
        });
    }
}
