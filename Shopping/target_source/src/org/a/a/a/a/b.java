// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.a.a.a.a;


public final class b extends Enum
{

    public static final b a;
    public static final b b;
    public static final b c;
    private static final b d[];

    private b(String s, int i)
    {
        super(s, i);
    }

    public static b valueOf(String s)
    {
        return (b)Enum.valueOf(org/a/a/a/a/b, s);
    }

    public static b[] values()
    {
        return (b[])d.clone();
    }

    static 
    {
        a = new b("STRICT", 0);
        b = new b("BROWSER_COMPATIBLE", 1);
        c = new b("RFC6532", 2);
        d = (new b[] {
            a, b, c
        });
    }
}
